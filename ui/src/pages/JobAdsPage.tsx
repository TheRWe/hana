import React, { useEffect, useState } from "react";
import { EJobAdType, Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { LocText } from "../components/LocText";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { withFetch, EHttpMethod } from "../api";
import { TStockExchangeGetListGetAction } from "../common/interface/stockExchange";
import { useProvideUsersForIds } from "../utils/useProvideUser";
import { TAdGetListGetAction } from "../common/interface/ad";
import { PromiseType } from "../common/utils";

type TJobAdsPageProps = {

};

type Ads = PromiseType<ReturnType<TAdGetListGetAction>>["ads"];

export const JobAdsPage: React.FC<TJobAdsPageProps> = () => {
  const [ads, setAds] = useState<Ads>([]);

  const [usersIds, setUsersIds] = useState<number[]>([]);
  useEffect(() => { setUsersIds(ads.map(x => x.authorId)); }, [ads]);
  const users = useProvideUsersForIds(usersIds);

  useEffect(() => {
    const fetch = withFetch<TAdGetListGetAction>({ method: EHttpMethod.GET, route: "ads" });

    (async () => {
      const res = await fetch({ pageSize: 24, pageStart: 0 });
      setAds(res.ads);
    })();
  }, []);

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
      {
        ads
          .map(x => ({ ...x, user: users[x.authorId] }))
          .map(({
            user, actual, authorId, createdUtc, description, id, name, tags, type, photoUri, place, payout,
          }) => <Tile
              heading={name}
              text={description}
              jobType={type}
              place={place?.name}
              pay={payout}
              userName={(user && (user.firstName + " " + user.lastName)) || ""}
              userRating={user?.ratings?.asSeller}
              jobAdType={EJobAdType.inq}
            />
          )
      }
    </section>

    {/* END SECTION JOBS ADS */}
  </>;
};
