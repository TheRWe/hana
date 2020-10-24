import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

type SelectBoxProps = {
  labelEng: string
  labelCz: string
  options: TLocalizedText[]
};


export const SelectBox: React.FC<SelectBoxProps> = ({ labelEng, labelCz, options }: SelectBoxProps) => {
  const name = labelEng.replace(" ", "-").toLowerCase();

  const LocalizedOption = (element: TLocalizedText) =>
    <option value={element.en}>
      {useLocalized(element)}
    </option>
    ;

  return (<>
    <label htmlFor={name}>
      <LocText
        en={labelEng}
        cz={labelCz}
      />
    </label>
    <select name={name} id={name}>
      {
        options.map(LocalizedOption)
      }
    </select>
  </>);
};