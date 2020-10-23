import React, { useState } from "react";
import { ErrorCode, withFetch } from "./api/core";
import { TAction } from "./common/interface/common";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

// Styles
import "./App.scss";

// Components
import { ELanguages, LanguageContext, LocText } from "./components/LocText";

// Pages
import { MainPage } from "./pages/MainPage";
import { StockExchangePage } from "./pages/StockExchangePage";
import { CalendarPage } from "./pages/CalendarPage";
import { JobAdsPage } from "./pages/JobAdsPage";

type Props = {

};

const App: React.FC<Props> = () => {
  const [echoMsg, setEchoMsg] = useState("this should travel to server and back to UI");
  const [isCz, setIsCz] = useState(true);

  const testEcho = async () => {

    const getArticle = withFetch<TAction<{ echoMsg: string }, { echoMsg: string }>>({
      route: "test/echo",
      method: "POST",
    });

    try {
      const test = await getArticle({ echoMsg });
      alert(`response success ${JSON.stringify(test)}`);
    } catch (e) {
      alert(e);
    }
  };

  const testError = async () => {

    const getArticle = withFetch<TAction<{ echoMsg: string }, { echoMsg: string }>>({
      route: "test/error",
      method: "DELETE",
    });

    try {
      const test = await getArticle({ echoMsg });
      alert(`response success ${JSON.stringify(test)}`);
    } catch (e) {
      if (e instanceof ErrorCode)
        alert(`coded error ${e.code}:\n ${e.message}`);
      else
        alert(`error without code:\n ${e.message}`);
    }
  };

  return (<>
    <LanguageContext.Provider value={isCz ? ELanguages.cz : ELanguages.en}>
      {/*Change language icons*/}
      <div>
        <button
          onClick={() => setIsCz(!isCz)}
    style={{position:"fixed", fontSize:"3em", right:0 }}
        >
          <LocText
            cz="cz"
            en="en"
          />
        </button>
      </div>

      <div className="App">
        <header className="App-header">
          <div>
            <LocText
              en="Send echo messagee"
              cz="Poslat testovací zprávu"
            />
            <input value={echoMsg} onChange={e => setEchoMsg(e.target.value)}></input>
            <button onClick={testEcho}>Send</button>
          </div>
          <div>Send error message
          <button onClick={testError}>Send</button>
          </div>

          <Router>
            <nav>
              <ul>
                <li>
                  <Link to="/">Home</Link>
                </li>
                <li>
                  <Link to="/CalendarPage">Calendar Of Events</Link>
                </li>
                <li>
                  <Link to="/StockExchangePage">Stock Exchange</Link>
                </li>
                <li>
                  <Link to="/JobAdsPage">Job Ads</Link>
                </li>
              </ul>
            </nav>

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
            </Switch>

          </Router>

        </header>
      </div>
    </ LanguageContext.Provider>
  </>
  );
};

export default App;
