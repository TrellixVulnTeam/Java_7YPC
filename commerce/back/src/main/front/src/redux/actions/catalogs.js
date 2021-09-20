import {
  GET_CATALOG_LIST,
  GET_CATALOG_CATEGORY_LIST,
  WAIT,
  CREATE_CATALOG,
  DELETE_CATALOG,
  GET_CATALOG,
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

export const deleteCatalog = (id) => async (dispatch) => {
  // console.log("delete");
  const res = await CatalogService.deleteCatalog(id);
  dispatch({
    type: DELETE_CATALOG,
    payload: id,
  });
};

export const getCatalog = (id) => async (dispatch) => {
  const res = await CatalogService.getCatalogByID(id);
  dispatch({
    type: GET_CATALOG,
    payload: res,
  });
};
