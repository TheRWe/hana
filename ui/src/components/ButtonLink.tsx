import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";
// Routing
import { Link } from "react-router-dom";

type ButtonLinkProps = {
  label: TLocalizedText
  linkTo: string
};


export const ButtonLink: React.FC<ButtonLinkProps> = (props) => {

  return (<>
    {/* <button>

    </button> */}
    <Link to={props.linkTo} className="button btn-orange">
      {useLocalized(props.label)}
      {props.children}
    </Link>
  </>);
};
