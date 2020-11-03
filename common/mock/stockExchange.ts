import { TStockCategory, TStockExchange, TStockExchangeDeleteAction, TStockExchangeDeleteRequest, TStockExchangeDeleteResponse, TStockExchangeGetByIdPostAction, TStockExchangeGetByIdPostRequest, TStockExchangeGetListPostAction, TStockExchangeGetListPostRequest, TStockExchangeGetListPostResponse, TStockExchangePutAction, TStockExchangePutRequest, TStockExchangePutResponse, TStockExchangeReportPostAction, TStockExchangeReportPostRequest, TStockExchangeReportPostResponse, TStockExchangeUpdatePostAction, TStockExchangeUpdatePostRequest, TStockExchangeUpdatePostResponse } from "../interface/stockExchange";
import { datePart1, datePart2, datePart3, datePart4, datePart5, hash, hoursGenerating, lat, lng } from "./common";

const generateStockExchange = (id: number): TStockExchange => {
    const num: number = hash(id);
    const names: string[] = [
        "Stará váza",
        "Poháre",
        "Autíčko",
    ];
    const descriptions: string[] = [
        "Stará čínská porcelánová vázam značená výška 28 cm, priemer v najširšej části 20 cm, bez poškodení, vitrínový stav.",
        "Predám obedovú súpravu z tmavého skla, taniere hlboké, plytké, dezertné po 5 kusov, 5 kusov šálky a podšálky a dva kusy misky kompotové.",
        "Tatra 815-7 6x6 CAS 30 Hasiči, Výrobce: Kaden, Měřítko: 1:43, Stav: nové, rozpalené pouze na foto. Zrcátka a stěrače samostatně v pytlíku.",
    ];
    const hour: number = num % hoursGenerating;

    const n1: number = 130;
    const n2: number = 0;
    const n3: number = 30;
    const userIdGenerating: number = 25;

    const costs: number[] = [n1, n2, n3];


    const result: TStockExchange = {
        id,
        userId: num % userIdGenerating,
        name: names[num % names.length],
        description: descriptions[num % descriptions.length],
        place: {
            name: "Olomouc",
            latitude: lat,
            longitude: lng,
        },
        photo: { link: "https://via.placeholder.com/300x300.png?text=StockExchange+picture+" + id.toString() },
        tags: [
            { id: 2, name: "nove" },
            { id: 3, name: "pouzite" },
        ],
        create: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
        isValid: true,
        category: TStockCategory.Sell,
        cost: costs[num % costs.length],
    };
    return result;
};

// 1. get stock exchange by id
export const TStockExchangeGetByIdPostActionUI: TStockExchangeGetByIdPostAction = async (req:TStockExchangeGetByIdPostRequest) => {
    return generateStockExchange(req.id);
};
// 2. new stock exchange
export const TStockExchangePutActionUI: TStockExchangePutAction = async (req: TStockExchangePutRequest) => {
    const response: TStockExchangePutResponse = {};
    return response;
};
// 3. update stock exchange
export const TStockExchangeUpdatePostActionUI: TStockExchangeUpdatePostAction = async (req: TStockExchangeUpdatePostRequest) => {
    const response: TStockExchangeUpdatePostResponse = {};
    return response;
};
// 4. delete stock exchange
export const TStockExchangeDeleteActionUI: TStockExchangeDeleteAction = async (req: TStockExchangeDeleteRequest) => {
    const response: TStockExchangeDeleteResponse = {};
    return response;
};
// 5. get more stock exchanges
export const TStockExchangeGetListPostActionUI: TStockExchangeGetListPostAction = async (req:TStockExchangeGetListPostRequest) => {
    const stockExchanges: TStockExchange[] = [];
    for(let i = 0; i < req.count; i++)
        stockExchanges.push(generateStockExchange(i));
    const response: TStockExchangeGetListPostResponse = {
        stockExchanges,
    };
    return response;
};
// 6. report stock exchange
export const TStockExchangeReportPostActionUI: TStockExchangeReportPostAction = async (req: TStockExchangeReportPostRequest) => {
    const response: TStockExchangeReportPostResponse = {};
    return response;
};
