import { TGenericResponse, TId, TRate } from "../interface/common";
import { EUserType, TUser, TUserChangeTypeGetAction, TUserChangeTypeGetResponse, TUserChangeTypePostRequest, TUserDeleteAction, TUserDeleteResponse, TUserGetByIdPostAction, TUserGetByIdPostRequest, TUserGetListPostAction, TUserGetListPostRequest, TUserGetListPostResponse, TUserNewUpdate, TUserPutAction, TUserPutResponse, TUserRatePostAction, TUserRatePostResponse, TUserReportPostAction, TUserReportPostRequest, TUserReportPostResponse, TUserUpdatePostAction, TUserUpdatePostResponse } from "../interface/user";
import { datePart1, datePart2, datePart3, datePart4, datePart5, hash, hoursGenerating } from "./common";

const generateUser = ({ id, type }: { id: number; type?: EUserType; }): TUser => {
    const num: number = hash(id);
    const hour: number = num % hoursGenerating;
    const rating: number = 4;
    const one: number = 1;
    const numOfRatings: number = 15;
    return {
        id,
        name: "Roman Buk" + id.toString(),
        email: "roman.buk" + id.toString() + "@email.cz",
        type: (type === undefined) ? EUserType.Person : type,
        photo: { link: "https://via.placeholder.com/300x300.png?text=Profile+picture+" + id.toString() },
        create: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
        rating: (num % rating) + one,
        numberOfRatings: num % numOfRatings,
    };
};

// 1. get user by id
export const TUserGetByIdPostActionUI: TUserGetByIdPostAction = async (req:TUserGetByIdPostRequest) => {
    return generateUser({ id: req.id });
};

// 2. new user
export const TUserPutActionUI: TUserPutAction = async (req:TUserNewUpdate) => {
    const response: TUserPutResponse = {};
    return response;
};
// 3. update user
export const TUserUpdatePostActionUI: TUserUpdatePostAction = async (req:TUserNewUpdate) => {
    const response: TUserUpdatePostResponse = {};
    return response;
};
// 4. delete user
export const TUserDeleteActionUI: TUserDeleteAction = async (req:TId) => {
    const response: TUserDeleteResponse = {};
    return response;
};
// 5. rate user
export const TUserRatePostActionUI: TUserRatePostAction = async (req:TRate) => {
    const response: TUserRatePostResponse = {};
    return response;
};
// 6. get more users
export const TUserGetListPostActionUI: TUserGetListPostAction = async (req:TUserGetListPostRequest) => {
    const users: TUser[] = [];
    for(let i = 0; i < req.count; i++)
        users.push(generateUser({ id: i }));
    const response: TUserGetListPostResponse = {
      users,
    };
    return response;
};
// 7. report user
export const TUserReportPostActionUI: TUserReportPostAction = async (req:TUserReportPostRequest) => {
    const response: TUserReportPostResponse = {};
    return response;
};
// 8. change user type
export const TUserChangeTypeGetActionUI: TUserChangeTypeGetAction = async (req:TUserChangeTypePostRequest) => {
    const response: TUserChangeTypeGetResponse = {};
    return response;
};