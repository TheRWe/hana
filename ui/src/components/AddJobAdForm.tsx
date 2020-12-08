import React from "react";
import { EInputType, Input } from "./Input";
import { TextArea } from "./TextArea";
import { SelectBox } from "./SelectBox";


type AddJobAdFormProps = {
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

export const AddJobAdForm: React.FC<AddJobAdFormProps> = ({ place, date, email, heading, text, price, telephoneNumber }: AddJobAdFormProps) => <>
  <form>
    <Input
      type={EInputType.text}
      label = {{en: "Job advert name", cz: "Název pracovního inzerátu"}}
      value={heading}
    ></Input>
    <TextArea
      label = {{en: "Job advert description", cz: "Popis práce"}}
      value={text}
    ></TextArea>
    <Input
      type={EInputType.text}
      label = {{en: "Pay", cz: "Plat"}}
      value={price}
    ></Input>
    <Input
      type={EInputType.text}
      label = {{en: "Place", cz: "Místo vykonávání"}}
      value={place}
    ></Input>
    <SelectBox
      label = {{en: "Type of employment", cz: "Typ pracovního poměru"}}
      options={[
        { value: "fulltime", text: { en: "Full time", cz: "Plný úvazek" } },
        { value: "???", text: { en: "???", cz: "Živnost" } },
        { value: "summerjob", text: { en: "Summer job", cz: "Brigáda" } },
        { value: "parttime", text: { en: "Part time", cz: "Zkrácený úvazek" } },
        { value: "internship", text: { en: "Internship", cz: "Stáž" } },
      ]}
      value={
        // todo:
        ""}
      onValueChange={()=>{}}
      ></SelectBox>
    <Input
      type={EInputType.text}
      label = {{en: "Telephone number", cz: "Telefonní číslo"}}
      value={telephoneNumber}
    ></Input>
    <Input
      type={EInputType.text}
      label = {{en: "E-mail", cz: "E-mail"}}
      value={email}
    ></Input>
  </form>
</>;
