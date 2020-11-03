import { TAction, TCommonData, TCommonDataNew, TCommonGetListPostRequest, TDate, TGenericResponse, TId, TRate, TReport } from "./common";

export type TEvent = TCommonData & {
  rating: number,
  numberOfRatings: number,
  dateFrom: TDate,
  dateTo: TDate,
  cost: number,
  type: string,
};

export type TEventNewUpdate = TCommonDataNew & {
  rating: number,
  numberOfRatings: number,
  dateFrom: TDate,
  dateTo: TDate,
  cost: number,
  type: string,
};

// 1. get event by id
export type TEventGetByIdPostRequest = TId;
export type TEventGetByIdPostResponse = TEvent;
export type TEventGetByIdPostAction = TAction<TEventGetByIdPostRequest, TEventGetByIdPostResponse>;

// 2. new event
export type TEventPutRequest = TEventNewUpdate;
export type TEventPutResponse = TGenericResponse;
export type TEventPutAction = TAction<TEventPutRequest, TEventPutResponse>;

// 3. update event
export type TEventUpdatePostRequest = TEventNewUpdate;
export type TEventUpdatePostResponse = TGenericResponse;
export type TEventUpdatePostAction = TAction<TEventUpdatePostRequest, TEventUpdatePostResponse>;

// 4. delete event
export type TEventDeleteRequest = TId;
export type TEventDeleteResponse = TGenericResponse;
export type TEventDeleteAction = TAction<TEventDeleteRequest, TEventDeleteResponse>;

// 5. rate event
export type TEventRatePostRequest = TRate;
export type TEventRatePostResponse = TGenericResponse;
export type TEventRatePostAction = TAction<TEventRatePostRequest, TEventRatePostResponse>;

// 6. get more events
export type TEventGetListPostRequest = TCommonGetListPostRequest & {
  ratingFrom?: number,
  ratingTo?: number,
  numberOfRatingsFrom?: number,
  numberOfRatingsTo?: number,
  dateFrom?: TDate,
  dateTo?: TDate,
  type?: string,
  costFrom?: number,
  costTo?: number,
};
export type TEventGetListPostResponse = {
  events: TEvent[],
};
export type TEventGetListPostAction = TAction<TEventGetListPostRequest, TEventGetListPostResponse>;

// 7. report event
export type TEventReportPostRequest = TReport;
export type TEventReportPostResponse = TGenericResponse;
export type TEventReportPostAction = TAction<TEventReportPostRequest, TEventReportPostResponse>;

