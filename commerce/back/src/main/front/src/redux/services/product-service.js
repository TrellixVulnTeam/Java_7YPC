import axios from "axios";

const API_URL = "http://localhost:8081/api/";

class ProductService {
  getProduct(id) {
    return axios.get(API_URL + `products/${id}`).then((response) => {
      console.log(response.data);
      return response.data;
    });
  }
}

export default new ProductService();
