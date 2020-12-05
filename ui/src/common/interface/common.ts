
export type TAction<TRequest, TResponse> =
    (req: TRequest) => Promise<TResponse>
    ;