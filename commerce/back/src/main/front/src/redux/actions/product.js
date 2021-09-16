import { GET_PRODUCT, WAIT } from "./types";
import ProductService from "../services/product-service";

export const getProduct = (id) => async (dispatch) => {
  dispatch({
    type: WAIT,
  });

  const res = await ProductService.getProduct(id);
  console.log("res " + res);

  dispatch({
    type: GET_PRODUCT,
    payload: res,
  });
};
