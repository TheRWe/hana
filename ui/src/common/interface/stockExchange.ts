import { TAction, TGenericResponse, TId, TReport } from "./common";
import { ResourceInfo, StockExchange, StockExchanges, StockExchangeCreateUpdate, StockExchangesRequest } from "./shared";

// 1. get stock exchange by id
export type TStockExchangeGetByIdPostRequest = TId;
export type TStockExchangeGetByIdPostResponse = StockExchange;
export type TStockExchangeGetByIdPostAction = TAction<TStockExchangeGetByIdPostRequest, TStockExchangeGetByIdPostResponse>;

// 2. new stock exchange
export type TStockExchangePutRequest = StockExchangeCreateUpdate;
export type TStockExchangePutResponse = ResourceInfo;
export type TStockExchangePutAction = TAction<TStockExchangePutRequest, TStockExchangePutResponse>;

// 3. update stock exchange
export type TStockExchangeUpdatePostRequest = StockExchangeCreateUpdate;
export type TStockExchangeUpdatePostResponse = TGenericResponse;
export type TStockExchangeUpdatePostAction = TAction<TStockExchangeUpdatePostRequest, TStockExchangeUpdatePostResponse>;

// 4. delete stock exchange
export type TStockExchangeDeleteRequest = TId;
export type TStockExchangeDeleteResponse = TGenericResponse;
export type TStockExchangeDeleteAction = TAction<TStockExchangeDeleteRequest, TStockExchangeDeleteResponse>;

// 5. get more stock exchanges
export type TStockExchangeGetListPostAction = TAction<StockExchangesRequest, StockExchanges>;

// 6. report stock exchange
export type TStockExchangeReportPostRequest = TReport;
export type TStockExchangeReportPostResponse = TGenericResponse;
export type TStockExchangeReportPostAction = TAction<TStockExchangeReportPostRequest, TStockExchangeReportPostResponse>;