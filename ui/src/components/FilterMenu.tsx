import React, { useState } from "react";
import { ERadioFilterType, RadioFilter } from "../components/RadioFilter";
import { EInputType, Input } from "../components/Input";
import { SelectBox } from "../components/SelectBox";
import { ModalBox } from "../components/ModalBox";
import { LocText, useLocalized } from "./LocText";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendar, faCaretDown, faMapMarkedAlt, faMapMarkerAlt, faPlus } from "@fortawesome/free-solid-svg-icons";
import { InputPlaceAutocomplete, Place } from "./InputPlaceAutocomplete";

export enum EFilterMenuType {
  events,
  stock,
  jobAd,
}

export type TFilter = {
  dateFrom?: Date,
  dateTo?: Date,
  place?: Place,
  distance?: number,
  priceFrom?: number,
  priceTo?: number,
  type?: string,
  typeOfEmployment?: string,
  typeOfJob?: string,
};

type FilterMenuProps = {
  filterType: EFilterMenuType,
  filter: TFilter,
  setFilter: React.Dispatch<React.SetStateAction<TFilter>>,
};

export const FilterMenu: React.FC<FilterMenuProps> = ({ filterType, filter, setFilter }: FilterMenuProps) => {
  const [searchVisible, setSearchVisible] = useState(false);
  const [addModalVysible, setAddModalVysible] = useState(false);

  const setFilterProp = (fnc: (filter: TFilter) => void) => {
    const cpy = { ...filter }; fnc(cpy); setFilter(cpy);
  };

  const searchVisibleClassName = searchVisible ? "expanded" : "collapsed";

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
                      type={EInputType.number}
                      label={{
                        en: "Price:   from", cz: "Cena:   od",
                      }}
                      value={filter.priceFrom || 0}
                      onValueChange={(val) => setFilterProp(x => x.priceFrom = val)}
                    />
                    <Input
                      type={EInputType.number}
                      label={{
                        en: "- to", cz: "- do",
                      }}
                      value={filter.priceTo || 0}
                      onValueChange={(val) => setFilterProp(x => x.priceTo = val)}
                    />
                  </div>
                  <div className="menu-filter">
                    <InputPlaceAutocomplete
                      label={{
                        en: "Place:", cz: "Místo:",
                      }}
                      value={filter.place}
                      onValueChange={(val) => setFilterProp(x => x.place = val)}
                    />
                    <FontAwesomeIcon icon={faMapMarkedAlt} />
                  </div>
                  <div className="menu-filter">
                    <Input
                      type={EInputType.number}
                      label={{
                        en: "Area:", cz: "Okolí:",
                      }}
                      value={filter.distance}
                      onValueChange={(val) => setFilterProp(x => x.distance = val)}
                    />
                    km
                  </div>
                </div>
                <RadioFilter
                  type={ERadioFilterType.stock}
                  {...{ filter, setFilterProp }}
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
                      value={filter.dateFrom}
                      onValueChange={(val) => setFilterProp(x => x.dateFrom = val)}
                    />
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      label={{
                        en: "To:",
                        cz: "Do:",
                      }}
                      value={filter.dateTo}
                      onValueChange={(val) => setFilterProp(x => x.dateTo = val)}
                    />
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <InputPlaceAutocomplete
                      label={{
                        en: "Place:", cz: "Místo:",
                      }}
                      value={filter.place}
                      onValueChange={(val) => setFilterProp(x => x.place = val)}
                    />
                    <FontAwesomeIcon icon={faMapMarkedAlt} />
                  </div>
                </div>
                <RadioFilter
                  type={ERadioFilterType.events}
                  {...{ filter, setFilterProp }}
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
                      value={filter.dateFrom}
                      onValueChange={(val) => setFilterProp(x => x.dateFrom = val)}
                    />
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter date-filter">
                    <Input
                      type={EInputType.date}
                      label={{
                        en: "To:",
                        cz: "Do:",
                      }}
                      value={filter.dateTo}
                      onValueChange={(val) => setFilterProp(x => x.dateTo = val)}
                    />
                    <FontAwesomeIcon icon={faCalendar} />
                  </div>
                  <div className="menu-filter">
                    <InputPlaceAutocomplete
                      label={{
                        en: "Place:", cz: "Místo:",
                      }}
                      value={filter.place}
                      onValueChange={(val) => setFilterProp(x => x.place = val)}
                    />
                    <FontAwesomeIcon icon={faMapMarkerAlt} />
                    <Input
                      type={EInputType.number}
                      label={{
                        en: "  +",
                        cz: "  +",
                      }}
                      value={filter.distance}
                      onValueChange={(val) => setFilterProp(x => x.distance = val)}
                    />
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
                      options={[
                        { value: "offer", text: { en: "Offer", cz: "Nabídka" } },
                        { value: "inquiry", text: { en: "Inquiry", cz: "Poptávka" } },
                      ]}
                      value={filter.type || ""}
                      onValueChange={(val) => setFilterProp(x => x.type = val)}
                    />
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      label={{
                        en: "Type of employment",
                        cz: "Druhy pracovního poměru",
                      }}
                      options={[
                        { value: "fulltime", text: { en: "Full time", cz: "Plný úvazek" } },
                        { value: "???", text: { en: "???", cz: "Živnost" } },
                        { value: "summerjob", text: { en: "Summer job", cz: "Brigáda" } },
                        { value: "parttime", text: { en: "Part time", cz: "Zkrácený úvazek" } },
                        { value: "internship", text: { en: "Internship", cz: "Stáž" } },
                      ]}
                      value={filter.typeOfEmployment || ""}
                      onValueChange={(val) => setFilterProp(x => x.typeOfEmployment = val)}
                    />
                  </div>
                  <div className="menu-filter select-filter">
                    <SelectBox
                      label={{
                        en: "Job",
                        cz: "Pracovní pozice",
                      }}
                      options={[
                        { value: "itnalyst", text: { en: "IT Analyst", cz: "IT Analytik" } },
                        { value: "idk", text: { en: "Idk", cz: "Idk" } },
                      ]}
                      value={filter.typeOfJob || ""}
                      onValueChange={(val) => setFilterProp(x => x.typeOfJob = val)}
                    />
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
