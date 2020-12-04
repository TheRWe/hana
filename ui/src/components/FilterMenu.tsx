import React, { useState } from "react";
import { ERadioFilterType, RadioFilter } from "../components/RadioFilter";
import { EInputType, Input } from "../components/Input";
import { SelectBox } from "../components/SelectBox";
import { ModalBox } from "../components/ModalBox";
import { LocText, useLocalized } from "./LocText";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendar, faCaretDown, faMapMarkedAlt, faMapMarkerAlt, faPlus } from "@fortawesome/free-solid-svg-icons";

export enum EFilterMenuType {
  events,
  stock,
  jobAd,
}

type FilterMenuProps = {
  filterType: EFilterMenuType
};

export const FilterMenu: React.FC<FilterMenuProps> = ({ filterType }: FilterMenuProps) => {

  const [searchVisible, setSearchVisible] = useState(false);
  const searchVisibleClassName = searchVisible ? "expanded" : "collapsed";

  const [addModalVysible, setAddModalVysible] = useState(false);

  const labelAdd = (() => {
    switch (filterType) {
      case EFilterMenuType.stock: return {
        en: "Add an item",
        cz: "Přidat položku",
      };
      case EFilterMenuType.events: return {
        en: "Add an event",
        cz: "Přidat akci",
      };
      case EFilterMenuType.jobAd: return {
        en: "Add an advertisement",
        cz: "Vytvořit inzerát",
      };
    }
  })();

  return (<>
    <section className="section-filter-menu">
      <div className="container">

        <header className="row">
          <button className="button  btn-blue left" onClick={() => setSearchVisible(!searchVisible)}>
            <LocText
              en="Search"
              cz="Vyhledávání"
            />
            <FontAwesomeIcon icon={faCaretDown} />
          </button>
          <button className="button btn-orange right" onClick={() => setAddModalVysible(true)}>
            {useLocalized(labelAdd)}
            <FontAwesomeIcon icon={faPlus} />
          </button>

          <ModalBox
            visible={addModalVysible}
            onClose={() => setAddModalVysible(false)}
            label={labelAdd}
          >
            TODO: add form
          </ModalBox>
        </header>


        <div className={["section-filter-menu__filters"]
          .concat(`section-filter-menu__filters-${searchVisibleClassName}`)
          .join(" ")
        }>

          {
            (filterType as EFilterMenuType) === EFilterMenuType.stock ? <>
              <div className="section-filter-menu__filters">
                <div className="input-filters row">
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.text}
                      labelEng="Price:   from"
                      labelCz="Cena:   od"
                    ></Input>
                    <Input
                      type={EInputType.text}
                      labelEng="- to"
                      labelCz="- do"
                    ></Input>
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      labelEng="Place:"
                      labelCz="Místo:"
                    ></Input>
                    <FontAwesomeIcon icon={faMapMarkedAlt} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      labelEng="Area:"
                      labelCz="Okolí:"
                    ></Input>
                    km
                  </div>
                </div>
                <RadioFilter
                  type={ERadioFilterType.stock}
                >
                </RadioFilter>
              </div>
            </>
              :
              undefined
          }


          {
            (filterType as EFilterMenuType) === EFilterMenuType.events ? <>
              <div className="section-filter-menu__filters">
                <div className="input-filters row">
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      labelEng="From:"
                      labelCz="Od:"
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      labelEng="To:"
                      labelCz="Do:"
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      labelEng="Place:"
                      labelCz="Místo:"
                    ></Input>
                    <FontAwesomeIcon icon={faMapMarkedAlt} />
                  </div>
                </div>
                <RadioFilter
                  type={ERadioFilterType.events}
                >
                </RadioFilter>
              </div>
            </>
              :
              undefined
          }


          {
            (filterType as EFilterMenuType) === EFilterMenuType.jobAd ? <>
              <div className="section-filter-menu__filters">
                <div className="input-filters row">
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      labelEng="From"
                      labelCz="Od"></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      labelEng="To:"
                      labelCz="Do:"></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      labelEng="Place:"
                      labelCz="Obec/Okres:"></Input>
                    <FontAwesomeIcon icon={faMapMarkerAlt} />
                    <Input
                      type={EInputType.text}
                      labelEng="  +"
                      labelCz="  +"></Input>
                      km
                  </div>
                </div>
                <div className="radio-filter row">
                  <div className="menu-filter select-filter">
                    <SelectBox
                      labelEng="Type"
                      labelCz="Typ"
                      options={[{ en: "Offer", cz: "Nabídka" }, { en: "Inquiry", cz: "Poptávka" }]}></SelectBox>
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      labelEng="Type of employment"
                      labelCz="Druhy pracovního poměru"
                      options={[{ en: "Full time", cz: "Plný úvazek" }, { en: "???", cz: "Živnost" }, { en: "Summer job", cz: "Brigáda" }, { en: "Part time", cz: "Zkrácený úvazek" }, { en: "Internship", cz: "Stáž" }]}></SelectBox>
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      labelEng="Job"
                      labelCz="Pracovní pozice"
                      options={[{ en: "IT Analyst", cz: "IT Analytik" }, { en: "Idk", cz: "Idk" }]}></SelectBox>
                  </div>
                </div>
              </div>
            </>
              :
              undefined
          }


        </div>
      </div>
    </section>
  </>
  );
};
