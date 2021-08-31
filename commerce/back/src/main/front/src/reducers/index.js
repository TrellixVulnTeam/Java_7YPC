import { combineReducers } from "redux";
import loginReducer from "./login";
import catalogReducer from "./catalogs";

export default combineReducers({
  loginReducer,
  catalogReducer,
});
