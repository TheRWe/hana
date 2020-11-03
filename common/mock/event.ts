import { TEvent, TEventDeleteAction, TEventDeleteRequest, TEventDeleteResponse, TEventGetByIdPostAction, TEventGetByIdPostRequest, TEventGetListPostAction, TEventGetListPostRequest, TEventGetListPostResponse, TEventPutAction, TEventPutRequest, TEventPutResponse, TEventRatePostAction, TEventRatePostRequest, TEventRatePostResponse, TEventReportPostAction, TEventReportPostRequest, TEventReportPostResponse, TEventUpdatePostAction, TEventUpdatePostRequest, TEventUpdatePostResponse } from "../interface/event";
import { datePart1, datePart2, datePart3, datePart4, datePart5, hash, hoursGenerating, lat, lng } from "./common";

const generateEvent = (id: number): TEvent => {
    const num: number = hash(id);
    const names: string[] = [
        "Tvorivé dielne",
        "Mestká Tržnica",
        "Cirkus v meste",
    ];
    const descriptions: string[] = [
        "Program pre žiakov materských škol, základných a špecialnych škol. V tvorivej dielni si děti vyskúšajú rozne aktivity s použitím niektorých tradičných výrobných postupov a prirodnych materialov.",
        "Tradiční tržiště se základním sortimentem potravin i s dalšími zajímavými doplňky českých farem. Konají se v úterý a ve čtvrtek od 9:00 do 18:00, v sobotu od 9:00 do 14:00",
        "Cirkus Metropol je druh zábavného podniku s cvičenými zvieratmi, akrobatmi a klaunmi a umenie realizované v tomto podniku, ktoré sa zaraďuje medzi scénické édruhy umenia.",
    ];
    const hour: number = num % hoursGenerating;

    const n1: number = 30;
    const n2: number = 0;
    const n3: number = 30;
    const costs: number[] = [n1, n2, n3];
    const types: string[] = ["Pro děti, Pro dospělé"];
    const userIdGenerating: number = 25;

    const rating: number = 4;
    const one: number = 1;
    const numOfRatings: number = 50;


    const result: TEvent = {
        id,
        userId: num % userIdGenerating,
        name: names[num % names.length],
        description: descriptions[num % descriptions.length],
        place: {
            name: "Olomouc",
            latitude: lat,
            longitude: lng,
        },
        photo: { link: "https://via.placeholder.com/300x300.png?text=Event+picture+" + id.toString() },
        tags: [
            { id: 2, name: "zabava" },
            { id: 3, name: "volny_cas" },
        ],
        create: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
        rating: (num % rating) + one,
        numberOfRatings: num % numOfRatings,
        dateFrom: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
        dateTo: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
        cost: costs[num % costs.length],
        type: types[num % types.length],
    };
    return result;
};


// 1. get event by id
export const TEventGetByIdPostActionUI: TEventGetByIdPostAction = async (req: TEventGetByIdPostRequest) => {
    return generateEvent(req.id);
};
// 2. new event
export const TEventPutActionUI: TEventPutAction = async (req: TEventPutRequest) => {
    const response: TEventPutResponse = {};
    return response;
};
// 3. update event
export const TEventUpdatePostActionUI: TEventUpdatePostAction = async (req: TEventUpdatePostRequest) => {
    const response: TEventUpdatePostResponse = {};
    return response;
};
// 4. delete event
export const TEventDeleteActionUI: TEventDeleteAction = async (req: TEventDeleteRequest) => {
    const response: TEventDeleteResponse = {};
    return response;
};
// 5. rate event
export const TEventRatePostActionUI: TEventRatePostAction = async (req: TEventRatePostRequest) => {
    const response: TEventRatePostResponse = {};
    return response;
};
// 6. get more events
export const TEventGetListPostActionUI: TEventGetListPostAction = async (req:TEventGetListPostRequest) => {
    const events: TEvent[] = [];
    for(let i = 0; i < req.count; i++)
        events.push(generateEvent(i));
    const response: TEventGetListPostResponse = {
        events,
    };
    return response;
};
// 7. report event
export const TEventReportPostActionUI: TEventReportPostAction = async (req: TEventReportPostRequest) => {
    const response: TEventReportPostResponse = {};
    return response;
};