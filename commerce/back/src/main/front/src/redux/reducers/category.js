import { GET_CATEGORY_LIST, GET_CATEGORY, WAIT } from "../actions/types";

const initialState = {
  categories: [],
  loading: true,
};

const categoryReducer = (state = initialState, action) => {
  const { type, payload } = action;
  // state.loading = true;
  switch (type) {
    case GET_CATEGORY:
      return {
        ...state,
        loading: false,
        categories: payload,
      };

    case WAIT:
      return {
        ...state,
        loading: true,
      };
    default:
      return state;
  }
};

export default categoryReducer;
