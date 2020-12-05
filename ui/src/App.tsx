import React, { useState } from "react";

// Routing
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";

// Styles
import "./App.scss";

// Icons
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDoorOpen, faGlobe, faUser } from "@fortawesome/free-solid-svg-icons";

// Components
import { ELanguages, LanguageContext, LocText } from "./components/LocText";

// Pages
import { MainPage } from "./pages/MainPage";
import { StockExchangePage } from "./pages/StockExchangePage";
import { CalendarPage } from "./pages/CalendarPage";
import { JobAdsPage } from "./pages/JobAdsPage";
import { ProfilePage } from "./pages/ProfilePage";
import { AddEventPage } from "./pages/AddEventPage";
import { AddJobAdPage } from "./pages/AddJobAdPage";
import { AddTradePage } from "./pages/AddTradePage";
import { EventDetails } from "./pages/EventDetails";
import { JobAdDetails } from "./pages/JobAdDetails";
import { TradeDetails } from "./pages/TradeDetails";

type Props = {

};

const App: React.FC<Props> = () => {

  const [isCz, setIsCz] = useState(true);

  return (<>
    <LanguageContext.Provider value={isCz ? ELanguages.cz : ELanguages.en}>

      <Router>

        {/* CHANGE LANGUAGE ICONS */}
        <ul className="language-menu">
          <li className="nav-item">
            <button onClick={() => setIsCz(false)}>
              <img src="./images/EN_logo.png" alt="English" className="nav-icon" />
            </button>
          </li>
          <li className="nav-item">
            <button onClick={() => setIsCz(true)}>
              <img src="./images/CZ_logo.png" alt="Czech" className="nav-icon" />
            </button>
          </li>
        </ul>

        {/* BEGIN MAIN MENU */}
        <section className="section-menu">
          <nav className="navbar navbar-expand-lg">
            <a className="navbar-brand" href="/">
              <img src="./images/logo.png" alt="logo" />
            </a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30">
                <path stroke="rgba(0, 0, 0, 0.5)" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2"
                  d="M4 7h22M4 15h22M4 23h22" />
              </svg>
            </button>
            <div className="collapse navbar-collapse">
              {/* LEFT SIDE */}
              <ul className="navbar-nav">
                <li className="nav-item">
                  <a className="nav-link" href="/CalendarPage">
                    <LocText
                      en="Calendar Of Events"
                      cz="Události"
                    />
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/StockExchangePage">
                    <LocText
                      en="Stock Exchange"
                      cz="Burza"
                    />
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/JobAdsPage">
                    <LocText
                      en="Job Ads"
                      cz="Pracovné Inzeráty"
                    />
                  </a>
                </li>
              </ul>
              {/* RIGHT SIDE */}
              <ul className="navbar-nav user-menu">
                <li className="nav-item nav-link">
                  <FontAwesomeIcon icon={faUser} className="icon" size="1x" />
                  <a href="/ProfilePage">Roman buk</a>
                </li>
                <li className="nav-item nav-link">
                  <FontAwesomeIcon icon={faDoorOpen} className="icon" size="1x" />
                </li>
              </ul>
            </div>

          </nav>
        </section>
        {/* END MAIN MENU */}

        {/* BEGIN BODY */}
        <main>
          <Switch>
            <Route path="/" exact>
              <MainPage />
            </Route>
            <Route path="/CalendarPage">
              <CalendarPage />
            </Route>
            <Route path="/StockExchangePage">
              <StockExchangePage />
            </Route>
            <Route path="/JobAdsPage">
              <JobAdsPage />
            </Route>
            <Route path="/ProfilePage">
              <ProfilePage />
            </Route>
            <Route path="/AddEventPage">
              <AddEventPage />
            </Route>
            <Route path="/AddJobAdPage">
              <AddJobAdPage />
            </Route>
            <Route path="/AddTradePage">
              <AddTradePage />
            </Route>
            <Route path="/EventDetails">
              <EventDetails />
            </Route>
            <Route path="/JobAdDetails">
              <JobAdDetails />
            </Route>
            <Route path="/TradeDetails">
              <TradeDetails />
            </Route>
          </Switch>
        </main>
        {/* END BODY */}

        {/* BEGIN FOOTER */}
        <footer>
          <p>
            ©2020 | GL <FontAwesomeIcon icon={faGlobe} className="icon-footer" /> BEX
          </p>
        </footer>
        {/* BEGIN FOOTER */}

      </Router>

    </ LanguageContext.Provider>
  </>
  );
};

export default App;