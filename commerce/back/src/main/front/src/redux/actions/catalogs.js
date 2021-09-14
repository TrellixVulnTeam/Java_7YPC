import { GET_CATALOG_LIST, GET_CATALOG_CATEGORY_LIST, WAIT } from "./types";
import CatalogService from "../services/catalog-service";

export const getCatalogList = () => async (dispatch) => {
  const res = await CatalogService.getCatalogs();
  dispatch({
    type: GET_CATALOG_LIST,
    payload: res,
  });
};

export const getCatalogCategory = (id) => async (dispatch) => {
  dispatch({
    type: WAIT,
  });

  const res = await CatalogService.getCatalogCategory(id);
  dispatch({
    type: GET_CATALOG_CATEGORY_LIST,
    payload: res,
  });
};
