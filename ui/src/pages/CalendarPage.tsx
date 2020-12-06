import React, { useEffect, useState } from "react";
import { Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu, TFilter } from "../components/FilterMenu";
import { LocText } from "../components/LocText";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { EHttpMethod, withFetch } from "../api";
import { TEventGetListGetAction } from "../common/interface/event";
import { PromiseType } from "../common/utils/types";
import { dateFromApi } from "../common/interface";

type TCalendarPageProps = {

};

type Action = TEventGetListGetAction;
type FieldName = "events";
const responseSelector = (resp: PromiseType<ReturnType<Action>>) => resp.events;
const route = "events";
// todo: place
// todo: category
const getFilterFetchParams = (filter: TFilter): Request => ({
  pageSize: 24, pageStart: 0,
  entryFeeStart: filter.priceFrom,
  entryFeeEndInclusive: filter.priceTo,
});

type Response = PromiseType<ReturnType<Action>>[FieldName];
type Request = Parameters<Action>[0];

export const CalendarPage: React.FC<TCalendarPageProps> = () => {
  const [response, setResponse] = useState<Response>([]);
  const [filter, setFilter] = useState<TFilter>({});

  useEffect(() => {
    const fetch = withFetch<Action>({ method: EHttpMethod.GET, route });

    (async () => {
      const res = await fetch(getFilterFetchParams(filter));
      setResponse(responseSelector(res));
    })();
  }, [filter]);

  return <>
    <FilterMenu
      filterType={EFilterMenuType.events}
      {...{ filter, setFilter }}
    />

    <section className="section-sort">
      <div className="container">
        <div className="sort-option">
          <FontAwesomeIcon icon={faSort} />
          <p>
            <LocText
              en="Date"
              cz="Datum"
            />
          </p>
        </div>
        <div className="sort-option">
          <FontAwesomeIcon icon={faSort} />
          <p>
            <LocText
              en="Popularity"
              cz="Popularita"
            />
          </p>
        </div>
      </div>
    </section>

    <section className="container cards">
      {
        response.map(({
          authorId, createdUtc, date, description, entryFee, id, name, tags, photoUri, place, rating,
        }) =>
          <Tile
            heading={name}
            imagePath={photoUri || "../images/no_image.png"}
            eventRating={rating}
            place={place?.name}
            date={
              // todo: date fromater -> if date start is same with end only time end will show ...
              dateFromApi(date.start).toLocaleDateString() + " - " + dateFromApi(date.endInclusive).toLocaleDateString()}
            text={description}
            price={entryFee.toString(10) + " Kč"}
          />
        )
      }
    </section>
  </>;
};
