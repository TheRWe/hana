import { TCommonData, TCommonDataNew } from "./common";

export enum TStockCategory {
  Buy = "Buy",
  Sell = "Sell",
  Exchange = "Exchange",
}

export type TStockExchange = TCommonData & {
  isValId: boolean,
  category: TStockCategory,
  type: string,
  cost: number,
};

export type TStockExchangeNew = TCommonDataNew & {
  isValId: boolean,
  category: TStockCategory,
  type: string,
  cost: number,
};