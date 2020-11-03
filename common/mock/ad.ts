import { EAdCategory, TAd, TAdDeleteAction, TAdDeleteRequest, TAdDeleteResponse, TAdGetByIdPostAction, TAdGetByIdPostRequest, TAdGetListPostAction, TAdGetListPostRequest, TAdGetListPostResponse, TAdPutAction, TAdPutRequest, TAdPutResponse, TAdRatePostAction, TAdRatePostRequest, TAdRatePostResponse, TAdReportPostAction, TAdReportPostRequest, TAdReportPostResponse, TAdUpdatePostAction, TAdUpdatePostRequest, TAdUpdatePostResponse } from "../interface/ad";
import { datePart1, datePart2, datePart3, datePart4, datePart5, hash, hoursGenerating, lat, lng, userIdeGenerating } from "./common";

const generateAd = (id: number): TAd => {
  const num: number = hash(id);
  const hour: number = num % hoursGenerating;
  const userId = num % userIdeGenerating;
  const names: string[] = [
    "Sekanie trávy",
    "Tepovanie kobercov",
    "Hľadáme výpomoc v kuchyni",
    "Opatrovateľka",
  ];
  const descriptions: string[] = [
    "Posekanie celého pozemku. Kosačka nutnosť.",
    "Vyčistenie škvrn z kobercov a obnova farby.",
    "Sekanie, krájanie, v prípade záujmu napíšte.",
    "Hledáme niekoho na opatrovanie dvoch detí vo veku 5 a 6 rokov.",
  ];

  const p1: number = 120;
  const p2: number = 200;
  const p3: number = 80;
  const p4: number = 100;
  const categoryCount: number = 2;

  const payouts: number[] = [p1, p2, p3, p4];

  const result: TAd = {
    id,
    userId,
    name: names[id % names.length],
    description: descriptions[id % descriptions.length],
    place: {
      name: "Olomouc",
      latitude: lat,
      longitude: lng,
    },
    photo: { link: "https://via.placeholder.com/300x300.png?text=Ad+picture+" + id.toString() },
    tags: [
      { id: 0, name: "olomouc" },
      { id: 1, name: "prace" },
    ],
    create: new Date(datePart1, datePart2, datePart3, hour, datePart4, datePart5),
    isValid: true,
    category: num % categoryCount === 0 ? EAdCategory.Demand : EAdCategory.Supply,
    type: "Brigáda (jednorázová)",
    payout: payouts[id % payouts.length],
  };
  return result;
};
// 1. get ad by id
export const TAdGetByIdPostActionUI: TAdGetByIdPostAction = async (req: TAdGetByIdPostRequest) => {
  return generateAd(req.id);
};
// 2. new ad
export const TAdPutActionUI: TAdPutAction = async (req: TAdPutRequest) => {
  const response: TAdPutResponse = {};
  return response;
};
// 3. update ad
export const TAdUpdatePostActionUI: TAdUpdatePostAction = async (req: TAdUpdatePostRequest) => {
  const response: TAdUpdatePostResponse = {};
  return response;
};
// 4. delete ad
export const TAdDeleteActionUI: TAdDeleteAction = async (req: TAdDeleteRequest) => {
  const response: TAdDeleteResponse = {};
  return response;
};
// 5. rate ad
export const TAdRatePostActionUI: TAdRatePostAction = async (req: TAdRatePostRequest) => {
  const response: TAdRatePostResponse = {};
  return response;
};
// 6. get more ads
export const TAdGetListPostActionUI: TAdGetListPostAction = async (req: TAdGetListPostRequest) => {
  const ads: TAd[] = [];
  for(let i = 0; i < req.count; i++)
    ads.push(generateAd(i));
  const response: TAdGetListPostResponse = {
    ads,
  };
  return response;
};
// 7. report ad
export const TAdReportPostActionUI: TAdReportPostAction = async (req: TAdReportPostRequest) => {
  const response: TAdReportPostResponse = {};
  return response;
};
