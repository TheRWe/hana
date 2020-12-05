import React, { useEffect, useState } from "react";
import { Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";
import { LocText } from "../components/LocText";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { EHttpMethod, withFetch } from "../api";
import { TEventGetListGetAction } from "../common/interface/event";
import { PromiseType } from "../common/utils/types";
import { dateFromApi } from "../common/interface";

type TCalendarPageProps = {

};

type Events = PromiseType<ReturnType<TEventGetListGetAction>>["events"];

export const CalendarPage: React.FC<TCalendarPageProps> = () => {

  const [events, setEvents] = useState<Events>([]);

  useEffect(() => {
    const fetchEvents = withFetch<TEventGetListGetAction>({ method: EHttpMethod.GET, route: "/events" });

    (async () => {
      const ev = await fetchEvents();
      setEvents(ev.events);
    })();
  }, []);

  return <>
    <FilterMenu
      filterType={EFilterMenuType.events}
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

    {
      events.map(({
        authorId, createdUtc, date, description, entryFee, id, name, tags, photoUri, place, rating,
      }) =>
        <section className="container cards">
          <Tile
            imagePath={photoUri || "../images/no_image.png"}
            eventRating="4/5"
            place="Hala někde ve městě"
            date={dateFromApi(date.start).toLocaleString()}
            heading="Tvořivé dílny"
            text="Program pre žiakov materských škôl, základných a špeciálnych škôl. V tvorivej dielni si deti vyskúšajú rôzne aktivity s použitím niektorých tradičných výrobných postupov a prírodných materiálov."
            price={entryFee.toString(10) + " Kč"}
          >
          </Tile>
        </section>
      )
    }
  </>;
};
