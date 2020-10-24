import React, { useContext } from "react";
import { LocText } from "./LocText";
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
          <h2>display None</h2>
          <Button
            labelEng="Search"
            labelCz="Vyhledávání"></Button>
          <Button
            labelEng="Add an item"
            labelCz="Přidat položku"></Button>
          {/* <button>
        <LocText
          en="Search"
          cz="Vyhledávání"
        />
      </button>
      <button>
        <LocText
          en="Add an event"
          cz="Přidat akci"
        />
      </button> */}
        </header>
        <div className="section-filter-menu__filters">
          <div className="input-filters">
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.text}
                labelEng="Price from"
                labelCz="Cena od"
              ></Input>
              <Input
                type={EInputType.text}
                labelEng="- to"
                labelCz="- do"
              ></Input>
              {/* <label htmlFor="price-from">
            <LocText
              en="Price from"
              cz="Cena od"
            />
          </label>
          <input type="date" id="price-from" name="price-from" />
          <label htmlFor="price-to">
            <LocText
              en="- to"
              cz="- do"
            />
          </label>
          <input type="date" id="price-to" name="price-to" /> */}
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                labelEng="Place"
                labelCz="Místo"
              ></Input>
              {/* <label htmlFor="place">
            <LocText
              en="Place"
              cz="Místo"
            />
          </label>
          <input type="text" id="place" name="place" /> */}
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                labelEng="Area"
                labelCz="Okolí"
              ></Input>
              {/* <label htmlFor="area">
            <LocText
              en="Area"
              cz="Okolí"
            />
          </label>
          <input type="text" id="area" name="area" /> */}
            </div>
          </div>
          <RadioFilter
            type={ERadioFilterType.stock}
          >
          </RadioFilter>
          {/* <div className="type-filters">
        <label>
          <LocText
            en="Category"
            cz="Kategorie"
          />
        </label>
        <input type="radio" id="toys" name="event-type" value="sssss" />
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
      </div> */}
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
          <h2>display None</h2>
          <Button
            labelEng="Search"
            labelCz="Vyhledávání"></Button>
          <Button
            labelEng="Add an event"
            labelCz="Přidat akci"></Button>
        </header>
        <div className="section-filter-menu__filters">
          <div className="input-filters">
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                labelEng="From"
                labelCz="Od"
              ></Input>
            </div>
            <div className="menu-filter date-filter">
              <Input
                type={EInputType.date}
                labelEng="To"
                labelCz="Do"
              ></Input>
            </div>
            <div className="menu-filter">
              <Input
                type={EInputType.text}
                labelEng="Place"
                labelCz="Místo"
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
          labelEng="Search"
          labelCz="Vyhledávání"></Button>
        <Button
          labelEng="Create an advertisement"
          labelCz="Vytvořit inzerát"></Button>
      </header>
      <div className="section-filter-menu__filters">
        <div className="input-filters">
          <div className="menu-filter date-filter">
            <Input
              type={EInputType.date}
              labelEng="From"
              labelCz="Od"></Input>
          </div>
          <div className="menu-filter date-filter">
          <Input
              type={EInputType.date}
              labelEng="To"
              labelCz="Do"></Input>
          </div>
          <div className="menu-filter">
          <Input
              type={EInputType.text}
              labelEng="Place"
              labelCz="Obec/Okres"></Input>
          <Input
              type={EInputType.text}
              labelEng="+"
              labelCz="+"></Input>
          </div>
        </div>
        <div className="select-filters">
          <div className="menu-filter select-filter">
            <SelectBox
            labelEng="Type"
            labelCz="Typ"
            options={[["Offer" ,"Nabídka"], ["Inquiry", "Poptávka"]]}></SelectBox>
          </div>
          <div className="menu-filter select-filter">
          <SelectBox
            labelEng="Type of employment"
            labelCz="Druhy pracovního poměru"
            options={[["Full time" ,"Plný úvazek"], ["???", "Živnost"], ["Summer job", "Brigáda"], ["Part time", "Zkrácený úvazek"], ["Internship", "Stáž"]]}></SelectBox>
          </div>
          <div className="menu-filter select-filter">
          <SelectBox
            labelEng="Job"
            labelCz="Pracovní pozice"
            options={[["IT Analyst" ,"IT Analytik"], ["Idk", "Idk"]]}></SelectBox>
          </div>
        </div>
      </div>
    </section>
    :
    undefined
  }
</>;
