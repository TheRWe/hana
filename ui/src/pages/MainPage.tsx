import React from "react";
import { LocText } from "../components/LocText";

// Routing
import { Link } from "react-router-dom";

// Icons
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTag, faCalendar, faSuitcase } from "@fortawesome/free-solid-svg-icons";

type TMainPageProps = {

};

export const MainPage: React.FC<TMainPageProps> = () => {

  return <>

    {/* BEGIN MAIN PAGE */}
    <section className="section-image">
      <img src="../images/title_image.png" alt="title" className="img-full"></img>
    </section>

    <section className="section-about container space center">
      <h5>
        Haná je etnografická oblasť na strednej Morave, približne na území medzi mestami Zábřeh,
        Holešov, Vyškov a Uničov, väčšie centra sa nachádzajú v nížinách okolo riek Moravy
        a Hané (zasahuje tak do Olomouckého, Zlínskeho aj Juhomoravského kraja).
        </h5>
      <h5>
        Táto webová stránka je určená pre všetkých, ktorí chcú mať aktuálne informácie o udalostiach
        a pracovných ponukách v regióne Haná. Prípadne majú záujem o inzerciu nijakého produktu, či služby.
      </h5>
      <header>
        <img src="../images/flower.png" alt="flower-icon" className="icon"></img>
      </header>
    </section>

    <section className="section-goto">
      <div className="container space">
        <div className="row">
          <article className="col-3 card-section-goto">
            <header>
              <FontAwesomeIcon icon={faCalendar} className="icon-lg" size="5x" />
              <h3>
                <LocText
                  en="Event calendar"
                  cz="Kalendář akcí"
                />
              </h3>
            </header>
            <p>
              Táto sekcia ponúka prehľad o nadchádzajúcich udalostiach v regióne Haná.
          </p>
            <Link to="/CalendarPage" className="button btn-orange">
              <LocText
                en="Show more"
                cz="Zobrazit více"
              />
            </Link>
          </article>
          <article className="col-3 card-section-goto">
            <header>
              <FontAwesomeIcon icon={faTag} className="icon-lg" size="5x" />
              <h3>
                <LocText
                  en="TODO"
                  cz="Burza"
                />
              </h3>
            </header>
            <p>
              Máte k ponuke starú alebo nepotrebnú vec? Ponúknite ju na Burze!
          </p>
            <Link to="/StockExchangePage" className="button btn-orange">
              <LocText
                en="Show more"
                cz="Zobrazit více"
              />
            </Link>
          </article>
          <article className="col-3 card-section-goto">
            <header>
              <FontAwesomeIcon icon={faSuitcase} className="icon-lg" size="5x" />
              <h3>
                <LocText
                  en="Job offers"
                  cz="Ponuky Práce"
                />
              </h3>
            </header>
            <p>
              Prehľad momentálnej inzercii služieb a ponúk práce. Prezrite si ponuky alebo vytvorte novú.
              </p>
            <Link to="/JobAdsPage" className="button btn-orange">
              <LocText
                en="Show more"
                cz="Zobrazit více"
              />
            </Link>
          </article>
        </div>
      </div>


    </section>


    <section className="section-upcoming-events container space center">
      <header>
        <h2>
          <LocText
            en="Upcoming events"
            cz="Nadcházející události"
          />
        </h2>
        <img src="../images/flower.png" alt="flower-icon" className="icon"></img>
      </header>
      {/*
       * TODO create component - take last 3 events
       */}
      <div className="row">
        <article className="col-3 card card-orange">
          <img src="../images/no_image.png" alt="ntg" />
          <h3>Tvořivé dílny</h3>
        </article>
        <article className="col-3 card card-orange">
          <img src="../images/no_image.png" alt="ntg" />
          <h3>Cirkus ve městě</h3>
        </article>
        <article className="col-3 card card-orange">
          <img src="../images/no_image.png" alt="ntg" />
          <h3>Food festival</h3>
        </article>
      </div>
      <Link to="/CalendarPage" className="button btn-orange">
        <LocText
          en="More info"
          cz="Více informací"
        />
      </Link>
    </section>
    {/* END MAIN PAGE */}

  </>;
};
