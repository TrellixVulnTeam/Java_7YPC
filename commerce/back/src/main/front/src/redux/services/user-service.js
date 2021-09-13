import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8081/api/catalogs";

class UserService {
  getPublicContent() {
    // return axios.get(API_URL);
  }

  getUserBoard() {
    // return axios.get(API_URL + "user", { headers: authHeader() });
    // return axios.get(API_URL);
  }

  getAdminBoard() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }
}

export default new UserService();
