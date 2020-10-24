import React, { useContext } from "react";

export enum ELanguages {
  en = "en",
  cz = "cz",
}

export type TLocalizedText = { [key in ELanguages]: string };

type TLocTextProps = TLocalizedText
  & { children?: (text: string) => JSX.Element }
  ;

export const LanguageContext = React.createContext<ELanguages>(ELanguages.cz);

export const useLocalized = (text:TLocalizedText)=>{
  const language = useContext(LanguageContext);
  const localized = text[language];

  return localized;
};

export const LocText: React.FC<TLocTextProps> = (props) =><>
    {useLocalized(props)}
  </>;