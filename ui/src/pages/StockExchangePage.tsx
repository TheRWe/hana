import React, { useEffect, useState } from "react";
import { Tile } from "../components/Tile";
import { EContentType, FilterMenu, TFilter } from "../components/FilterMenu";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { LocText } from "../components/LocText";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { TStockExchangeGetListGetAction } from "../common/interface/stockExchange";
import { EHttpMethod, withFetch } from "../api";
import { PromiseType } from "../common/utils";
import { useProvideUsersForIds } from "../utils/useProvideUser";
import { dateToApi } from "../common/interface";

type TStockExchangePageProps = {

};

type Action = TStockExchangeGetListGetAction;
type FieldName = "stockExchanges";
const responseSelector = (resp: PromiseType<ReturnType<Action>>) => resp.stockExchanges;
const route = "stock-exchanges";
const getFilterFetchParams = (filter: TFilter): Request => ({
  pageSize: 24, pageStart: 1,
  costStart: filter.priceFrom,
  costEndInclusive: filter.priceTo,
  createdStartUtc: dateToApi(filter.dateFrom),
  createdEndInclusiveUtc: dateToApi(filter.dateTo),
  placeLatitude: filter.place?.lat,
  placeLongitude: filter.place?.lng,
  placeRangeMeters: filter.distance || 10,
  type: filter.type as any,
});

type Response = PromiseType<ReturnType<Action>>[FieldName];
type Request = Parameters<Action>[0];

export const StockExchangePage: React.FC<TStockExchangePageProps> = () => {
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
    <FilterMenu
      filterType={EContentType.stock}
      {...{ filter, setFilter }}
    >
    </FilterMenu>

    <section className="section-sort">
      <div className="container">
        <div className="sort-option">
          <FontAwesomeIcon icon={faSort} />
          <p>
            <LocText
              en="Cena"
              cz="Price"
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
            user, cost, description, name, photoUri,
          }) => <Tile
              heading={name}
              imagePath={photoUri || "../images/no_image.png"}
              text={description}
              email={user?.email || ""}
              userName={(user && (user.firstName + " " + user.lastName)) || ""}
              userRating={user?.ratings?.asSeller}
              price={`${cost.toLocaleString()} Kč`}
            />
          )
      }
    </section>
  </>;
};
