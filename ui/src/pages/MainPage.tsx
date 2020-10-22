import React from "react";
import { LocText } from "../components/LocText";

type TMainPageProps = {

};

export const MainPage: React.FC<TMainPageProps> = () => {

  return <>
    <LocText
      en="this is example homepage"
      cz="tohle je ukázková stránka"
    />
  </>;
};
