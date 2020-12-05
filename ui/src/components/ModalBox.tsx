import React from "react";
import { LocText } from "./LocText";

type ModalBoxProps = {
  isHidden: boolean
};

export const ModalBox: React.FC<ModalBoxProps> = ({ isHidden }: ModalBoxProps) => {

  return (<>

    {
      isHidden
        ?
        null
        :
        <div className="modal">
          <div className="modal-content">
            <div className="modal-header">
              <div className="modal-title">
                <LocText
                  en="header"
                  cz="nadpis"
                /> </div>
              <span className="close">&times;</span>
            </div>
            <div className="modal-body">
              <p>Some text in the Modal..</p>
            </div>
          </div>
        </div>
    }

  </>);
};