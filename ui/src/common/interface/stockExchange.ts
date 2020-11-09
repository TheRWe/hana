import { TAction } from "./common";
import { ResourceInfo, StockExchange, StockExchanges, StockExchangeCreateUpdate, StockExchangesRequest, Rate, Report } from "./shared";

// 1. get stock exchange by id
export type TStockExchangeGetByIdGetRequest = {};
export type TStockExchangeGetByIdGetResponse = StockExchange;
export type TStockExchangeGetByIdGetAction = TAction<TStockExchangeGetByIdGetRequest, TStockExchangeGetByIdGetResponse>;

// 2. new stock exchange
export type TStockExchangePostRequest = StockExchangeCreateUpdate;
export type TStockExchangePostResponse = ResourceInfo;
export type TStockExchangePostAction = TAction<TStockExchangePostRequest, TStockExchangePostResponse>;

// 3. update stock exchange
export type TStockExchangeUpdatePutRequest = StockExchangeCreateUpdate;
export type TStockExchangeUpdatePutResponse = {};
export type TStockExchangeUpdatePutAction = TAction<TStockExchangeUpdatePutRequest, TStockExchangeUpdatePutResponse>;

// 4. delete stock exchange
export type TStockExchangeDeleteRequest = {};
export type TStockExchangeDeleteResponse = {};
export type TStockExchangeDeleteAction = TAction<TStockExchangeDeleteRequest, TStockExchangeDeleteResponse>;

// 5. rate stock exchange
export type TStockExchangeRatePostRequest = Rate;
export type TStockExchangeRatePostResponse = ResourceInfo;
export type TStockExchangeRatePostAction = TAction<TStockExchangeRatePostRequest, TStockExchangeRatePostResponse>;

// 6. get more stock exchanges
export type TStockExchangeGetListGetAction = TAction<StockExchangesRequest, StockExchanges>;

// 7. report stock exchange
export type TStockExchangeReportPostRequest = Report;
export type TStockExchangeReportPostResponse = ResourceInfo;
export type TStockExchangeReportPostAction = TAction<TStockExchangeReportPostRequest, TStockExchangeReportPostResponse>;