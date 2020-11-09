import { TAction, TGenericResponse, TId, TRate, TReport } from "./common";
import { Event, EventCreateUpdate, Events, EventsRequest, ResourceInfo } from "./shared";

// 1. get event by id
export type TEventGetByIdPostRequest = TId;
export type TEventGetByIdPostResponse = Event;
export type TEventGetByIdPostAction = TAction<TEventGetByIdPostRequest, TEventGetByIdPostResponse>;

// 2. new event
export type TEventPutRequest = EventCreateUpdate;
export type TEventPutResponse = ResourceInfo;
export type TEventPutAction = TAction<TEventPutRequest, TEventPutResponse>;

// 3. update event
export type TEventUpdatePostRequest = EventCreateUpdate;
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
export type TEventGetListPostAction = TAction<EventsRequest, Events>;

// 7. report event
export type TEventReportPostRequest = TReport;
export type TEventReportPostResponse = TGenericResponse;
export type TEventReportPostAction = TAction<TEventReportPostRequest, TEventReportPostResponse>;