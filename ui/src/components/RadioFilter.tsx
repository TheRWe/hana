import React, { useContext } from "react";
import { LocText } from "./LocText";

export enum ERadioFilterType {
  events,
  stock,
}

type RadioFilterProps = {
  type: ERadioFilterType
};


export const RadioFilter: React.FC<RadioFilterProps> = ({ type }: RadioFilterProps) => <>
  {
    type && (type as ERadioFilterType) === ERadioFilterType.stock ?
      /********************************
      * Radio filters for stocks page *
      *********************************/
      <div className="type-filters">
        <label>
          <LocText
            en="Category"
            cz="Kategorie"
          />
        </label>
        <input type="radio" id="toys" name="event-type" />
        <label htmlFor="toys">
          <LocText
            en="Toys"
            cz="Hračky"
          />
        </label>
        <input type="radio" id="clothes" name="event-type" />
        <label htmlFor="clothes">
          <LocText
            en="Clothes"
            cz="Oblečení"
          />
        </label>
        <input type="radio" id="books" name="event-type" />
        <label htmlFor="books">
          <LocText
            en="Books"
            cz="Knihy"
          />
        </label>
        <input type="radio" id="machines" name="event-type" />
        <label htmlFor="machines">
          <LocText
            en="Machines"
            cz="Stroje"
          />
        </label>
      </div>
      :
      /*******************************
      * Radio filters for event page *
      ********************************/
      <div className="type-filters">
        <label>
          <LocText
            en="Event type"
            cz="Typ akce"
          />
        </label>
        <input type="radio" id="kids" name="event-type" />
        <label htmlFor="kids">
          <LocText
            en="For kids"
            cz="Pro děti"
          />
        </label>
        <input type="radio" id="culture" name="event-type" />
        <label htmlFor="culture">
          <LocText
            en="Culture"
            cz="Kulturní"
          />
        </label>
        <input type="radio" id="music" name="event-type" />
        <label htmlFor="music">
          <LocText
            en="Music"
            cz="Hudební"
          />
        </label>
      </div>
  }
</>;
