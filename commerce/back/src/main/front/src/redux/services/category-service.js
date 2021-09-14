import axios from "axios";

const API_URL = "http://localhost:8081/api/";

class CategoryService {
  getCategories() {
    // return axios.get(API_URL + "catalogs-slim").then((response) => {
    //   // console.log(response);
    //   return response.data;
    // });
  }

  getCategory(id) {
    return axios.get(API_URL + `categories/${id}`).then((response) => {
      // console.log(response);
      return response.data;
    });
  }
}

export default new CategoryService();
