import * as express from "express";
import { EErrorCode, TErrorResponse } from "../../../common/interface/common";

const routerTest = express.Router();

routerTest.get("", (req, res) => {
  res.json({ testingEnabled: true });
});

routerTest.post("/echo", (req, res) => {
  res.json(req.body);
});

routerTest.delete("/error", (req, res) => {
  res.json({ error: { msg: "error just occured", code: EErrorCode.NotLoggedIn }, } as TErrorResponse);
});

export default routerTest;
