import { TAction } from "./common";
import { Ad, AdCreateUpdate, Ads, AdsRequest, Rate, Report, ResourceInfo } from "./shared";

// 1. get ad by id
export type TAdGetByIdGetRequest = {};
export type TAdGetByIdGetResponse = Ad;
export type TAdGetByIdGetAction = TAction<TAdGetByIdGetRequest, TAdGetByIdGetResponse>;

// 2. new ad
export type TAdPostRequest = AdCreateUpdate;
export type TAdPostResponse = ResourceInfo;
export type TAdPostAction = TAction<TAdPostRequest, TAdPostResponse>;

// 3. update ad
export type TAdUpdatePutRequest = AdCreateUpdate;
export type TAdUpdatePutResponse = {};
export type TAdUpdatePutAction = TAction<TAdUpdatePutRequest, TAdUpdatePutResponse>;

// 4. delete ad
export type TAdDeleteRequest = {};
export type TAdDeleteResponse = {};
export type TAdDeleteAction = TAction<TAdDeleteRequest, TAdDeleteResponse>;

// 5. rate ad
export type TAdRatePostRequest = Rate;
export type TAdRatePostResponse = ResourceInfo;
export type TAdRatePostAction = TAction<TAdRatePostRequest, TAdRatePostResponse>;

// 6. get more ads
export type TAdGetListGetAction = TAction<AdsRequest, Ads>;

// 7. report ad
export type TAdReportPostRequest = Report;
export type TAdReportPostResponse = ResourceInfo;
export type TAdReportPostAction = TAction<TAdReportPostRequest, TAdReportPostResponse>;