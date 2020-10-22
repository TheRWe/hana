import React, { useContext } from "react";

export enum ELanguages {
  en = "en",
  cz = "cz",
}

type TLocTextProps = { [key in ELanguages]: string };

export const LanguageContext = React.createContext<ELanguages>(ELanguages.cz);

export const LocText: React.FC<TLocTextProps> = (props) =><>
    {props[useContext(LanguageContext)]}
  </>;
