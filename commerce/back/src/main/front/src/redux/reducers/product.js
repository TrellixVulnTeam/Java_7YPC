import { GET_PRODUCT, WAIT } from "../actions/types";

const initialState = {
  products: [],
  loading: true,
};

const productReducer = (state = initialState, action) => {
  const { type, payload } = action;
  // state.loading = true;
  switch (type) {
    case GET_PRODUCT:
      return {
        ...state,
        loading: false,
        products: payload,
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

export default productReducer;
