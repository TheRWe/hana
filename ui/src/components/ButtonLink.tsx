import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";
// Routing
import { Link } from "react-router-dom";

type ButtonLinkProps = {
  label: TLocalizedText
  linkTo: string
};


export const ButtonLink: React.FC<ButtonLinkProps> = ({ label, linkTo }: ButtonLinkProps) => {

  return (<>
    <button>

    </button>
    <Link to={linkTo} className="button btn-orange">
      {useLocalized(label)}
    </Link>
  </>);
};
