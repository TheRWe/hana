import * as express from "express";
import { existsSync } from "fs";
import * as open from "open";
import * as path from "path";

const dirUi = path.join(__dirname, "../ui/");

export const startExpressServer = async () => {
  const app = express();
  const port = 3000;

  app.use(express.json());

  app.listen(port, () => {
    // tslint:disable-next-line: no-console
    console.info(`listening on: http://localhost:${port}`);
  });

  // in dev mode we have no build of ui
  if (existsSync(dirUi)) {
    app.use("/", express.static(dirUi));

    app.get("/", (req, res) => {
      res.sendFile(path.join(__dirname, "../ui/index.html"));
    });

    open("http://localhost:3000/");
  } else {
    app.get("/", (req, res) => {
      res.redirect("http://localhost:3001/");
    });
  }
};
