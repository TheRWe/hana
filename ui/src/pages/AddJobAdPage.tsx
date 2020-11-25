import React from "react";
import { AddJobAdForm } from "../components/AddJobAdForm";

type TAddJobAdPageProps = {

};

export const AddJobAdPage: React.FC<TAddJobAdPageProps> = () => {

  return <>

    {/* BEGIN SECTION JobAdForm */}

    <section>
      <AddJobAdForm></AddJobAdForm>
    </section>

    {/* END SECTION JobAdForm */}
  </>;
};
