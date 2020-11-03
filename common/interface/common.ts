export enum EErrorCode {
  NotLoggedIn = "NotLoggedIn",
  ElementAlreadyExists = "ElementAlreadyExists",
  NoElementWasFound = "NoElementWasFound",
}

export type TErrorResponse = {
  error: {
    msg: string,
    code?: EErrorCode,
  }
};

export type TAction<TRequest, TResponse> =
  (req: TRequest) => Promise<TResponse>
  ;

export type TTag = {
  id: number,
  name: string,
};

export type TDate = Date;

export type TPlace = {
  name: string,
  latitude: number,
  longitude: number,
};

export type TPhoto = {
  link: string,
};

export type TCommonData = {
  id: number,
  userId: number,
  name: string,
  description: string,
  place?: TPlace,
  photo?: TPhoto,
  tags?: TTag[],
  create: TDate,
};

export type TCommonDataNew = {
  userId: number,
  name: string,
  description: string,
  place?: TPlace,
  photo?: TPhoto,
  tags?: TTag[],
};

export type TGenericResponse = {
  error?: {
    msg: string,
    code?: EErrorCode,
  }
};

export type TId = {
  id: number,
};

export type TReport = TId & {
  msg?: string,
};

export type TRate = {
  rating: number,
};

export type TCommonGetListPostRequest = {
  userId?: number,
  place?: TPlace,
  placeRange?: number,
  createFrom?: TDate,
  createTo?: TDate,
  tags?: TTag[],

  count: number,
  page?: number,
};