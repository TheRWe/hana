import * as fs from "fs";
import { join } from "path";

const makeSymlink = () => {
  if (fs.existsSync("common") && !fs.statSync("common").isSymbolicLink())
    fs.unlinkSync("common");

  if (!fs.existsSync("common"))
    fs.symlinkSync(join("../../common"), "common", "dir");
};

process.chdir("..");
process.chdir(join("./ui/src/"));

makeSymlink();

process.chdir(join("../../"));
process.chdir(join("./server/src/"));

makeSymlink();
