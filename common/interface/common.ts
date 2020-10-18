export enum EErrorCode {
  NotLoggedIn,
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
