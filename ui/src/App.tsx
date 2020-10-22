import React, { useState } from "react";
import "./App.scss";
import { ErrorCode, withFetch } from "./api/core";
import { TAction } from "./common/interface/common";
import { ELanguages, LanguageContext, LocText } from "./components/LocText";
import { MainPage } from "./pages/MainPage";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { SecondPage } from "./pages/SecondPage";

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
                  <Link to="/second">SecondPage</Link>
                </li>
              </ul>
            </nav>

            <Switch>
              <Route path="/" exact>
                <MainPage />
              </Route>
              <Route path="/second">
                <SecondPage />
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
