import React from "react";
import { LocText, TLocalizedText, useLocalized } from "./LocText";

type ModalBoxProps = {
  visible: boolean,
  onClose?: () => void,
  label: TLocalizedText,
};

export const ModalBox: React.FC<ModalBoxProps> = ({ visible, onClose = () => { }, label, children }) => {
  if (!visible)
    return <></>;

  const close = () => {
    onClose();
  };

  return (<>
    <div className="modal">
      <div className="modal-content">
        <div className="modal-header">
          <div className="modal-title">
            <LocText
              {...label}
            />
          </div>
          <span className="close" onClick={close}>&times;</span>
        </div>
        <div className="modal-body">
          {children}
        </div>
      </div>
    </div>
  </>);
};