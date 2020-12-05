import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

export enum EInputType {
  date = "date",
  text = "text",
  number = "number",
}

type InputProps = {
  label: TLocalizedText
} & (
    {
      type: EInputType.number
      value?: number,
      onValueChange?: (val: number) => void,
    } | {
      type: EInputType.text
      value?: string,
      onValueChange?: (val: string) => void,
    } | {
      // todo: date format
      type: EInputType.date
      value?: string,
      onValueChange?: (val: string) => void,
    }
  );


export const Input: React.FC<InputProps> = ({ type, label, value, onValueChange }: InputProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (!onValueChange)
      return;
    const value = e.target.value;
    switch (type) {
      case EInputType.number:
        const float = parseFloat(value);
        if ((!float && float !== 0) || Number.isNaN(float) || !Number.isFinite(float)) {
          console.warn(`cannot parse float value: ${value}`);
          break;
        }
        onValueChange(float as never);
        break;
      case EInputType.text:
        onValueChange(value as never);
        break;
      case EInputType.date:
        // todo: implement
        console.error("not implemeted");
        break;
    }
  };

  return (<>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <input type={type} id={name} name={name} value={value?.toString()} onChange={handleInputChange} />
  </>);
};