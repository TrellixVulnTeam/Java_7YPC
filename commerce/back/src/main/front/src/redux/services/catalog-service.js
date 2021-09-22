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

  getCatalogCategory(id) {
    return axios.get(API_URL + `catalogs/${id}`).then((response) => {
      // console.log(response.data);
      return response.data;
    });
  }

  addNewCatalog(name) {
    return axios.post(API_URL + `catalogs`, { name }).then((response) => {
      // console.log("post " + response.data);
      return response.data;
    });
  }

  addCatalog(name, file) {
    let formData = new FormData();
    formData.append("file", file);
    formData.append("name", name);

    console.log(formData);

    return axios
      .post(API_URL + `catalog`, formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      })
      .then((response) => {
        return response.data;
      });
  }

  deleteCatalog(id) {
    return axios.delete(API_URL + `catalogs/${id}`).then((response) => {
      // console.log("delete " + response.data);
      // return response.data;
    });
  }

  getCatalogByID(id) {
    return axios.get(API_URL + `catalog/${id}`).then((response) => {
      return response.data;
    });
  }
}

export default new CatalogService();
