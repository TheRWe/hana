import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.scss";
import { ErrorCode, withFetch } from "./api/core";
import { TAction } from "./common/interface/common";

type Props = {

};

const App: React.FC<Props> = () => {
  const [echoMsg, setEchoMsg] = useState("this should travel to server and back to UI");

  const testEcho = async () => {

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
    <div className="App">
      <header className="App-header">
        <div>Send echo message
          <input value={echoMsg} onChange={e => setEchoMsg(e.target.value)}></input>
          <button onClick={testEcho}>Send</button>
        </div>
        <div>Send error message
          <button onClick={testError}>Send</button>
        </div>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  </>
  );
};

export default App;
