import { TAction,  TGenericResponse, TId, TRate, TReport } from "./common";
import { ResourceInfo, User, UserCreateUpdate, Users, UsersRequest, UserType } from "./shared";

// 1. get user by id
export type TUserGetByIdPostRequest = TId;
export type TUserGetByIdPostResponse = User;
export type TUserGetByIdPostAction = TAction<TUserGetByIdPostRequest, TUserGetByIdPostResponse>;

// 2. new user
export type TUserPutRequest = UserCreateUpdate;
export type TUserPutResponse = ResourceInfo;
export type TUserPutAction = TAction<TUserPutRequest, TUserPutResponse>;

// 3. update user
export type TUserUpdatePostRequest = UserCreateUpdate;
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
export type TUserGetListPostAction = TAction<UsersRequest, Users>;

// 7. report user
export type TUserReportPostRequest = TReport;
export type TUserReportPostResponse = TGenericResponse;
export type TUserReportPostAction = TAction<TUserReportPostRequest, TUserReportPostResponse>;

// 8. change user type
export type TUserChangeTypePostRequest = {
    id: number,
    type: UserType,
};
export type TUserChangeTypeGetResponse = TGenericResponse;
export type TUserChangeTypeGetAction = TAction<TUserChangeTypePostRequest, TUserChangeTypeGetResponse>;