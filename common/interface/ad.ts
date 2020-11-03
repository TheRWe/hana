import { TAction, TCommonData, TCommonDataNew, TCommonGetListPostRequest, TGenericResponse, TId, TRate, TReport } from "./common";

export enum EAdCategory {
  Supply = "Supply",
  Demand = "Demand",
}

export type TAd = TCommonData & {
  isValid: boolean,
  category: EAdCategory,
  type: string,
  payout: number,
};

export type TAdNewUpdate = TCommonDataNew & {
  isValid: boolean,
  category: EAdCategory,
  type: string,
  payout: number,
};

// 1. get ad by id
export type TAdGetByIdPostRequest = TId;
export type TAdGetByIdPostResponse = TAd;
export type TAdGetByIdPostAction = TAction<TAdGetByIdPostRequest, TAdGetByIdPostResponse>;

// 2. new ad
export type TAdPutRequest = TAdNewUpdate;
export type TAdPutResponse = TGenericResponse;
export type TAdPutAction = TAction<TAdPutRequest, TAdPutResponse>;

// 3. update ad
export type TAdUpdatePostRequest = TAdNewUpdate;
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
export type TAdGetListPostRequest = TCommonGetListPostRequest & {
  isValid?: boolean,
  category?: EAdCategory,
  type?: string,
  salaryFrom?: number,
  salaryTo?: number,
};
export type TAdGetListPostResponse = {
  ads: TAd[],
};
export type TAdGetListPostAction = TAction<TAdGetListPostRequest, TAdGetListPostResponse>;

// 7. report ad
export type TAdReportPostRequest = TReport;
export type TAdReportPostResponse = TGenericResponse;
export type TAdReportPostAction = TAction<TAdReportPostRequest, TAdReportPostResponse>;
