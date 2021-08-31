import React, { Component } from "react";
import { store } from "react-notifications-component";
import "react-notifications-component/dist/theme.css";
import "animate.css";

function Notification(type, message) {
  switch (type) {
    case "danger":
      Danger(message);
      break;
    case "success":
      Success(message);
      break;
  }
}

function Danger(message) {
  return store.addNotification({
    title: "Danger",
    message: message,
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

function Success(message) {
  return store.addNotification({
    title: "Success",
    message: message,
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
