import * as express from "express";
import * as open from "open";
import * as path from "path";

export const startExpressServer = async () => {
  const app = express();
  const port = 3000;

  app.use(express.json());

  app.use("/", express.static(path.join(__dirname, "../ui/")));

  app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname,"../ui/index.html"));
  });

  app.listen(port, () => {
    console.info(`listening on: http://localhost:${port}`);
  });

  open("http://localhost:3000/");

};
