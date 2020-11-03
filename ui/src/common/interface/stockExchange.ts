import { TCommonData } from "./common";

export type TStockExchange = TCommonData & {
  isValId: boolean,
  type: string,
  cost: number,
};