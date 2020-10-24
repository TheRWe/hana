import React, { useContext } from "react";
import { LocText } from "./LocText";

export enum EInputType {
  date = "date",
  text = "text",
}

type InputProps = {
  type: string
  labelEng: string
  labelCz: string
};


export const Input: React.FC<InputProps> = ({ type, labelEng, labelCz }: InputProps) => {
  const name =  labelEng.replace(" ", "-").toLowerCase();

  return (<>
    <label htmlFor={name}>
      <LocText
        en={labelEng}
        cz={labelCz}
      />
    </label>
    <input type={type} id={name} name={name} />
  </>);
};