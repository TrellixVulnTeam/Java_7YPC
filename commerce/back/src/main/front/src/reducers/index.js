import { combineReducers } from "redux";
import catalogReducer from "./catalogs";
import auth from "./auth";
import message from "./messsage";

export default combineReducers({
  catalogReducer,
  auth,
  message,
});
