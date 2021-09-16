import { combineReducers } from "redux";
import catalogReducer from "./catalogs";
import categoryReducer from "./category";
import productReducer from "./product";
import auth from "./auth";
import message from "./messsage";

export default combineReducers({
  categoryReducer,
  catalogReducer,
  productReducer,
  auth,
  message,
});
