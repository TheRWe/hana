import { TCommonData, TCommonDataNew, TDate } from "./common";

export type TEvent = TCommonData & {
  rating: number,
  numberOfRatings: number,
  dateFrom: TDate,
  dateTo: TDate,
  moreInfo: string,
  type: string,
};

export type TEventNew = TCommonDataNew & {
  rating: number,
  numberOfRatings: number,
  dateFrom: TDate,
  dateTo: TDate,
  moreInfo: string,
  type: string,
};
