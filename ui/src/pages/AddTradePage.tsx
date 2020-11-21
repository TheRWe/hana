import React from "react";
import { AddTradeForm } from "../components/AddTradeForm";

type TAddTradePageProps = {

};

export const AddTradePage: React.FC<TAddTradePageProps> = () => {

  return <>

    {/* BEGIN SECTION JobAdForm */}

    <section>
      <AddTradeForm></AddTradeForm>
    </section>

    {/* END SECTION JobAdForm */}
  </>;
};
