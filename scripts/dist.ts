// tslint:disable: no-console
import * as fs from "fs";
import { existsSync, readdirSync } from "fs";
import * as path from "path";


const buildRootDir = "../assembly/target/";
const findJar = () => {
  const regex = /.*\.jar$/;
  const jarFileName = readdirSync(buildRootDir).find(x => regex.exec(x));
  // @ts-ignore
  return path.join(buildRootDir, jarFileName);
};

const distDir = "../dist/";

if (!existsSync(distDir))
  fs.mkdirSync(distDir);

const jarFilePath = findJar();

fs.copyFileSync(jarFilePath, path.join(distDir, "cz.globex.hana.jar"));

try {
  fs.rmdirSync(buildRootDir, { recursive: true });
} catch {
  console.warn("failed to clean up");
}
