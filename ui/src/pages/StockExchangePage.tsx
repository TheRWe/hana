import React from "react";
import { Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";

type TStockExchangePageProps = {

};

export const StockExchangePage: React.FC<TStockExchangePageProps> = () => {

  return <>

    {/* BEGIN SECTION STOCK EXCHANGE */}

    <FilterMenu
      filterType={EFilterMenuType.stock}
    >
    </FilterMenu>

    <section className="section-sort">
      //sorting options
    </section>

    <section>
      <Tile
        imagePath="/static/images/no_image.png"
        heading="Stará váza"
        text="Stará čínska porcelánová váza, značená, výška 28 cm, priemer v najširšej časti 20 cm, bez poškodení, vitrínový stav."
        email="stara.vaza@gmail.com"
        userName="Sam"
        userRating="4/5"
        price="30 kč"
      >
      </Tile>
    </section>

    {/* END SECTION STOCK EXCHANGE */}
  </>;
};
