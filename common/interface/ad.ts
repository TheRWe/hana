import { TCommonData } from "./common";

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