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