import React from "react";
import { LocText } from "./LocText";

/* TODO: use useLocalized and TLocalizedText ... result props will be
type ButtonProps = {
  label: TLocalizedText,
};
*/
type ButtonProps = {
  labelEng: string
  labelCz: string
};


export const Button: React.FC<ButtonProps> = ({ labelEng, labelCz }: ButtonProps) => {

  return (<>
    <button>
        <LocText
          en={labelEng}
          cz={labelCz}
        />
      </button>
  </>);
};
