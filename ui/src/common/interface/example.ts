import { TAction } from "./common";

export type TArticle = {
  title: string,
  text: string,
};

export type TArticleGetRequest = {
  id: string,
};

export type TArticleGetResponse = {
  article: TArticle
};

export type TArticleGetAction = TAction<TArticleGetRequest, TArticleGetResponse>;