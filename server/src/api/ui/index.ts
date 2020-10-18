import * as express from "express";
import { fakeArticleGetActionUI } from "../../common/mock/example";
import routerTest from "./testing";

const routerApi = express.Router();

routerApi.get("", (req, res) => {
  res.json({ msg: "api running" });
});

// todo: only developement
routerApi.use("/test", routerTest);

export default routerApi;
