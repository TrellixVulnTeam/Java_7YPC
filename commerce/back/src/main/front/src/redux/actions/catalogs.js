import { GET_CATALOG_LIST } from "./types";
import CatalogService from "../services/catalog-service";

export const getCatalogList = () => async (dispatch) => {
  // try {
  const res = await CatalogService.getCatalogs();
  // console.log(res);
  dispatch({
    type: GET_CATALOG_LIST,
    payload: res,
  });
  // } catch (err) {
  //   console.log(err);
  // }
};
