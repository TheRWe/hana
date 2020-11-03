import { TAction, TCommonGetListPostRequest, TDate, TGenericResponse, TId, TPhoto, TRate, TReport } from "./common";

export enum EUserType {
  Person = "Person",
  Company = "Company",
  CertifiedCompany = "CertifiedCompany",
  Moderator = "Moderator",
  Userministrator = "Administrator",
}

export type TUser = {
  id: number,
  name: string,
  email: string,
  type: EUserType,
  photo?: TPhoto,
  create: TDate,
  rating: number,
  numberOfRatings: number,
};

export type TUserNewUpdate = {
  name: string,
  email: string,
  type: EUserType,
  photo?: TPhoto,
};

// 1. get user by id
export type TUserGetByIdPostRequest = TId;
export type TUserGetByIdPostResponse = TUser;
export type TUserGetByIdPostAction = TAction<TUserGetByIdPostRequest, TUserGetByIdPostResponse>;

// 2. new user
export type TUserPutRequest = TUserNewUpdate;
export type TUserPutResponse = TGenericResponse;
export type TUserPutAction = TAction<TUserPutRequest, TUserPutResponse>;

// 3. update user
export type TUserUpdatePostRequest = TUserNewUpdate;
export type TUserUpdatePostResponse = TGenericResponse;
export type TUserUpdatePostAction = TAction<TUserUpdatePostRequest, TUserUpdatePostResponse>;

// 4. delete user
export type TUserDeleteRequest = TId;
export type TUserDeleteResponse = TGenericResponse;
export type TUserDeleteAction = TAction<TUserDeleteRequest, TUserDeleteResponse>;

// 5. rate user
export type TUserRatePostRequest = TRate;
export type TUserRatePostResponse = TGenericResponse;
export type TUserRatePostAction = TAction<TUserRatePostRequest, TUserRatePostResponse>;

// 6. get more users
export type TUserGetListPostRequest = TCommonGetListPostRequest & {
  type?: EUserType,
  createFrom?: TDate,
  createTo?: TDate,
  ratingFrom?: number,
  ratingTo?: number,
  numberOfRatingsFrom?: number,
  numberOfRatingsTo?: number,
};
export type TUserGetListPostResponse = {
  users: TUser[],
};
export type TUserGetListPostAction = TAction<TUserGetListPostRequest, TUserGetListPostResponse>;

// 7. report user
export type TUserReportPostRequest = TReport;
export type TUserReportPostResponse = TGenericResponse;
export type TUserReportPostAction = TAction<TUserReportPostRequest, TUserReportPostResponse>;

// 8. change user type
export type TUserChangeTypePostRequest = {
  id: number,
  type: EUserType,
};
export type TUserChangeTypeGetResponse = TGenericResponse;
export type TUserChangeTypeGetAction = TAction<TUserChangeTypePostRequest, TUserChangeTypeGetResponse>;