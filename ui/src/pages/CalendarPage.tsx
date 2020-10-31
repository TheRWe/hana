import React from "react";
import { Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";

type TCalendarPageProps = {

};

export const CalendarPage: React.FC<TCalendarPageProps> = () => {

  return <>
    {/* BEGIN SECTION CALENDAR */}

    <FilterMenu
      filterType={EFilterMenuType.events}
    >
    </FilterMenu>


    <section className="section-sort">
      //sorting options
    </section>

    <section>
      <Tile
        imagePath="/static/images/no_image.png"
        eventRating="4/5"
        place="Hala někde ve městě"
        date="5.5.2018 13:00 - 15:00"
        heading="Tvořivé dílny"
        text="Program pre žiakov materských škôl, základných a špeciálnych škôl. V tvorivej dielni si deti vyskúšajú rôzne aktivity s použitím niektorých tradičných výrobných postupov a prírodných materiálov."
        price="30 kč"
      >
      </Tile>
    </section>

    {/* END SECTION CALENDAR */}
  </>;
};
