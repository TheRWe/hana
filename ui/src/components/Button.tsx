import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

/* TODO: use useLocalized and TLocalizedText ... result props will be
type ButtonProps = {
  label: TLocalizedText,
};
*/
type ButtonProps = {
  label: TLocalizedText
};


export const Button: React.FC<ButtonProps> = ({ label }: ButtonProps) => {

  return (<>
    <button>
      {useLocalized(label)}
    </button>
  </>);
};
