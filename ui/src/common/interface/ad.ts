import { TAction, TGenericResponse, TId, TRate, TReport } from "./common";
import { Ad, AdCreateUpdate, Ads, AdsRequest, ResourceInfo } from "./shared";

// 1. get ad by id
export type TAdGetByIdPostRequest = TId;
export type TAdGetByIdPostResponse = Ad;
export type TAdGetByIdPostAction = TAction<TAdGetByIdPostRequest, TAdGetByIdPostResponse>;

// 2. new ad
export type TAdPutRequest = AdCreateUpdate;
export type TAdPutResponse = ResourceInfo;
export type TAdPutAction = TAction<TAdPutRequest, TAdPutResponse>;

// 3. update ad
export type TAdUpdatePostRequest = AdCreateUpdate;
export type TAdUpdatePostResponse = TGenericResponse;
export type TAdUpdatePostAction = TAction<TAdUpdatePostRequest, TAdUpdatePostResponse>;

// 4. delete ad
export type TAdDeleteRequest = TId;
export type TAdDeleteResponse = TGenericResponse;
export type TAdDeleteAction = TAction<TAdDeleteRequest, TAdDeleteResponse>;

// 5. rate ad
export type TAdRatePostRequest = TRate;
export type TAdRatePostResponse = TGenericResponse;
export type TAdRatePostAction = TAction<TAdRatePostRequest, TAdRatePostResponse>;

// 6. get more ads
export type TAdGetListPostAction = TAction<AdsRequest, Ads>;

// 7. report ad
export type TAdReportPostRequest = TReport;
export type TAdReportPostResponse = TGenericResponse;
export type TAdReportPostAction = TAction<TAdReportPostRequest, TAdReportPostResponse>;