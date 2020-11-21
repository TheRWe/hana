import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

type SelectBoxProps = {
  label: TLocalizedText
  options: TLocalizedText[]
};


export const SelectBox: React.FC<SelectBoxProps> = ({ label, options }: SelectBoxProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  const LocalizedOption = (element: TLocalizedText) =>
    <option value={element.en}>
      {useLocalized(element)}
    </option>
    ;

  return (<>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <select name={name} id={name}>
      <option></option>
      {
        options.map(LocalizedOption)
      }
    </select>
  </>);
};