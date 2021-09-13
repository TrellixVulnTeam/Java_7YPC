import axios from "axios";

const API_URL = "http://localhost:8081/api/";
// http://localhost:8081/api/catalogs-slim

class CatalogService {
  getCatalogs() {
    return axios.get(API_URL + "catalogs-slim").then((response) => {
      // console.log(response);
      return response.data;
    });
  }
}

export default new CatalogService();
