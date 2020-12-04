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
          <button className="button btn-orange right">
            {useLocalized((() => {
              switch (filterType) {
                case EFilterMenuType.stock:
                  return {
                    en: "Add an item",
                    cz: "Přidat položku",
                  };
                case EFilterMenuType.events:
                  return {
                    en: "Add an event",
                    cz: "Přidat akci",
                  };
                case EFilterMenuType.jobAd:
                  return {
                    en: "Add an advertisement",
                    cz: "Vytvořit inzerát",
                  };
              }
            })())}
            <FontAwesomeIcon icon={faPlus} />
          </button>

          <ModalBox
            isHidden={true}
          ></ModalBox>
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
                      label={{
                        en: "Price:   from", cz: "Cena:   od",
                      }}
                    ></Input>
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "- to", cz: "- do",
                      }}
                    ></Input>
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "Place:", cz: "Místo:",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faMapMarkedAlt} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "Area:", cz: "Okolí:",
                      }}
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
                      label={{
                        en: "From:",
                        cz: "Od:",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      label={{
                        en: "To:",
                        cz: "Do:",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "Place:",
                        cz: "Místo:",
                      }}
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
                      label={{
                        en: "From",
                        cz: "Od",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      label={{
                        en: "To:",
                        cz: "Do:",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "Place:",
                        cz: "Obec/Okres:",
                      }}
                    ></Input>
                    <FontAwesomeIcon icon={faMapMarkerAlt} />
                    <Input
                      type={EInputType.text}
                      label={{
                        en: "  +",
                        cz: "  +",
                      }}
                    ></Input>
                      km
                  </div>
                </div>
                <div className="radio-filter row">
                  <div className="menu-filter select-filter">
                    <SelectBox
                      label={{
                        en: "Type",
                        cz: "Typ",
                      }}
                      options={[{ en: "Offer", cz: "Nabídka" }, { en: "Inquiry", cz: "Poptávka" }]}></SelectBox>
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      label={{
                        en: "Type of employment",
                        cz: "Druhy pracovního poměru",
                      }}
                      options={[{ en: "Full time", cz: "Plný úvazek" }, { en: "???", cz: "Živnost" }, { en: "Summer job", cz: "Brigáda" }, { en: "Part time", cz: "Zkrácený úvazek" }, { en: "Internship", cz: "Stáž" }]}></SelectBox>
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      label={{
                        en: "Job",
                        cz: "Pracovní pozice",
                      }}
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
