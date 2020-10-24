import React from "react";
import { LocText } from "../components/LocText";
import { EJobAdType, Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";

type TCalendarPageProps = {

};

export const CalendarPage: React.FC<TCalendarPageProps> = () => {

  return <>
    <LocText
      en="this is example homepage"
      cz="tohle je ukázková stránka"
    />

    <FilterMenu
      filterType={EFilterMenuType.events}
    >

    </FilterMenu>

    {/* <section className="section-filter-menu">
      <header className="section-filter-menu__buttons">
        <h2>display None</h2>
        <button>
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
        </button>
      </header>
      <div className="section-filter-menu__filters">
        <div className="input-filters">
          <div className="menu-filter date-filter">
            <label htmlFor="date-from">
              <LocText
                en="From"
                cz="Od"
              />
            </label>
            <input type="date" id="date-from" name="date-from" />
          </div>
          <div className="menu-filter date-filter">
            <label htmlFor="date-to">
              <LocText
                en="To"
                cz="Do"
              /></label>
            <input type="date" id="date-to" name="date-to" />
          </div>
          <div className="menu-filter">
            <label htmlFor="place">
              <LocText
                en="Place"
                cz="Místo"
              />
            </label>
            <input type="text" id="place" name="place" />
          </div>
        </div>
        <div className="type-filters">
          <label>
            <LocText
              en="Event type"
              cz="Typ akce"
            />
          </label>
          <input type="radio" name="event-type">
            <LocText
              en="For kids"
              cz="Pro děti"
            />
          </input>
          <input type="radio" name="event-type">
            <LocText
              en="Culture"
              cz="Kulturní"
            />
          </input>
          <input type="radio" name="event-type">
            <LocText
              en="Music"
              cz="Hudební"
            />
          </input>
        </div>
      </div>
    </section> */}
    <section className="section-sort">
      //sorting options
    </section>
    <main>
      <Tile
        imagePath="../images/no_image.png"
        eventRating="4/5"
        place="Hala někde ve městě"
        date="5.5.2018 13:00 - 15:00"
        heading="Tvořivé dílny"
        text="Program pre žiakov materských škôl, základných a špeciálnych škôl. V tvorivej dielni si deti vyskúšajú rôzne aktivity s použitím niektorých tradičných výrobných postupov a prírodných materiálov."
        price="30 kč"
      >

      </Tile>
      {/* <article className="tile">
        <header>
          <img src="../images/no_image.png" alt="no-image-yet" />
          <h3>Tvořivé dílny</h3>
          <div className="rating event-rating">

          </div>
        </header>
        <p>
          Program pre žiakov materských škôl, základných a špeciálnych škôl. V tvorivej dielni si deti vyskúšajú rôzne aktivity s použitím niektorých tradičných výrobných postupov a prírodných materiálov.
        </p>
        <footer className="tile-footer">
          <div className="tile-footer__info">
            <div className="tile-footer-row">
              <p>Místo</p>
              <p>Hala někde ve městě</p>
            </div>
            <div className="tile-footer-row">
              <p>Datum</p>
              <p>
                <time>5.5.2018 13:00 - 15:00</time>
              </p>
            </div>
          </div>
          <div className="tile-footer__price">
            <p>
              <LocText
                en="more info"
                cz="více informací"
              />
            </p>
            <p>30 kč</p>
          </div>
        </footer>
      </article> */}
    </main>
  </>;
};
