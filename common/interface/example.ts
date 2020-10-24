import { TAction } from "./common";

export type TArticle = {
  title: string,
  text: string,
};

export type TArticleGetRequest = {
  id: string,
};

export type TArticleGetResponse = {
  article: TArticle
};

export type TArticleGetAction = TAction<TArticleGetRequest, TArticleGetResponse>;

// Tag
export type TTag = {
  id: string,
  name: string,
};

// Uživatel
export enum EUserType {
  Person, 
  Company,
  CertifiedCompany, 
  Moderator, 
  Administrator,
}

export type TUser = {
  id: string,
  name: string, 
  email: string, 
  type: EUserType,
  linkToPhoto: string, // ?
}

export type TUserGetRequest = {
  id: string,
};

export type TUserGetResponse = {
  user: TUser
};

export type TUserGetAction = TAction<TUserGetRequest, TUserGetResponse>;

// Datum
export type TDate = {
  year: number,
  month: number,
  day: number,
  hour: number,
  minute: number,
};

// Misto
export type TPlace = {
  name: string,
  latitude: number,  // jak podle toho budeme filtrovat?
  longitude: number, 
}

// Akce
export type TEvent = {
  id: string,
  name: string,
  linkToPhoto: string,
  user: TUser,
  rating: number,
  numberOfRatings: number,
  description: string,
  place: TPlace,
  dateFrom: TDate,
  dateTo: TDate,
  moreInfo: string,
  type: string, // nebo nejaky enum? (budou tam hodnoty jako: pro děti, kulturní)
  tags: TTag[],
}

export type TEventGetRequest = {
  id: string,
};

export type TEventGetResponse = {
  event: TEvent
};

export type TEventGetAction = TAction<TEventGetRequest, TEventGetResponse>;

// Inzerát
export enum EAdAndStockExchangeType {
  Supply, // nabídka 
  Demand, // poptávka
}

export type TAd = {
  id: string, 
  user: TUser,
  name: string,
  linkToPhoto: string,
  description: string, 
  type: EAdAndStockExchangeType,
  place: TPlace,
  tags: TTag[],
}

export type TAdGetRequest = {
  id: string,
};

export type TAdGetResponse = {
  ad: TAd
};

export type TAdGetAction = TAction<TAdGetRequest, TAdGetResponse>;

// Burza
export type TStockExchange = {
  id: string, 
  user: TUser,
  name: string, 
  linkToPhoto: string,
  description: string, 
  cost: number,
  type: EAdAndStockExchangeType,
  place: TPlace,
  tags: TTag[],
}

export type TStockExchangeGetRequest = {
  id: string,
};

export type TStockExchangeGetResponse = {
  stockExchange: TStockExchange,
};

export type TStockExchangeGetAction = TAction<TStockExchangeGetRequest, TStockExchangeGetResponse>;


