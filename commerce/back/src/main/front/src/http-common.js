import axios from "axios";

export default axios.create({
  // baseURL: "/",
  baseURL: "http://localhost:8081/api",
  headers: {
    "Content-type": "application/json",
  },
});
