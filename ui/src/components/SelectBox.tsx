import React, { useContext } from "react";
import { LocText } from "./LocText";

type SelectBoxProps = {
  labelEng: string
  labelCz: string
  options: string[][]
};


export const SelectBox: React.FC<SelectBoxProps> = ({ labelEng, labelCz, options }: SelectBoxProps) => {
  const name = labelEng.replace(" ", "-").toLowerCase();

  return (<>
    <label htmlFor={name}>
      <LocText
        en={labelEng}
        cz={labelCz}
      />
    </label>
    <select name={name} id={name}>
      {
        options.map(element => {
          return <option value={element[0]}>
            {/* ??? nejede */}
            <LocText
              en={element[0]}
              cz={element[1]}
            />
          </option>;
        })
      }
    </select>
  </>);
};