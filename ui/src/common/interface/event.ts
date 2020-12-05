import { TAction } from "./common";
import { Event, EventCreateReplace, Events, EventFilters, Rate, Report, ResourceInfo,Pagination } from "./shared";

// 1. get event by id
export type TEventGetByIdGetRequest = {};
export type TEventGetByIdGetResponse = Event;
export type TEventGetByIdGetAction = TAction<TEventGetByIdGetRequest, TEventGetByIdGetResponse>;

// 2. new event
export type TEventPostRequest = EventCreateReplace;
export type TEventPostResponse = ResourceInfo<number>;
export type TEventPostAction = TAction<TEventPostRequest, TEventPostResponse>;

// 3. update event
export type TEventUpdatePutRequest = EventCreateReplace;
export type TEventUpdatePutResponse = {};
export type TEventUpdatePutAction = TAction<TEventUpdatePutRequest, TEventUpdatePutResponse>;

// 4. delete event
export type TEventDeleteRequest = {};
export type TEventDeleteResponse = {};
export type TEventDeleteAction = TAction<TEventDeleteRequest, TEventDeleteResponse>;

// 5. rate event
export type TEventRatePostRequest = Rate;
export type TEventRatePostResponse = ResourceInfo<number>;
export type TEventRatePostAction = TAction<TEventRatePostRequest, TEventRatePostResponse>;

// 6. get more events
export type TEventGetListGetRequest = EventFilters & Pagination;
export type TEventGetListGetResponse = Events;
export type TEventGetListGetAction = TAction<TEventGetListGetRequest, TEventGetListGetResponse>;

// 7. report event
export type TEventReportPostRequest = Report;
export type TEventReportPostResponse = ResourceInfo<number>;
export type TEventReportPostAction = TAction<TEventReportPostRequest, TEventReportPostResponse>;