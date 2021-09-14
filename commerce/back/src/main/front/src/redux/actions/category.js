import { GET_CATEGORY_LIST, GET_CATEGORY, WAIT } from "./types";
import CategoryService from "../services/category-service";

export const getCategory = (id) => async (dispatch) => {
  dispatch({
    type: WAIT,
  });

  const res = await CategoryService.getCategory(id);
  dispatch({
    type: GET_CATEGORY,
    payload: res,
  });
};
