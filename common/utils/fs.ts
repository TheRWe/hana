import { lstatSync, copyFileSync, existsSync, mkdirSync, readdirSync } from "fs";
import { join } from "path";

export const copyRecrusivePreservingFolders = (from: string, to: string, fileReg: RegExp = /.*/) => {
  // todo: how to work with symbolic links
  if (lstatSync(from).isSymbolicLink())
    return;

  if (lstatSync(from).isFile()) {
    if (fileReg.test(from))
      copyFileSync(from, to)
        ;
    return;
  }

  if (!existsSync(to))
    mkdirSync(to)
      ;

  readdirSync(from)
    .forEach(x => copyRecrusivePreservingFolders(join(from, x), join(to, x), fileReg))
    ;
};