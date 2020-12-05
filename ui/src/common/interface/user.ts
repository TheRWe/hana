import { TAction } from "./common";
import { Report, ResourceInfo, User, UserCreateReplace, Users, UserFilters, Pagination } from "./shared";

// 1. get user by id
export type TUserGetByIdGetRequest = {};
export type TUserGetByIdGetResponse = User;
export type TUserGetByIdGetAction = TAction<TUserGetByIdGetRequest, TUserGetByIdGetResponse>;

// 2. new user
export type TUserPostRequest = UserCreateReplace;
export type TUserPostResponse = ResourceInfo<number>;
export type TUserPostAction = TAction<TUserPostRequest, TUserPostResponse>;

// 3. update user
export type TUserUpdatePutRequest = UserCreateReplace;
export type TUserUpdatePutResponse = {};
export type TUserUpdatePutAction = TAction<TUserUpdatePutRequest, TUserUpdatePutResponse>;

// 4. delete user
export type TUserDeleteRequest = {};
export type TUserDeleteResponse = {};
export type TUserDeleteAction = TAction<TUserDeleteRequest, TUserDeleteResponse>;

// 5. get more users
export type TUserGetListGetRequest = UserFilters & Pagination;
export type TUserGetListGetResponse = Users;
export type TUserGetListGetAction = TAction<TUserGetListGetRequest, TUserGetListGetResponse>;

// 6. report user
export type TUserReportPostRequest = Report;
export type TUserReportPostResponse = ResourceInfo<number>;
export type TUserReportPostAction = TAction<TUserReportPostRequest, TUserReportPostResponse>;