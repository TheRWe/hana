import { TAction } from "./common";
import { Event, EventCreateUpdate, Events, EventsRequest, Rate, Report, ResourceInfo } from "./shared";

// 1. get event by id
export type TEventGetByIdGetRequest = {};
export type TEventGetByIdGetResponse = Event;
export type TEventGetByIdGetAction = TAction<TEventGetByIdGetRequest, TEventGetByIdGetResponse>;

// 2. new event
export type TEventPostRequest = EventCreateUpdate;
export type TEventPostResponse = ResourceInfo;
export type TEventPostAction = TAction<TEventPostRequest, TEventPostResponse>;

// 3. update event
export type TEventUpdatePutRequest = EventCreateUpdate;
export type TEventUpdatePutResponse = {};
export type TEventUpdatePutAction = TAction<TEventUpdatePutRequest, TEventUpdatePutResponse>;

// 4. delete event
export type TEventDeleteRequest = {};
export type TEventDeleteResponse = {};
export type TEventDeleteAction = TAction<TEventDeleteRequest, TEventDeleteResponse>;

// 5. rate event
export type TEventRatePostRequest = Rate;
export type TEventRatePostResponse = ResourceInfo;
export type TEventRatePostAction = TAction<TEventRatePostRequest, TEventRatePostResponse>;

// 6. get more events
export type TEventGetListGetAction = TAction<EventsRequest, Events>;

// 7. report event
export type TEventReportPostRequest = Report;
export type TEventReportPostResponse = ResourceInfo;
export type TEventReportPostAction = TAction<TEventReportPostRequest, TEventReportPostResponse>;