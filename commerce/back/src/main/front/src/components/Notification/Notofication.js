import React, { Component } from "react";
import { store } from "react-notifications-component";
import "react-notifications-component/dist/theme.css";
import "animate.css";

function Notification(message) {
  switch (message) {
    case "danger":
      Danger();
      break;
    case "success":
      Success();
      break;
  }
}

function Danger() {
  return store.addNotification({
    title: "Danger",
    message: "Login is denie",
    type: "danger", // 'default', 'success', 'info', 'warning'
    insert: "top",
    container: "top-full", // where to position the notifications
    animationIn: ["animated", "fadeIn"], // animate.css classes that's applied
    animationOut: ["animated", "fadeOut"], // animate.css classes that's applied
    dismiss: {
      duration: 5000,
    },
  });
}

function Success() {
  return store.addNotification({
    title: "Success",
    message: "Login is success",
    type: "success", // 'default', 'success', 'info', 'warning'
    container: "bottom-left", // where to position the notifications
    animationIn: ["animated", "fadeIn"], // animate.css classes that's applied
    animationOut: ["animated", "fadeOut"], // animate.css classes that's applied
    dismiss: {
      duration: 3000,
    },
  });
}

export default Notification;
