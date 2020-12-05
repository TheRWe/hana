
// todo: test this, change Date definitions inside shared.ts
export const dateFromApi = (apidate: Date): Date =>{
  const date = new (Date as any)(...apidate as any);
  return date;
};
