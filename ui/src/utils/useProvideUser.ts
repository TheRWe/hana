import { useState, useEffect } from "react";
import { withFetch, EHttpMethod } from "../api";
import { TUserGetByIdGetAction } from "../common/interface/user";
import { sleep, randInt, PromiseType } from "../common/utils";

export type TUser = PromiseType<ReturnType<TUserGetByIdGetAction>>;

export const useProvideUsersForIds = (usersRequestedID: number[]) => {
  const [users, setUsers] = useState<{ [key: number]: TUser }>({});

  useEffect(() => {
    (async () => {
      const userIdToLoad = usersRequestedID
        .filter(x => !users[x])
        ;

      const localCache = { ...users };
      await Promise.all(userIdToLoad.map(async id => {
        const fetchUser = withFetch<TUserGetByIdGetAction>({ method: EHttpMethod.GET, route: `users/${id}` });
        // todo: remove testing sleep
        await sleep(randInt(randInt(15_000)));
        localCache[id] = await fetchUser({});
        const newObj = { ...users, ...localCache };
        setUsers(newObj);
      }));
    })();
  }, [usersRequestedID]);

  return users;
};
