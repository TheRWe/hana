import { TAction } from "../common/interface/common";

const HTTP_MULTIPLE_CHOICES = 300;

export enum EHttpMethod {
  GET = "GET",
  POST = "POST",
  PUT = "PUT",
  DELETE = "DELETE",
}

type TFetchOptions = {
  route: string,
  method: EHttpMethod,
  token?: string,
};

export class ErrorCode extends Error {
  public code: number;
  constructor(msg: string, code: number) {
    super(msg);
    this.code = code;
  }
}

// todo: disable debugging / remove after all logics tested
const debugging = true;
let debugFetchID = 0;
const log = (state: string, id: number, method: string, uri: string) => {
  if (debugging)
    // tslint:disable-next-line: no-console
    console.debug(`${method.padEnd(7, " ")} ${id.toString(10).padStart(4, " ")} ${state.padEnd(10, " ")} ${uri}`);
};

// todo: support pass id in url (GET api/article/[hexid])
/** never use fetch in other function than this wrapper!! */
export const withFetch = <TA extends TAction<any, any>>({
  route,
  method,
  token,
}: TFetchOptions) =>
  (async (...req: Parameters<TA>) => {
    const debugID = debugFetchID++;

    const restParams = (method !== EHttpMethod.GET || !req?.[0]) ? ""
      : "?" + Object.keys(req[0])
        .sort()
        .filter(x => req[0][x] !== undefined && req[0][x] !== "")
        .map(x => {
          return `${encodeURIComponent(x)}=${encodeURIComponent(req[0][x])}`;
        })
        .join("&")
      ;
    const uri = `api/${route}${restParams !== "?" ? restParams : ""}`;

    log("start", debugID, method, uri);

    const auth = token ? { "Authorization": "Bearer " + token } : {};

    const resAwaiter = fetch(uri, {
      method,
      headers: {
        "Content-Type": "application/json",
        ...(auth as any),
      },
      ...((req && method !== EHttpMethod.GET) ? { body: JSON.stringify(req[0]) } : {}),
    });

    let resJson: ReturnType<TA> = undefined as any;

    const res = (await resAwaiter);

    if (res.status >= HTTP_MULTIPLE_CHOICES) {
      const text = await res.text();
      log("error", debugID, method, uri);
      throw new ErrorCode(`${res.status} ${text}`, res.status);
    }
    if (res.status === 204) {
        return res;
    }

    // todo: fix better
    try{
      resJson = await res.json();
    }catch(e){
      console.error(e);
    }

    log("done", debugID, method, uri);
    return resJson;
  }) as (...p: Parameters<TA>) => ReturnType<TA>;

