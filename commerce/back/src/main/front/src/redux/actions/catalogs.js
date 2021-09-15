import {
  GET_CATALOG_LIST,
  GET_CATALOG_CATEGORY_LIST,
  WAIT,
  CREATE_CATALOG,
} from "./types";
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

export const addNewCatalog = (name) => async (dispatch) => {
  try {
    const res = await CatalogService.addNewCatalog(name);

    dispatch({
      type: CREATE_CATALOG,
      payload: res,
    });

    // return Promise.resolve(res.data);
  } catch (err) {
    return Promise.reject(err);
  }
};
