import React from "react";
import { EJobAdType, Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { LocText } from "../components/LocText";
import { faSort } from "@fortawesome/free-solid-svg-icons";

type TJobAdsPageProps = {

};

export const JobAdsPage: React.FC<TJobAdsPageProps> = () => {

  return <>

    {/* BEGIN SECTION JOBS ADS */}

    <FilterMenu
      filterType={EFilterMenuType.jobAd}
    >
    </FilterMenu>

    <section className="section-sort">
      <div className="container">
        <div className="sort-option">
          <FontAwesomeIcon icon={faSort} />
          <p>
            <LocText
              en="Popularity"
              cz="Popularita"
            />
          </p>
        </div>
      </div>
    </section>

    <section className="container cards">
      <Tile
        heading="Sekanie trávy"
        text="Posekanie celého pozemku. Kosačka nutnosť."
        pay="120 kc/hod"
        jobType="Brigáda"
        userName="Tomáš"
        userRating={undefined}
        place="Vrch pod kopcom"
        jobAdType={EJobAdType.inq}
      >
      </Tile>
      <Tile
        heading="Tepování koberců"
        text="Vyčistenie škvŕn z kobercov a obnova farby."
        pay="200 kc/hod"
        jobType="Brigáda"
        userName="Sam"
        userRating={undefined}
        place="Za Borinou"
        jobAdType={EJobAdType.off}
      >
      </Tile>

    </section>

    {/* END SECTION JOBS ADS */}
  </>;
};
