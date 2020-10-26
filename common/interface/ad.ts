import { TCommonData, TCommonDataNew } from "./common";

export enum TAdCategory {
  Supply = "Supply",
  Demand = "Demand",
}

export type TAd = TCommonData & {
  isValId: boolean,
  category: TAdCategory,
  type: string,
  salary: number,
};

export type TAdNew = TCommonDataNew & {
  isValId: boolean,
  category: TAdCategory,
  type: string,
  salary: number,
}