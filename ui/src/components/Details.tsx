import React from "react";
import { LocText } from "./LocText";


type DetailsProps = {
  imagePath?: string
  heading: string
  text: string
  price?: string
  pay?: string
  entryFee?: string
  telephoneNumber?: string
  email?: string
  place?: string
  date?: string
  empType?: string
  jobAdType?: string
};


export const Details: React.FC<DetailsProps> = (props: DetailsProps) => <>
  {/*
  fotka

  haeding

  popis

  DODATEČNÉINFO:
  Kdo
  Kde
  Kdy
  Cena
  Vstupné
  Plat
  */}
  {(props.imagePath)
    ? <img src={props.imagePath} alt="Article" />
    : undefined}

  <h2>{props.heading}</h2>

  <p>{props.text}</p>

  <section>
    <h3>
      <LocText
        cz="Dodatečné informace"
        en="Additional informations"
      ></LocText>
    </h3>

    {/* Contact */}
    {(props.email)
      ?
      <p>
        <span>
          <LocText
            cz="Email:"
            en="Email:"></LocText>
        </span>
        <span>
          {props.email}
        </span>
      </p>
      : undefined}
    {(props.telephoneNumber)
      ?
      <p>
        <span>
          <LocText
            cz="Telefonní čislo:"
            en="Telephone number:"></LocText>
        </span>
        <span>
          {props.telephoneNumber}
        </span>
      </p>
      : undefined}
    {/* Where */}
    {(props.place)
      ?
      <p>
        <span>
          <LocText
            cz="Místo:"
            en="Place:"></LocText>
        </span>
        <span>
          {props.place}
        </span>
      </p>
      : undefined}
    {/* When */}
    {(props.date)
      ?
      <p>
        <span>
          <LocText
            cz="Datum:"
            en="Date:"></LocText>
        </span>
        <span>
          {props.date}
        </span>
      </p>
      : undefined}
    {/*Price/Pay/Entry fee*/}
    {(props.price)
      ?
      <p>
        <span>
          <LocText
            cz="Cena:"
            en="Price:"></LocText>
        </span>
        <span>
          {props.price}
        </span>
      </p>
      : undefined}

    {(props.pay)
      ?
      <p>
        <span>
          <LocText
            cz="Plat:"
            en="Pay:"></LocText>
        </span>
        <span>
          {props.pay}
        </span>
      </p>
      : undefined}

    {(props.entryFee)
      ?
      <p>
        <span>
          <LocText
            cz="Vstupné:"
            en="Entry fee:"></LocText>
        </span>
        <span>
          {props.entryFee}
        </span>
      </p>
      : undefined}
    {/* Type of employment (part time, full time...)*/}
    {(props.empType)
      ?
      <p>
        <span>
          <LocText
            cz="Typ pracovního poměru:"
            en="Type of employment:"></LocText>
        </span>
        <span>
          {props.empType}
        </span>
      </p>
      : undefined}
    {/* Job ad type (nabídka/poptávka) */}
    {(props.jobAdType)
      ?
      <p>
        <span>
          <LocText
            cz="Nabídka/poptávka:"
            en="Offer/Inquiry:"></LocText>
        </span>
        <span>
          {props.jobAdType}
        </span>
      </p>
      : undefined}

  </section>
</>;
