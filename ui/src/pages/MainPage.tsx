import React from "react";
import { LocText } from "../components/LocText";

type TMainPageProps = {

};

export const MainPage: React.FC<TMainPageProps> = () => {

  return <>
    <LocText
      en="this is example homepage"
      cz="tohle je ukázková stránka"
    />
    <main>
      <section className="section-image">
        <h2>/*display None*/</h2>
        <img alt="big-image"></img>
      </section>
      <section className="section-about">
        <h2>/*display None*/</h2>
        <p>
          Haná je etnografická oblasť na strednej Morave, približne na území medzi mestami Zábřeh, Holešov, Vyškov a Uničov, väčšie centra sa nachádzajú najmä v nížinách okolo riek Moravy a Hané (zasahuje tak do Olomouckého, Zlínskeho aj Juhomoravského kraja).
        </p>
        <p>
          Táto webová stránka je určená pre všetkých, ktorí chcú mať aktuálne informácie o udalostiach a pracovných ponukách v regióne Haná. Prípadne majú záujem o inzerciu nijakého produktu, či služby.
        </p>
      </section>
      <section className="section-goto">
        <h2>/*display None*/</h2>
        <article>
          <header>
            <img alt="calendar-image"></img>
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
          <button className="button">
            <LocText
              en="Show more"
              cz="Zobrazit více"
            />
          </button>
        </article>
        <article>
          <header>
            <img alt="stock-exchange-image"></img>
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
          <button className="button">
            <LocText
              en="Show more"
              cz="Zobrazit více"
            />
          </button>
        </article>
        <article>
          <header>
            <img alt="job-offers-image"></img>
            <h3>
              <LocText
                en="Show more"
                cz="Job offers"
              />
            </h3>
          </header>
          <p>
            Prehľad momentálnej inzercii služieb a ponúk práce. Prezrite si ponuky alebo vytvorte novú.
          </p>
          <button className="button">
            <LocText
              en="Show more"
              cz="Zobrazit více"
            />
          </button>
        </article>
      </section>
      <section className="section-upcoming-events">
      <header>
        <h2>
          <LocText
            en="Upcoming events"
            cz="Nadcházející události"
          />
        </h2>
        <img alt="flower" />
      </header>

      <article className="event">
        <img className="event__image" src="../images/no_image.png" alt="no-image-yet" />
        <h3 className="event__heading">Tvořivé dílny</h3>
      </article>
      <article className="event">
        <img className="event__image" src="../images/no_image.png" alt="no-image-yet" />
        <h3 className="event__heading">Cirkus ve městě</h3>
      </article>
      <article className="event">
        <img className="event__image" src="../images/no_image.png" alt="no-image-yet" />
        <h3 className="event__heading">Food festival</h3>
      </article>

      <button>
        <LocText
          en="More info"
          cz="Více informací"
        />
      </button>
    </section>
    </main>
  </>;
};
