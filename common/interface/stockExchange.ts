import { TAction, TCommonData, TCommonDataNew, TCommonGetListPostRequest, TGenericResponse, TId, TReport } from "./common";

export enum TStockCategory {
  Buy = "Buy",
  Sell = "Sell",
  Exchange = "Exchange",
}

export type TStockExchange = TCommonData & {
  isValid: boolean,
  category: TStockCategory,
  cost: number,
};

export type TStockExchangeNewUpdate = TCommonDataNew & {
  isValid: boolean,
  category: TStockCategory,
  cost: number,
};

// 1. get stock exchange by id
export type TStockExchangeGetByIdPostRequest = TId;
export type TStockExchangeGetByIdPostResponse = TStockExchange;
export type TStockExchangeGetByIdPostAction = TAction<TStockExchangeGetByIdPostRequest, TStockExchangeGetByIdPostResponse>;

// 2. new stock exchange
export type TStockExchangePutRequest = TStockExchangeNewUpdate;
export type TStockExchangePutResponse = TGenericResponse;
export type TStockExchangePutAction = TAction<TStockExchangePutRequest, TStockExchangePutResponse>;

// 3. update stock exchange
export type TStockExchangeUpdatePostRequest = TStockExchangeNewUpdate;
export type TStockExchangeUpdatePostResponse = TGenericResponse;
export type TStockExchangeUpdatePostAction = TAction<TStockExchangeUpdatePostRequest, TStockExchangeUpdatePostResponse>;

// 4. delete stock exchange
export type TStockExchangeDeleteRequest = TId;
export type TStockExchangeDeleteResponse = TGenericResponse;
export type TStockExchangeDeleteAction = TAction<TStockExchangeDeleteRequest, TStockExchangeDeleteResponse>;

// 5. get more stock exchanges
export type TStockExchangeGetListPostRequest = TCommonGetListPostRequest & {
  isValid?: boolean,
  category?: TStockCategory,
  type?: string,
  costFrom?: number,
  costTo?: number,
};
export type TStockExchangeGetListPostResponse = {
  stockExchanges: TStockExchange[],
};
export type TStockExchangeGetListPostAction = TAction<TStockExchangeGetListPostRequest, TStockExchangeGetListPostResponse>;

// 6. report stock exchange
export type TStockExchangeReportPostRequest = TReport;
export type TStockExchangeReportPostResponse = TGenericResponse;
export type TStockExchangeReportPostAction = TAction<TStockExchangeReportPostRequest, TStockExchangeReportPostResponse>;
