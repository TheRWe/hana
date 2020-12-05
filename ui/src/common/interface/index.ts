export type APIDate = number[];

// todo: test this, change Date definitions inside shared.ts
export const dateFromApi = (apidate: APIDate): Date =>{
  const date = new (Date as any)(...apidate as any);
  return date;
};
