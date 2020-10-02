import { sleep } from "./common/utils/promise";
import { startExpressServer } from "./express";


console.info("Server starting...");

(async()=>{

  try{
    await startExpressServer();
  }catch(e){
    console.error(e);
  }
})();

sleep(10000);
