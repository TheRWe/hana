import { TAction, TDate, TGenericResponse, TPhoto } from "./common";

export enum EUserType {
  Person = "Person",
  Company = "Company",
  CertifiedCompany = "CertifiedCompany",
  Moderator = "Moderator",
  Administrator = "Administrator",
}

export type TUser = {
  id: string,
  name: string,
  email: string,
  type: EUserType,
  photo?: TPhoto,
  creationDate: TDate,
};

// 1. change user type
export type TUserChangeTypeGetRequest = {
  id: string,
  type: EUserType,
};

export type TUserChangeTypeGetResponse = TGenericResponse;

export type TUserChangeTypeGetAction = TAction<TUserChangeTypeGetRequest, TUserChangeTypeGetResponse>;

// 2. login, logout?