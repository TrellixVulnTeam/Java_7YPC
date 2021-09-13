import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import "./App.css";
import App from "./App";

import ReactNotification from "react-notifications-component";
import "react-notifications-component/dist/theme.css";

import { Provider } from "react-redux";
import store from "./store";

import { userAuth } from "./redux/actions/auth";
let token = localStorage.getItem("accessToken");
if (token != null && token != "") {
  userAuth(token, store.dispatch).then(() => {
    console.log("user login");
  });
}

ReactDOM.render(
  // <React.StrictMode>
  // <ReactNotification />
  <Provider store={store}>
    <App />
  </Provider>,
  // </React.StrictMode>,
  document.getElementById("root")
);
