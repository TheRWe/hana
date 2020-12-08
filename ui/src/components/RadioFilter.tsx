import React from "react";
import { TFilter } from "./FilterMenu";
import { LocText, TLocalizedText } from "./LocText";

export enum ERadioFilterType {
  events,
  stock,
}

type RadioFilterProps = {
  type: ERadioFilterType,
  filter: TFilter,
  setFilterProp: (fnc: (filter: TFilter) => void) => void,
};


export const RadioFilter: React.FC<RadioFilterProps> = ({ type, setFilterProp }) => {
  return (<>
    <div className="radio-filter">
      <label>
        {type && (type as ERadioFilterType) === ERadioFilterType.stock
          ? <LocText
            en="Category:"
            cz="Kategorie:"
          />
          : <LocText
            en="Event type:"
            cz="Typ akce:"
          />}
      </label>
      {(type && (type as ERadioFilterType) === ERadioFilterType.stock ?
        [
          {
            id: "toys",
            label: {
              en: "Toys",
              cz: "Hračky",
            },
          },
          {
            id: "clothes",
            label: {
              en: "Clothes",
              cz: "Oblečení",
            },
          },
          {
            id: "books",
            label: {
              en: "Books",
              cz: "Knihy",
            },
          },
          {
            id: "machines",
            label: {
              en: "Machines",
              cz: "Stroje",
            },
          },
        ] : [
          {
            id: "kids",
            label: {
              en: "For kids",
              cz: "Pro děti",
            },
          },
          {
            id: "culture",
            label: {
              en: "Culture",
              cz: "Kulturní",
            },
          },
          {
            id: "music",
            label: {
              en: "Music",
              cz: "Hudební",
            },
          },
        ] as { id: string, label: TLocalizedText }[]).map(({ id, label }) =>
          <>
            <input type="radio" id={id} name="event-type" onChange={() => setFilterProp(x => x.category = id)} />
            <label htmlFor={id}>
              <LocText
                {...label}
              />
            </label>
          </>
        )}
    </div>
  </>);
};
