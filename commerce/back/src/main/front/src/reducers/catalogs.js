import {
  GET_CATALOG_LIST,
  CREATE_CATALOG,
  RETRIEVE_CATALOG,
  UPDATE_CATALOG,
  DELETE_CATALOG,
  DELETE_ALL_CATALOGS,
} from "../actions/types";

const initialState = [];

function catalogReducer(catalogs = initialState, action) {
  const { type, payload } = action;

  switch (type) {
    case GET_CATALOG_LIST:
      return payload;

    default:
      return catalogs;
  }
}

export default catalogReducer;
