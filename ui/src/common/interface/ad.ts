import { TAction } from "./common";
import { Ad, AdCreateReplace, Ads, AdFilters, Rate, Report, ResourceInfo, Pagination } from "./shared";

// 1. get ad by id
export type TAdGetByIdGetRequest = {};
export type TAdGetByIdGetResponse = Ad;
export type TAdGetByIdGetAction = TAction<TAdGetByIdGetRequest, TAdGetByIdGetResponse>;

// 2. new ad
export type TAdPostRequest = AdCreateReplace;
export type TAdPostResponse = ResourceInfo<number>;
export type TAdPostAction = TAction<TAdPostRequest, TAdPostResponse>;

// 3. update ad
export type TAdUpdatePutRequest = AdCreateReplace;
export type TAdUpdatePutResponse = {};
export type TAdUpdatePutAction = TAction<TAdUpdatePutRequest, TAdUpdatePutResponse>;

// 4. delete ad
export type TAdDeleteRequest = {};
export type TAdDeleteResponse = {};
export type TAdDeleteAction = TAction<TAdDeleteRequest, TAdDeleteResponse>;

// 5. rate ad
export type TAdRatePostRequest = Rate;
export type TAdRatePostResponse = ResourceInfo<number>;
export type TAdRatePostAction = TAction<TAdRatePostRequest, TAdRatePostResponse>;

// 6. get more ads
export type TAdGetListGetRequest = AdFilters & Pagination;
export type TAdGetListGetResponse = Ads;
export type TAdGetListGetAction = TAction<TAdGetListGetRequest, TAdGetListGetResponse>;

// 7. report ad
export type TAdReportPostRequest = Report;
export type TAdReportPostResponse = ResourceInfo<number>;
export type TAdReportPostAction = TAction<TAdReportPostRequest, TAdReportPostResponse>;