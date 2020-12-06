import React, { useEffect, useState } from "react";
import { EJobAdType, Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu, TFilter } from "../components/FilterMenu";
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

type Action = TAdGetListGetAction;
type FieldName = "ads";
const responseSelector = (resp: PromiseType<ReturnType<Action>>) => resp.ads;
const route = "ads";
const getFilterFetchParams = (filter: TFilter): Request => ({
  pageSize: 24, pageStart: 0,
  salaryStart: filter.priceFrom,
  salaryEndInclusive: filter.priceTo,
});

type Response = PromiseType<ReturnType<Action>>[FieldName];
type Request = Parameters<Action>[0];

export const JobAdsPage: React.FC<TJobAdsPageProps> = () => {
  const [response, setResponse] = useState<Response>([]);
  const [filter, setFilter] = useState<TFilter>({});

  useEffect(() => {
    const fetch = withFetch<Action>({ method: EHttpMethod.GET, route });

    (async () => {
      const res = await fetch(getFilterFetchParams(filter));
      setResponse(responseSelector(res));
    })();
  }, [filter]);

  const [usersIds, setUsersIds] = useState<number[]>([]);
  useEffect(() => { setUsersIds(response.map(x => x.authorId)); }, [response]);
  const users = useProvideUsersForIds(usersIds);

  return <>

    {/* BEGIN SECTION JOBS ADS */}

    <FilterMenu
      filterType={EFilterMenuType.jobAd}
      {...{ filter, setFilter }}
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
        response
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
