import axios from "axios";

const API_URL = "http://localhost:8081/api/auth/";

class AuthService {
  loginUser(usernameOrEmail, password) {
    return axios
      .post(API_URL + "login", { usernameOrEmail, password })
      .then((response) => {
        console.log(response);
        if (response.data.accessToken) {
          localStorage.setItem("accessToken", response.data.accessToken);
        }
        return response.data;
      });
  }

  logoutUser() {
    localStorage.removeItem("accessToken");
  }

  registerUser(username, email, password) {
    return axios.post(API_URL + "register", { username, email, password });
  }
}

export default new AuthService();
