import { TAd, TAdNew } from "./ad";
import { TEvent, TEventNew } from "./event";
import { TStockExchange, TStockExchangeNew } from "./stockExchange";
import { TUser, TUserNew } from "./user";

export enum EErrorCode {
  NotLoggedIn = "NotLoggedIn",
  ElementAlreadyExists = "ElementAlreadyExists",
  NoElementWasFound = "NoElementWasFound",
}

export type TErrorResponse = {
  error: {
    msg: string,
    code?: EErrorCode,
  }
};

export type TAction<TRequest, TResponse> =
  (req: TRequest) => Promise<TResponse>
  ;

export type TTag = {
  id: string,
  name: string,
};

/*export type TDate = {
  year: number,
  month: number,
  day: number,
  hour: number,
  minute: number,
};*/
export type TDate = Date;

export type TPlace = {
  name: string,
  latitude: number,
  longitude: number,
};

export type TPhoto = {
  link: string,
};

export type TCommonData = {
  id: string,
  userId: string,
  name: string,
  description: string,
  place?: TPlace,
  photo?: TPhoto,
  tags?: TTag[],
  create: TDate,
};

export type TCommonDataNew = {
  userId: string,
  name: string,
  description: string,
  place?: TPlace,
  photo?: TPhoto,
  tags?: TTag[],
};

// Common Actions
export type TGenericResponse = {
  wasError: boolean,
  error?: {
    msg: string,
    code?: EErrorCode,
  }
};

enum ETypeElement {
  User = "User",
  Event = "Event",
  Ad = "Ad",
  StockExchange = "StockExchange",
}

export type TElementAll = {
  type: ETypeElement,
} & (TUser | TEvent | TAd | TStockExchange);

export type TElementNew = {
  type: ETypeElement,
} & (TUserNew | TEventNew | TAdNew | TStockExchangeNew);

export type TElementId = {
  type: ETypeElement,
  id: string,
};

// 1. get element by Id
export type GetElementByIdGetRequest = TElementId;

export type GetElementByIdGetResponse = (TUser | TEvent | TAd | TStockExchange);

export type GetElementByIdGetAction = TAction<GetElementByIdGetRequest, GetElementByIdGetResponse>;

// 2. new element
export type NewElementGetRequest = TElementNew;

export type NewElementGetResponse = TGenericResponse;

export type NewElementGetAction = TAction<NewElementGetRequest, NewElementGetResponse>;

// 3. update element
export type UpdateElementGetRequest = TElementAll;

export type UpdateElementGetResponse = TGenericResponse;

export type UpdateElementGetAction = TAction<UpdateElementGetRequest, UpdateElementGetResponse>;

// 4. delete element
export type DeleteElementGetRequest = TElementId;

export type DeleteElementGetResponse = TGenericResponse;

export type DeleteElementGetAction = TAction<DeleteElementGetRequest, DeleteElementGetResponse>;

// 5. rate element
export type RateElementGetRequest = {
  type: ("Event" | "Ad"),
  rating: number,
};

export type RateElementGetResponse = TGenericResponse;

export type RateElementGetAction = TAction<RateElementGetRequest, RateElementGetResponse>;

// 6. get more elements
export type TFilter = {
  userId?: string,
  dateFrom?: TDate,
  dateTo?: TDate,
  place?: TPlace,
  placeRange?: number,
  type?: string,
  creationDate?: TDate,
  ratingFrom?: number,
  ratingTo?: number,
  costFrom?: number,
  costTo?: number,
  tags?: TTag[],
};

export type GetElementsGetRequest = {
  type: ETypeElement,
  filter?: TFilter,
  n: number,
  page?: number,
};

export type GetElementsGetResponse = {
  type: ETypeElement,
  elements: (TUser | TEvent | TAd | TStockExchange)[],
};

export type GetElementsGetAction = TAction<GetElementsGetRequest, GetElementsGetResponse>;

// 7. report element
export type ReportElementGetRequest = TElementId;

export type ReportElementGetResponse = TGenericResponse;

export type ReportElementGetAction = TAction<ReportElementGetRequest, ReportElementGetResponse>;