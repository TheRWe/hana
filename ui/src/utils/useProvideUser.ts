import { useState, useEffect } from "react";
import { withFetch, EHttpMethod } from "../api";
import { TUserGetByIdGetAction } from "../common/interface/user";
import { PromiseType } from "../common/utils";

export type TUser = PromiseType<ReturnType<TUserGetByIdGetAction>>;

export const useProvideUsersForIds = (usersRequestedID: number[]) => {
  const [users, setUsers] = useState<{ [key: number]: TUser }>({});

  useEffect(() => {
    let canceled = false;
    (async () => {
      const userIdToLoad = usersRequestedID
        .filter(x => !users[x])
        ;

      const localCache = { ...users };
      Promise.all(userIdToLoad.map(async id => {
        const fetchUser = withFetch<TUserGetByIdGetAction>({ method: EHttpMethod.GET, route: `users/${id}` });
        localCache[id] = await fetchUser({});
        const newObj = { ...users, ...localCache };
        if (!canceled)
          setUsers(newObj);
      }));
    })();

    return () => { canceled = true; };
  }, [usersRequestedID, users]);

  return users;
};
