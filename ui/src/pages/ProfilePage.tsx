import React from "react";
import { EInputType, Input } from "../components/Input";

type TProfilePageProps = {

};

export const ProfilePage: React.FC<TProfilePageProps> = () => {

  return <>

    {/* BEGIN SECTION PROFILE */}

    <section>
      <img className="profile-photo" src="../images/no_image.png" alt="profile-image" />
      <form>
        <Input
          type={EInputType.text}
          label = {{en: "Name", cz: "Jméno"}}
        ></Input>
        <Input
          type={EInputType.text}
          label = {{en: "Surname", cz: "Příjmení"}}
        ></Input>
        <Input
          type={EInputType.text}
          label = {{en: "E-mail", cz: "E-mail"}}
        ></Input>
      </form>
    </section>

    {/* END SECTION PROFILE */}
  </>;
};
