import { execSync } from "child_process";
import * as fs from "fs";
import { lstatSync, copyFileSync, existsSync, mkdirSync, readdirSync } from "fs";
import * as path from "path";
import { join } from "path";
import { copyRecrusivePreservingFolders } from "../common/utils/fs";


// used to configure pkg
const fakePackageJson = {
  name: "hana",
  bin: "./server/index.js",
  pkg: {
    assets: [
      "./ui/**/*",
    ],
  },
};

const withTemp = (fnc: (temp: string) => void) => {
  const temp = "../temp/";
  if (fs.existsSync(temp))
    fs.rmdirSync(temp, { recursive: true });

  try {
    fs.mkdirSync(temp);
    fnc(temp);
  } finally {
    fs.rmdirSync(temp, { recursive: true });
  }
};

withTemp((temp) => {

  const inTemp = (target: string) => path.join(temp, target);
  [
    { source: "../ui/build/", target: inTemp("ui") },
    { source: "../server/build/", target: inTemp("server") },
    { source: "../server/node_modules/", target: inTemp("node_modules") },
  ]
    .forEach(({ source, target }) => copyRecrusivePreservingFolders(source, target))
    ;

  fs.writeFileSync(inTemp("package.json"), JSON.stringify(fakePackageJson));

  execSync("cd .. && yarn pkg ./temp/ --out-dir dist", { windowsHide: true });
});
