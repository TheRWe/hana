import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

export enum EInputType {
  date = "date",
  text = "text",
}

type InputProps = {
  type: EInputType
  label: TLocalizedText
  value?: string
};


export const Input: React.FC<InputProps> = ({ type, label, value }: InputProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  return (<>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <input type={type} id={name} name={name} value={value} />
  </>);
};