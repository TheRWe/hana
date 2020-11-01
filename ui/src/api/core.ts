import { EErrorCode, TAction, TErrorResponse } from "../common/interface/common";
import { EHttpMethod } from "sciator-core";

const HTTP_MULTIPLE_CHOICES = 300;

type TFetchOptions = {
  route: string,
  method: EHttpMethod,
};

export class ErrorCode extends Error {
  public code: EErrorCode;
  constructor(msg: string, code: EErrorCode) {
    super(msg);
    this.code = code;
  }
}

// todo: support pass id in url (GET api/article/[hexid])
/** never use fetch in other function than this wrapper!! */
export const withFetch = <TA extends TAction<any, any>>({
  route,
  method,
}: TFetchOptions) =>
  (async (...req: Parameters<TA>) => {
    const resAwaiter = fetch(`api/${route}`, {
      method,
      headers: {
        "Content-Type": "application/json",
      },
      ...(req ? { body: JSON.stringify(req) } : {}),
    });

    let resJson: ReturnType<TA> | TErrorResponse;

    try {
      const res = (await resAwaiter);

      if (res.status >= HTTP_MULTIPLE_CHOICES) {
        const text = await res.text();
        throw new Error(`${res.status} ${text}`);
      }
      resJson = await res.json();
    } catch (e) {
      resJson = { error: { msg: e.toString() } };
    }

    if ("error" in resJson) {
      const { error } = resJson;
      if (error?.code !== undefined) {
        throw new ErrorCode(error.msg, error.code);
      } else {
        throw new Error(error.msg);
      }
    }

    return resJson;
  }) as (...p: Parameters<TA>) => ReturnType<TA>;

