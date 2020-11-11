// tslint:disable: no-console
import * as fs from "fs";
import { existsSync, readdirSync } from "fs";
import * as path from "path";


const buildRootDir = "../target/";
const findJar = () => {
  const regex = /.*\.jar$/;
  const jarFileName = readdirSync(buildRootDir).find(x => regex.exec(x));
  return path.join(buildRootDir, jarFileName);
};

const distDir = "../dist/";

if (!existsSync(distDir))
  fs.mkdirSync(distDir);

const jarFilePath = findJar();

fs.copyFileSync(jarFilePath, path.join(distDir, "hana.jar"));

try {
  fs.rmdirSync(buildRootDir, { recursive: true });
} catch {
  console.warn("failed to clean up");
}
