import { text } from "@fortawesome/fontawesome-svg-core";
import React, { useState } from "react";
import { EContentType } from "./FilterMenu";
import { Input, EInputType } from "./Input";
import { InputPlaceAutocomplete } from "./InputPlaceAutocomplete";
import { LocText, TLocalizedText } from "./LocText";
import { SelectBox } from "./SelectBox";
import { TextArea } from "./TextArea";

const imagePath = "images/no_image.png";

export enum EEventType {
  kids,
  culture,
  musical,
}

type TAddEvent = {
  imagePath?: string
  place?: string
  date?: Date
  email?: string
  heading?: string
  text?: string
  price?: string
  telephoneNumber?: string
};

type TAddTrade = {
  imagePath?: string
  email?: string
  heading?: string
  text?: string
  price?: string
  telephoneNumber?: string
};

type TAddJob = {
  place?: string
  date?: string
  email?: string
  heading?: string
  text?: string
  price?: string
  telephoneNumber?: string
};

type State = TAddEvent | TAddTrade | TAddJob;
type StateAll = TAddEvent & TAddTrade & TAddJob;
type StateAllKeys = keyof StateAll;

type TFormAddProps = {
  id?: number,
  formType: EContentType,
  onSubmit?: () => void,
};

enum EFieldType {
  text, number, date, textArea, select, place,
}
type TField = {
  type: EFieldType,
  label: TLocalizedText,
  name: StateAllKeys,
  selectOptions?: { value: string, text: TLocalizedText }[],
};

export const FormEdit: React.FC<TFormAddProps> = ({ formType, id, onSubmit }) => {
  const [state, setState] = useState<State>({});
  const setStateProps = (stateChange: (state: any) => void) => {
    const cpy = { ...state };
    stateChange(cpy);
    setState(cpy);
  };
  const { email, heading, price, telephoneNumber, text, date, place } = state as StateAll;


  const submit = () => {

    onSubmit?.();
  };

  (() => {
    switch (formType) {
      case EContentType.events:
        break;
      case EContentType.jobAd:
        break;
      case EContentType.stock:
        break;
    }
  })();


  const makeField = (field: TField) => {
    const { label, name, type, selectOptions } = field;
    switch (type) {
      case EFieldType.text:
      case EFieldType.number:
      case EFieldType.date:
        return <>
          <Input
            type={(type === EFieldType.text) ? EInputType.text : ((type === EFieldType.number) ? EInputType.number : EInputType.date)}
            label={label}
            value={(state as any)[name]}
            onValueChange={(v: any) => setStateProps(s => s[name] = v)}
          />
        </>;
      case EFieldType.textArea:
        return <>
          <TextArea
            label={label}
            value={(state as any)[name]}
            onValueChange={(v: any) => setStateProps(s => s[name] = v)}
          />
        </>;
      case EFieldType.select:
        return <>
          <SelectBox
            label={label}
            options={selectOptions || []}
            value={(state as any)[name]}
            onValueChange={(v: any) => setStateProps(s => s[name] = v)}
          />
        </>;
      case EFieldType.place:
        return <>
          <InputPlaceAutocomplete
            label={label}
            value={(state as any)[name]}
            onValueChange={(v: any) => setStateProps(s => s[name] = v)}
          />
        </>;
    }
  };

  const tradeFields: TField[] = [
    { name: "heading", type: EFieldType.text, label: { en: "Item name", cz: "Prodávaný předmět" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Event description", cz: "Popis předmětu" }, },
    { name: "price", type: EFieldType.number, label: { en: "Price", cz: "Cena" }, },
    { name: "telephoneNumber", type: EFieldType.text, label: { en: "Telephone number", cz: "Telefonní číslo" }, },
    { name: "email", type: EFieldType.text, label: { en: "E-mail", cz: "E-mail" }, },
  ];

  const jobFields: TField[] = [
    { name: "heading", type: EFieldType.text, label: { en: "Job advert name", cz: "Název pracovního inzerátu" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Job advert description", cz: "Popis práce" }, },
    { name: "price", type: EFieldType.number, label: { en: "Pay", cz: "Plat" }, },
    { name: "place", type: EFieldType.place, label: { en: "Place", cz: "Místo vykonávání" }, },
    {
      name: "todo" as any, type: EFieldType.select, label: { en: "Type of employment", cz: "Typ pracovního poměru" },
      selectOptions: [
        { value: "fulltime", text: { en: "Full time", cz: "Plný úvazek" } },
        { value: "???", text: { en: "???", cz: "Živnost" } },
        { value: "summerjob", text: { en: "Summer job", cz: "Brigáda" } },
        { value: "parttime", text: { en: "Part time", cz: "Zkrácený úvazek" } },
        { value: "internship", text: { en: "Internship", cz: "Stáž" } },
      ],
    },
    { name: "telephoneNumber", type: EFieldType.text, label: { en: "Telephone number", cz: "Telefonní číslo" }, },
    { name: "email", type: EFieldType.text, label: { en: "E-mail", cz: "E-mail" }, },
  ];


  const eventFields: TField[] = [
    { name: "heading", type: EFieldType.text, label: { en: "Event name", cz: "Název akce" }, },
    { name: "date", type: EFieldType.date, label: { en: "Date", cz: "Datum akce" }, },
    {
      name: "todoType" as any, type: EFieldType.select, label: { en: "Type", cz: "Typ" },
      selectOptions: [
        { value: "offer", text: { en: "Offer", cz: "Nabídka" } },
        { value: "inquiry", text: { en: "Inquiry", cz: "Poptávka" } },
      ],
    },
    { name: "place", type: EFieldType.place, label: { en: "Place", cz: "Místo konání" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Event description", cz: "Popis akce" }, },
    { name: "price", type: EFieldType.number, label: { en: "Entry fee", cz: "Vstupné" }, },
    { name: "telephoneNumber", type: EFieldType.text, label: { en: "Telephone number", cz: "Telefonní číslo" }, },
    { name: "email", type: EFieldType.text, label: { en: "E-mail", cz: "E-mail" }, },
  ];


  const form = (() => {
    switch (formType) {
      case EContentType.events:
        return eventFields;
      case EContentType.jobAd:
        return jobFields;
      case EContentType.stock:
        return tradeFields;
    }
  })().map(makeField);

  return <>
    <div className="form">
      {JSON.stringify(state)}

      {/* <img className="form-picture" src={imagePath} alt="Preview" />
      <button>
        <LocText
          en="Change picture"
          cz="Změnit obrázek"
        />
      </button> */}
      {form}
      <button onClick={submit}>
        <LocText
          en="Apply"
          cz="Aplikovat změny"
        />
      </button>
    </div>
  </>;
};
