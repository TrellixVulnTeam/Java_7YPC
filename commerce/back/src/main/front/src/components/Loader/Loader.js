import React from "react";
import Loader from "react-loader-spinner";
//other logic

export default class Load extends React.Component {
  render() {
    return (
      <Loader
        type="Audio"
        color="#000"
        height={100}
        width={100}
        timeout={10000} //3 secs
        style={{
          position: "fixed",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
        }}
      />
    );
  }
}
