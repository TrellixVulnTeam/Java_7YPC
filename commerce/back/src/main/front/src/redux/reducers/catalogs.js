import {
  GET_CATALOG_LIST,
  CREATE_CATALOG,
  UPDATE_CATALOG,
  DELETE_CATALOG,
  DELETE_ALL_CATALOGS,
} from "../actions/types";

const initialState = {
  catalogs: [],
  loading: true,
};

const catalogReducer = (state = initialState, action) => {
  const { type, payload } = action;

  switch (type) {
    case GET_CATALOG_LIST:
      // console.log("GET_CATALOG_LIST");
      return {
        ...state,
        loading: false,
        catalogs: payload,
      };

    case CREATE_CATALOG:
      return [...state, payload];

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
      return state.filter(({ id }) => id !== payload.id);

    default:
      return state;
  }
};

export default catalogReducer;
