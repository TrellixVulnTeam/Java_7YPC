import http from "../http-common";

class CatalogDataService {
  getAll() {
    return http.get("/catalogs");
  }

  get(id) {
    return http.get(`/catalogs/${id}`);
  }

  create(data) {
    return http.post("/catalogs", data);
  }

  update(id, data) {
    return http.put(`/catalogs/${id}`, data);
  }

  delete(id) {
    return http.delete(`/catalogs/${id}`);
  }

  deleteAll() {
    return http.delete(`/catalogs`);
  }

  findByTitle(title) {
    return http.get(`/catalogs?title=${title}`);
  }
}

export default new CatalogDataService();
