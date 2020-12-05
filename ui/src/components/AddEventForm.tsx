import React from "react";
import { LocText } from "./LocText";
import { EJobAdType } from "./Tile";
import { EInputType, Input } from "./Input";
import { TextArea } from "./TextArea";
import { SelectBox } from "./SelectBox";


type AddEventFormProps = {
  imagePath?: string
  place?: string
  date?: string
  email?: string
  heading?: string
  text?: string
  price?: string
  telephoneNumber?: string
};


export enum EvenType {
  kids,
  culture,
  musical,
}

export const AddEventForm: React.FC<AddEventFormProps> = ({ imagePath = "../images/no_image.png", place, date, email, heading, text, price, telephoneNumber }: AddEventFormProps) => <>
  <form>
    <img className="event-picture" src={imagePath} alt="event-picture" />
    <button>
      <LocText
        en="Change picture"
        cz="Změnit obrázek"
      />
    </button>
    <Input
      type={EInputType.text}
      label={{ en: "Event name", cz: "Název akce" }}
      value={heading}
    ></Input>
    <Input
      type={EInputType.date}
      label={{ en: "Date", cz: "Datum akce" }}
      value={date}
    ></Input>
    <SelectBox
      label={{ en: "Type", cz: "Typ" }}
      options={[{ en: "Offer", cz: "Nabídka" }, { en: "Inquiry", cz: "Poptávka" }]}></SelectBox>
    <Input
      type={EInputType.text}
      label={{ en: "Place", cz: "Místo konání" }}
      value={place}
    ></Input>
    <TextArea
      label={{ en: "Event description", cz: "Popis akce" }}
      value={text}
    ></TextArea>
    <Input
      type={EInputType.text}
      label={{ en: "Entry fee", cz: "Vstupné" }}
      value={price}
    ></Input>
    <Input
      type={EInputType.text}
      label={{ en: "Telephone number", cz: "Telefonní číslo" }}
      value={telephoneNumber}
    ></Input>
    <Input
      type={EInputType.text}
      label={{ en: "E-mail", cz: "E-mail" }}
      value={email}
    ></Input>
  </form>
</>;
