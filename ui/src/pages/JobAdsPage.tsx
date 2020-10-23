import React from "react";
import { LocText } from "../components/LocText";

type TJobAdsPageProps = {

};

export const JobAdsPage: React.FC<TJobAdsPageProps> = () => {

  return <>
    <LocText
      en="this is example homepage"
      cz="tohle je ukázková stránka"
    />
    <section className="section-filter-menu">
      <header className="section-filter-menu__buttons">
        <h2>/*display None*/</h2>
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
                cz="Obec/Okres"
              />
            </label>
            <input type="text" id="place" name="place" />
            <label htmlFor="place-area">
              <LocText
                en="+"
                cz="Obec/Okres"
              />
            </label>
            <input type="text" id="place-area" name="place-area" />
          </div>
        </div>
        <div className="select-filters">
          <div className="menu-filter select-filter">
            <label htmlFor="type">
              <LocText
                en="Type"
                cz="Typ"
              />
            </label>
            <select name="type" id="type">
              <option value="Nabídka">Nabídka</option>
              <option value="Poptávka">Poptávka</option>
            </select>
          </div>
          <div className="menu-filter select-filter">
            <label htmlFor="job-type">
              <LocText
                en="Type of employment"
                cz="Druhy pracovního poměru"
              />
            </label>
            <select name="job-type" id="job-type">
              <option value="Plný úvazek">Plný úvazek</option>
              <option value="Živnost">Živnot</option>
              <option value="Dohoda (brigáda)">Dohoda (brigáda)</option>
              <option value="Zkrácený úvazek">Zkrácený úvazek</option>
              <option value="Stáž">Stáž</option>
            </select>
          </div>
          <div className="menu-filter select-filter">
            <label htmlFor="job">
              <LocText
                en="Job"
                cz="Pracovní pozice"
              />
            </label>
            <select name="job" id="job">
              <option value="IT Analytik">IT Analytik</option>
              <option value="Nevím">Nevím</option>
              <option value="Něco">Něco</option>
            </select>
          </div>
        </div>
      </div>
    </section>
    <section className="section-sort">
      //sorting options
    </section>
    <main>
      <article className="tile">
        <header>
          <h3>Sekanie trávy</h3>
        </header>
        <p>
          Posekanie celého pozemku. Kosačka nutnosť.
        </p>
        <footer className="tile-footer">
          <div className="tile-footer__info">
            <div className="tile-footer-info-row">
              <p>Plat</p>
              <p>120 kč/hod</p>
            </div>
            <div className="tile-footer-info-row">
              <p>Druh</p>
              <p>Brigáda (jednorázová)</p>
            </div>
            <div className="tile-footer-info-row">
              <p>Ponúka</p>
              <p>
                Tomáš
              </p>
              <div className="rating user-rating">

              </div>
            </div>
            <div className="tile-footer-info-row">
              <p>Miesto</p>
              <p>Vrch pod kopcom</p>
            </div>
          </div>
          <div className="tile-footer__ad-type">
            <p>
              <LocText
                en="more info"
                cz="více informací"
              />
            </p>
            <p className="ad-type_offer">Nabídka</p>
          </div>
        </footer>
      </article>
      <article className="tile">
      <header>
          <h3>Tepovanie kobercov</h3>
        </header>
        <p>
          Vyčistenie škvŕn z kobercov a obnova farby.
        </p>
        <footer className="tile-footer">
          <div className="tile-footer__info">
            <div className="tile-footer-info-row">
              <p>Plat</p>
              <p>200 kč/hod</p>
            </div>
            <div className="tile-footer-info-row">
              <p>Druh</p>
              <p>Brigáda (jednorázová)</p>
            </div>
            <div className="tile-footer-info-row">
              <p>Ponúka</p>
              <p>
                Sam
              </p>
              <div className="rating user-rating">

              </div>
            </div>
            <div className="tile-footer-info-row">
              <p>Miesto</p>
              <p>Za Borinou</p>
            </div>
          </div>
          <div className="tile-footer__ad-type">
            <p>
              <LocText
                en="more info"
                cz="více informací"
              />
            </p>
            <p className="ad-type_inquiry">Poptávka</p>
          </div>
        </footer>
      </article>
    </main>
  </>;
};
