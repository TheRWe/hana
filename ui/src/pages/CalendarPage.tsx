import React, { useCallback, useEffect, useState } from "react";
import { Tile } from "../components/Tile";
import { EContentType, FilterMenu, TFilter } from "../components/FilterMenu";
import { LocText } from "../components/LocText";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { EHttpMethod, withFetch } from "../api";
import { TEventGetListGetAction } from "../common/interface/event";
import { PromiseType } from "../common/utils/types";
import { dateFromApi, dateToApi } from "../common/interface";

type TCalendarPageProps = {

};

type Action = TEventGetListGetAction;
type FieldName = "events";
const responseSelector = (resp: PromiseType<ReturnType<Action>>) => resp.events;
const route = "events";
const placeRangeMeters = 10_000;
const getFilterFetchParams = (filter: TFilter): Request => ({
  pageSize: 24, pageStart: 1,
  entryFeeStart: filter.priceFrom,
  entryFeeEndInclusive: filter.priceTo,
  createdStartUtc: dateToApi(filter.dateFrom),
  createdEndInclusiveUtc: dateToApi(filter.dateTo),
  placeLatitude: filter.place?.lat,
  placeLongitude: filter.place?.lng,
  placeRangeMeters,
});

type Response = PromiseType<ReturnType<Action>>[FieldName];
type Request = Parameters<Action>[0];

export const CalendarPage: React.FC<TCalendarPageProps> = () => {
  const [response, setResponse] = useState<Response>([]);
  const [filter, setFilter] = useState<TFilter>({});
  const [editID, setEditID] = useState<undefined | number>(undefined);
  const exitEdit = useCallback(() => { setEditID(undefined); }, [setEditID]);

  useEffect(() => {
    const fetch = withFetch<Action>({ method: EHttpMethod.GET, route });

    (async () => {
      setResponse([]);
      const res = await fetch(getFilterFetchParams(filter));
      setResponse(responseSelector(res));
    })();
  }, [filter]);

  return <>
    <FilterMenu
      filterType={EContentType.events}
      {...{ filter, setFilter }}
      {...{ editID, exitEdit }}
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

    <section className="container row cards">
      {
        response.map(({
          authorId, createdUtc, date, description, entryFee, id, name, tags, photoUri, place, rating, // email,
        }) =>
          <Tile
            name={name}
            imagePath={photoUri || "../images/no_image.png"}
            eventRating={rating}
            place={place?.name}
            date={
              // todo: date fromater -> if date start is same with end only time end will show ...
              dateFromApi(date.start).toLocaleDateString() + " - " + dateFromApi(date.endInclusive).toLocaleDateString()}
            text={description}
            price={entryFee.toString(10) + " Kč"}
            // email={email}
            onEdit={() => setEditID(id)
            }
          />
        )
      }
    </section>
  </>;
};
