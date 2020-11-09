import { TAction } from "./common";
import { Report, ResourceInfo, User, UserCreateUpdate, Users, UsersRequest } from "./shared";

// 1. get user by id
export type TUserGetByIdGetRequest = {};
export type TUserGetByIdGetResponse = User;
export type TUserGetByIdGetAction = TAction<TUserGetByIdGetRequest, TUserGetByIdGetResponse>;

// 2. new user
export type TUserPostRequest = UserCreateUpdate;
export type TUserPostResponse = ResourceInfo;
export type TUserPostAction = TAction<TUserPostRequest, TUserPostResponse>;

// 3. update user
export type TUserUpdatePutRequest = UserCreateUpdate;
export type TUserUpdatePutResponse = {};
export type TUserUpdatePutAction = TAction<TUserUpdatePutRequest, TUserUpdatePutResponse>;

// 4. delete user
export type TUserDeleteRequest = {};
export type TUserDeleteResponse = {};
export type TUserDeleteAction = TAction<TUserDeleteRequest, TUserDeleteResponse>;

// 5. get more users
export type TUserGetListGetAction = TAction<UsersRequest, Users>;

// 6. report user
export type TUserReportPostRequest = Report;
export type TUserReportPostResponse = ResourceInfo;
export type TUserReportPostAction = TAction<TUserReportPostRequest, TUserReportPostResponse>;