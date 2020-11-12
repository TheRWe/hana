
/** create promise that resolves after given ms' */
export const sleep = async (ms: number) => {
  return new Promise((r) => {
    setTimeout(() => r(), ms);
  });
};
