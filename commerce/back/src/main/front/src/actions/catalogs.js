// export const getCatalogList = (catalogList) => {
//   return {
//     type: "GET_CATALOG_LIST",
//     payload: catalogList,
//   };
// };

import { GET_CATALOG_LIST } from "./types";

import CatalogDataService from "../services/catalog-service";

export const getCatalogList = () => async (dispatch) => {
  try {
    const res = await CatalogDataService.getAll();

    dispatch({
      type: GET_CATALOG_LIST,
      payload: res.data,
    });
  } catch (err) {
    console.log(err);
  }
};
