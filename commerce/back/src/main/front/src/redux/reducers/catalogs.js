import {
  GET_CATALOG_LIST,
  CREATE_CATALOG,
  UPDATE_CATALOG,
  DELETE_CATALOG,
  DELETE_ALL_CATALOGS,
  GET_CATALOG_CATEGORY_LIST,
  WAIT,
  GET_CATALOG,
} from "../actions/types";

const initialState = {
  catalogs: [],
  curretnCatalog: [],
  loading: true,
};

const catalogReducer = (state = initialState, action) => {
  const { type, payload } = action;
  state.loading = true;

  switch (type) {
    case GET_CATALOG_LIST:
      return {
        ...state,
        loading: false,
        catalogs: payload,
      };

    case WAIT:
      return {
        ...state,
        loading: true,
      };

    case GET_CATALOG_CATEGORY_LIST:
      return {
        ...state,
        loading: false,
        curretnCatalog: payload,
      };

    case CREATE_CATALOG:
      return {
        ...state,
        loading: false,
        catalogs: [...state.catalogs, payload],
      };

    case UPDATE_CATALOG:
      return state.map((catalog) => {
        if (catalog.id === payload.id) {
          return {
            ...catalog,
            ...payload,
          };
        } else {
          return catalog;
        }
      });

    case DELETE_CATALOG:
      return {
        ...state,
        loading: false,
        catalogs: state.catalogs.filter((c) => c.id !== payload),
      };

    case GET_CATALOG:
      return {
        ...state,
        loading: false,
        curretnCatalog: payload,
      };

    default:
      return state;
  }
};

export default catalogReducer;
