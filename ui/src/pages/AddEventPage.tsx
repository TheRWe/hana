import React from "react";
import { AddEventForm } from "../components/AddEventForm";

type TAddEventPageProps = {

};

export const AddEventPage: React.FC<TAddEventPageProps> = () => {

  return <>

    {/* BEGIN SECTION AddEventForm */}

    <section>
      <AddEventForm></AddEventForm>
    </section>

    {/* END SECTION AddEventForm */}
  </>;
};
