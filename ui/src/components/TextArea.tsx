import React from "react";
import { TLocalizedText, useLocalized } from "./LocText";


type TextAreaProps = {
  label: TLocalizedText
  numRows?: number
  numCols?: number
  value?: string
  onValueChange?: (val: string) => void,
};


export const TextArea: React.FC<TextAreaProps> = ({ label, numRows, numCols, value, onValueChange = () => { } }: TextAreaProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  return (<>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <textarea id={name} name={name} rows={numRows} cols={numCols} value={value} onChange={(e) => onValueChange(e.target.value)}>{value}</textarea>
  </>);
};