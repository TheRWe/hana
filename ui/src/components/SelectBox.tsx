import React from "react";
import { TLocalizedText, useLocalized } from "./LocText";

type Option = { value: string, text: TLocalizedText };
type SelectBoxProps = {
  label: TLocalizedText
  options: Option[],
  value: string,
  onValueChange: (value: string) => void,
};

const emptyOption = { text: { cz: "", en: "" }, value: "" };

export const SelectBox: React.FC<SelectBoxProps> = ({ label, options, onValueChange, value }: SelectBoxProps) => {
  const name = label.en.replace(" ", "-").toLowerCase();

  const LocalizedOption = ({ text, value: v }: Option) =>
    <option value={v} {...(v === value ? { selected: true } : {})}>
      {useLocalized(text)}
    </option>
    ;

  return (<>
    <div className="row">
      <label htmlFor={name}>
        {useLocalized(label)}
      </label>
      <select name={name} id={name} onChange={e => onValueChange(e.target.value)}>
        {[emptyOption].concat(options).map(LocalizedOption)}
      </select>
    </div>
  </>);
};