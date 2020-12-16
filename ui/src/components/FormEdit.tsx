import React, { useEffect, useState } from "react";
import { EHttpMethod, withFetch } from "../api";
import { dateFromApi, dateToApi } from "../common/interface";
import { TAdGetByIdGetAction, TAdPostAction } from "../common/interface/ad";
import { TEventGetByIdGetAction, TEventPostAction } from "../common/interface/event";
import { TStockExchangeGetByIdGetAction, TStockExchangePostAction } from "../common/interface/stockExchange";
import { PromiseType } from "../common/utils";
import { EContentType } from "./FilterMenu";
import { Input, EInputType } from "./Input";
import { InputPlaceAutocomplete, Place } from "./InputPlaceAutocomplete";
import { LocText, TLocalizedText } from "./LocText";
import { SelectBox } from "./SelectBox";
import { TextArea } from "./TextArea";

export enum EEventType {
  kids,
  culture,
  musical,
}

type TStateEvent = {
  imagePath?: string
  place?: Place
  date?: Date
  name?: string
  text?: string
  price?: number
};

type TStateTrade = {
  imagePath?: string
  email?: string
  name?: string
  text?: string
  price?: number
  place?: Place
};

type TStateJob = {
  place?: Place
  date?: Date
  email?: string
  name?: string
  text?: string
  price?: number
};

type State = TStateEvent | TStateTrade | TStateJob;
type StateAll = TStateEvent & TStateTrade & TStateJob;
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

/** returns place for api */
const placeApi = (place: Place | undefined) => ({
  latitude: place?.lat || 0,
  longitude: place?.lng || 0,
});

const mapping = (state: State, type: EContentType) => {

  const eventMapping = (state: Required<TStateEvent>): Parameters<TEventPostAction>[0] => ({
    date: {
      start: dateToApi(state.date),
      endInclusive: dateToApi(state.date),
    },
    description: state.text,
    entryFee: state.price,
    photoUri: "",
    place: placeApi(state.place),
    tags: [],
    name: state.name,
  });

  const jobMapping = (state: Required<TStateJob>): Parameters<TAdPostAction>[0] => ({
    actual: true,
    payout: state.price,
    // todo: add to both mappings
    type: "DEMAND" as any,
    description: state.text,
    photoUri: "",
    place: placeApi(state.place),
    tags: [],
    name: state.name,
  });

  const stockMapping = (state: Required<TStateTrade>): Parameters<TStockExchangePostAction>[0] => ({
    description: state.text,
    photoUri: "",
    place: placeApi(state.place),
    tags: [],
    actual: true,
    cost: state.price,
    // todo: add to both mappings
    type: "BUY" as any,
    name: state.name,
  });

  return (() => {
    switch (type) {
      case EContentType.events: return eventMapping;
      case EContentType.jobAd: return jobMapping;
      case EContentType.stock: return stockMapping;
    }
  })()(state as any);
};

const placeFromApi = (place: ({
  name: string;
  latitude: number;
  longitude: number;
} | undefined)): Place | undefined => {
  if (!place) return;
  const { latitude, longitude, name } = place;
  return ({
    lat: latitude,
    lng: longitude,
    name,
  });
};

const mappingInverse = (state: any, type: EContentType) => {

  const eventMapping = (res: PromiseType<ReturnType<TEventGetByIdGetAction>>): TStateEvent => ({
    date: res.date && dateFromApi(res.date.start),
    text: res.description,
    price: res.entryFee,
    place: placeFromApi(res.place),
    name: res.name,

  });

  const jobMapping = (res: PromiseType<ReturnType<TAdGetByIdGetAction>>): TStateJob => ({
    price: res.payout,
    text: res.description,
    place: placeFromApi(res.place),
    name: res.name,
  });

  const stockMapping = (res: PromiseType<ReturnType<TStockExchangeGetByIdGetAction>>): TStateTrade => ({
    text: res.description,
    place: placeFromApi(res.place),
    price: res.cost,
    name: res.name,
  });

  return (() => {
    switch (type) {
      case EContentType.events: return eventMapping;
      case EContentType.jobAd: return jobMapping;
      case EContentType.stock: return stockMapping;
    }
  })()(state as any);
};


export const FormEdit: React.FC<TFormAddProps> = ({ formType, id, onSubmit }) => {
  const [state, setState] = useState<State>({});
  const setStateProps = (stateChange: (state: any) => void) => {
    const cpy = { ...state };
    stateChange(cpy);
    setState(cpy);
  };

  const submit = () => {
    if (!id) {
      const route =
        formType === EContentType.events ? `events`
          : formType === EContentType.stock ? `stock-exchanges`
            : `ads`
        ;
      const fetch = withFetch({ method: EHttpMethod.POST, route });
      fetch(mapping(state, formType));
    } else {
      const route =
        formType === EContentType.events ? `events/${id}`
          : formType === EContentType.stock ? `stock-exchanges/${id}`
            : `ads/${id}`
        ;
      const fetch = withFetch({ method: EHttpMethod.PUT, route });
      fetch(mapping(state, formType));
    }
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

  useEffect(() => {
    if (!id) return;
    (async () => {
      const route =
        formType === EContentType.events ? `events/${id}`
          : formType === EContentType.stock ? `stock-exchanges/${id}`
            : `ads/${id}`
        ;
      const fetch = withFetch({ method: EHttpMethod.GET, route });
      const res = await fetch({});
      setState(mappingInverse(res, formType));
    })();
  }, [id, setState, formType]);

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
    { name: "name", type: EFieldType.text, label: { en: "Item name", cz: "Prodávaný předmět" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Event description", cz: "Popis předmětu" }, },
    { name: "price", type: EFieldType.number, label: { en: "Price", cz: "Cena" }, },
  ];

  const jobFields: TField[] = [
    { name: "name", type: EFieldType.text, label: { en: "Job advert name", cz: "Název pracovního inzerátu" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Job advert description", cz: "Popis práce" }, },
    { name: "price", type: EFieldType.number, label: { en: "Pay", cz: "Plat" }, },
    { name: "place", type: EFieldType.place, label: { en: "Place", cz: "Místo vykonávání" }, },
    {
      name: "type" as any, type: EFieldType.select, label: { en: "Type of employment", cz: "Typ pracovního poměru" },
      selectOptions: [
        { value: "fulltime", text: { en: "Full time", cz: "Plný úvazek" } },
        { value: "trade", text: { en: "Trade", cz: "Živnost" } },
        { value: "summerjob", text: { en: "Summer job", cz: "Brigáda" } },
        { value: "parttime", text: { en: "Part time", cz: "Zkrácený úvazek" } },
        { value: "internship", text: { en: "Internship", cz: "Stáž" } },
      ],
    },
  ];


  const eventFields: TField[] = [
    { name: "name", type: EFieldType.text, label: { en: "Event name", cz: "Název akce" }, },
    /* TODO start and end */
    { name: "date",  type: EFieldType.date, label: { en: "Date", cz: "Datum akce" }, },
    { name: "date", type: EFieldType.date, label: { en: "Date", cz: "Datum akce" }, },
    {
      name: "type" as any, type: EFieldType.select, label: { en: "Type", cz: "Typ" },
      selectOptions: [
        { value: "cultural", text: { en: "Cultural", cz: "Kulturní" } },
        { value: "music", text: { en: "Music", cz: "Hudební" } },
        { value: "kids", text: { en: "For kids", cz: "Pro děti" } },
      ],
    },
    { name: "place", type: EFieldType.place, label: { en: "Place", cz: "Místo konání" }, },
    { name: "text", type: EFieldType.textArea, label: { en: "Event description", cz: "Popis akce" }, },
    { name: "price", type: EFieldType.number, label: { en: "Entry fee", cz: "Vstupné" }, },
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
    <form>

      {/*JSON.stringify(state)*/}

      <p>Obrázky nejsou dostupné, FB api nenalezeno</p>
      {/*
      <img className="form-picture" src={"images/no_image.png"} alt="Preview" />
      <button>
        <LocText
          en="Change picture"
          cz="Změnit obrázek"
        />
      </button>
      */}
      {form}
      <div className="form-bottom">
        <button className="btn btn-orange" onClick={submit}>
          <LocText
            en="Apply"
            cz="Aplikovat změny"
          />
        </button>
      </div>
    </form>
  </>;
};
