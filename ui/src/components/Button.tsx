import React, { useContext } from "react";
import { LocText } from "./LocText";

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