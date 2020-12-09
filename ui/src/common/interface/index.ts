export type APIDate = number[];

// todo: test this, change Date definitions inside shared.ts
export const dateFromApi = (apidate: APIDate): Date => {
  const date = new (Date as any)(...apidate as any);
  return date;
};

export const dateToApi: {
  (date: Date): string,
  (date: Date | undefined): string | undefined,
} = ((date: Date | undefined) => {
  return date?.toISOString().split("Z")[0];
}) as any;
