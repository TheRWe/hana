import React from "react";
import { ERadioFilterType, RadioFilter } from "../components/RadioFilter";
import { EInputType, Input } from "../components/Input";
import { Button } from "../components/Button";
import { SelectBox } from "../components/SelectBox";

export enum EFilterMenuType {
  events,
  stock,
  jobAd,
}

type FilterMenuProps = {
  filterType: EFilterMenuType
};

export const FilterMenu: React.FC<FilterMenuProps> = ({ filterType }: FilterMenuProps) => <>

  {/*********************************
   * Filters for stock exhange page *
   **********************************/}
  {
    (filterType as EFilterMenuType) === EFilterMenuType.stock ?
      <section className="section-filter-menu">
        <header className="section-filter-menu__buttons">
          <Button
            label={{ en: "Search", cz: "Vyhledávání" }}
          ></Button>
          <Button
            label={{ en: "Add an item", cz: "Přidat položku" }}
          ></Button>
        </header>
        <div className="section-filter-menu__filters">
          <div className="input-filters">
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.text}
                label = {{en: "Price from", cz: "Cena od"}}
              ></Input>
              <Input
                type={EInputType.text}
                label = {{en: "- to", cz: "- do"}}
              ></Input>
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                label = {{en: "Place", cz: "Místo"}}
              ></Input>
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                label = {{en: "Area", cz: "Okolí"}}
              ></Input>
            </div>
          </div>
          <RadioFilter
            type={ERadioFilterType.stock}
          >
          </RadioFilter>
        </div>
      </section>
      :
      undefined
  }

  {/**************************************
   * Filters for Calender of events page *
   ***************************************/}
  {
    (filterType as EFilterMenuType) === EFilterMenuType.events ?
      <section className="section-filter-menu">
        <header className="section-filter-menu__buttons">
          <Button
            label={{ en: "Search", cz: "Vyhledávání" }}
          ></Button>
          <Button
            label={{ en: "Add an event", cz: "Přidat akci" }}
          ></Button>
        </header>
        <div className="section-filter-menu__filters">
          <div className="input-filters">
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                label = {{en: "From", cz: "Od"}}
              ></Input>
            </div>
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                label = {{en: "To", cz: "Do"}}
              ></Input>
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                label = {{en: "Place", cz: "Místo"}}
              ></Input>
            </div>
          </div>
          <RadioFilter
            type={ERadioFilterType.events}
          >
          </RadioFilter>
        </div>
      </section>
      :
      undefined
  }

  {/***************************
   * Filters for Job ads page *
   ****************************/}
  {
    (filterType as EFilterMenuType) === EFilterMenuType.jobAd ?
      <section className="section-filter-menu">
        <header className="section-filter-menu__buttons">
          <h2>/*display None*/</h2>
          <Button
            label={{ en: "Search", cz: "Vyhledávání" }}
          ></Button>
          <Button
            label={{ en: "Create an advertisement", cz: "Vytvořit inzerát" }}
          ></Button>
        </header>
        <div className="section-filter-menu__filters">
          <div className="input-filters">
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                label = {{en: "From", cz: "Od"}}></Input>
            </div>
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                label = {{en: "To", cz: "Do"}}></Input>
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                label = {{en: "Place", cz: "Obec/Okres"}}></Input>
              <Input
                type={EInputType.text}
                label = {{en: "+", cz: "+"}}></Input>
            </div>
          </div>
          <div className="select-filters">
            <div className="menu-filter select-filter">
              <SelectBox
                label = {{en: "Type", cz: "Typ"}}
                options={[{ en: "Offer", cz: "Nabídka" }, { en: "Inquiry", cz: "Poptávka" }]}></SelectBox>
            </div>
            <div className="menu-filter select-filter">
              <SelectBox
                label = {{en: "Type of employment", cz: "Druhy pracovního poměru"}}
                options={[{ en: "Full time", cz: "Plný úvazek" }, { en: "???", cz: "Živnost" }, { en: "Summer job", cz: "Brigáda" }, { en: "Part time", cz: "Zkrácený úvazek" }, { en: "Internship", cz: "Stáž" }]}></SelectBox>
            </div>
            <div className="menu-filter select-filter">
              <SelectBox
                label = {{en: "Job", cz: "Pracovní pozice"}}
                options={[{ en: "IT Analyst", cz: "IT Analytik" }, { en: "Idk", cz: "Idk" }]}></SelectBox>
            </div>
          </div>
        </div>
      </section>
      :
      undefined
  }
</>;
