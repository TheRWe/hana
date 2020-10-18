import { EErrorCode } from "../interface/common";
import { TArticle, TArticleGetAction } from "../interface/example";

export const fakeArticle: TArticle =
{
  title: "covid spreads",
  text: "go home",
};

export const fakeArticleGetActionUI: TArticleGetAction = async ({ id }) => {

  const chanceOfError = .3;
  return Math.random() > chanceOfError
    ? { article: fakeArticle }
    : {
      error: {
        msg: "Test error",
        code: EErrorCode.NotLoggedIn,
      },
    } as any;
};
