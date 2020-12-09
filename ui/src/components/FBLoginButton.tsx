import { faUser, faDoorOpen } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { useContext } from "react";
// import { useEffect, useState } from "react";

export type TLogin = { token?: string };
export const LoginContext = React.createContext<TLogin>({});

export const useLogin = () => {
  const login = useContext(LoginContext);

  return login;
};


type FBCallback = {
  status: "connected" | "unknown" | "not_authorized",
  authResponse: {
    accessToken: string,
    expiresIn: number,
    reauthorize_required_in: number,
    signedRequest: string,
    userID: string,
  }
};

type TFBLoginButtonProps = {
  setLogin: React.Dispatch<React.SetStateAction<TLogin>>;
};

export const FBLoginButton: React.FC<TFBLoginButtonProps> = ({ setLogin: sl }) => {
  // const [refreshToken, setRefreshToken] = useState(0);
  // const refresh = () => setRefreshToken(refreshToken + 1);
  // const [name, setName] = useState("");

  // const [response, setResponse] = useState<FBCallback | undefined>();

  // const login = () => {
  //   (window as any).FB.login(() => {
  //     refresh();
  //   });
  // };
  // const logout = () => {
  //   setResponse(undefined);
  //   refresh();
  // };

  // useEffect(() => {
  //   (window as any).FB.getLoginStatus((response: FBCallback) => {
  //     setResponse(response);
  //   });
  // }, [refreshToken]);

  // useEffect(() => {
  //   if (response?.status === "connected") {
  //     (window as any).FB.api("/me", (response: any) => {
  //       setName(response.name);
  //     });
  //     sl({ token: response.authResponse.accessToken });
  //   } else {
  //     setName("");
  //     sl({});
  //   }
  // }, [response, sl]);

  return <>
    <ul className="navbar-nav user-menu">
      <li className="nav-item nav-link">
        <FontAwesomeIcon icon={faUser} className="icon" size="1x" />
        <button style={{ color: "#d19453" }} >
          {/* {response?.status === "connected" ? name : "LOGIN"} */}
          LOGIN
        </button>
      </li>
      <li className="nav-item nav-link" >
        <FontAwesomeIcon icon={faDoorOpen} className="icon" size="1x" />
      </li>
    </ul>
  </>;
};
