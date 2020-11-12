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