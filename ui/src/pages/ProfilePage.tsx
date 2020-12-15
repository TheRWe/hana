import React from "react";
import { EInputType, Input } from "../components/Input";
import { LocText } from "../components/LocText";

type TProfilePageProps = {

};

export const ProfilePage: React.FC<TProfilePageProps> = () => {

  return <>

    {/* BEGIN SECTION PROFILE */}


    <section className="container container-center">
      <div className="row" id="profile">
        <div className="col-3">
          <img src="../images/tile_no_image.svg" alt="ntg" />
          <form>
            <Input
              type={EInputType.text}
              label={{ en: "Name", cz: "Jméno" }}
              value="Roman"
            ></Input>
            <Input
              type={EInputType.text}
              label={{ en: "Surname", cz: "Příjmení" }}
              value="NOVY"
            ></Input>
            <Input
              type={EInputType.text}
              label={{ en: "E-mail", cz: "E-mail" }}
              value="Roman@gmail.com"
            ></Input>
          </form>
        </div>
        <div className="col-9">
          <h3>
            <LocText
              en="Actions History"
              cz="História akcií"
            />
          </h3>
        </div>
      </div>
    </section>

    {/* END SECTION PROFILE */}
  </>;
};
