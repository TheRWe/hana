import React, { useEffect, useState } from "react";
import { Tile } from "../components/Tile";
import { EFilterMenuType, FilterMenu } from "../components/FilterMenu";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { LocText } from "../components/LocText";
import { faSort } from "@fortawesome/free-solid-svg-icons";
import { TStockExchangeGetListGetAction } from "../common/interface/stockExchange";
import { EHttpMethod, withFetch } from "../api";
import { PromiseType, randInt, sleep } from "../common/utils";
import { TUserGetByIdGetAction } from "../common/interface/user";
import { StockExchangeType } from "../common/interface/shared";
import { useProvideUsersForIds } from "../utils/useProvideUser";

type TStockExchangePageProps = {

};

type TExchanges = PromiseType<ReturnType<TStockExchangeGetListGetAction>>["stockExchanges"];
type TUser = PromiseType<ReturnType<TUserGetByIdGetAction>>;

export const StockExchangePage: React.FC<TStockExchangePageProps> = () => {
  const [exchanges, setExchanges] = useState<TExchanges>([]);

  const [usersIds, setUsersIds] = useState<number[]>([]);
  useEffect(() => { setUsersIds(exchanges.map(x => x.authorId)); }, [exchanges]);
  const users = useProvideUsersForIds(usersIds);



  useEffect(() => {
    const fetch = withFetch<TStockExchangeGetListGetAction>({ method: EHttpMethod.GET, route: "stock-exchanges" });

    (async () => {
      const res = await fetch({ pageSize: 24, pageStart: 0 });
      setExchanges(res.stockExchanges);
    })();
  }, []);


  return <>
    <FilterMenu
      filterType={EFilterMenuType.stock}
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
        exchanges
          .map(x => ({ ...x, user: users[x.authorId] }))
          .map(({
            user, actual, authorId, cost, createdUtc, description, id, name, tags, type, photoUri, place,
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
