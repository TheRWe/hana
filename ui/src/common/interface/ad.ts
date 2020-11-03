import { TCommonData } from "./common";

export type TAd = TCommonData & {
  isValId: boolean,
  type: string,
  salary: number,
};