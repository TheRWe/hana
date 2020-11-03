import { TCommonData, TDate } from "./common";

export type TEvent = TCommonData & {
  rating: number,
  numberOfRatings: number,
  dateFrom: TDate,
  dateTo: TDate,
  moreInfo: string,
  type: string,
};
