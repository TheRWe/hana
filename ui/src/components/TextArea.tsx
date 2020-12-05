import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";


type TextAreaProps = {
  label: TLocalizedText
  numRows?: number
  numCols?: number
  value?: string
};


export const TextArea: React.FC<TextAreaProps> = ({ label, numRows, numCols, value }: TextAreaProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  return (<>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <textarea id={name} name={name} rows={numRows} cols={numCols}>{value}</textarea>
  </>);
};