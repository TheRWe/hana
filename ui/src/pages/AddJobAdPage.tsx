import React from "react";
import { AddJobAdForm } from "../components/AddJobAdForm";

type TAddEventPageProps = {

};

export const AddEventPage: React.FC<TAddEventPageProps> = () => {

  return <>

    {/* BEGIN SECTION JobAdForm */}

    <section>
      <AddJobAdForm></AddJobAdForm>
    </section>

    {/* END SECTION JobAdForm */}
  </>;
};
