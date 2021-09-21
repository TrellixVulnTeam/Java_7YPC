import http from "../http-common";

class UploadFilesService {
  upload(file, onUploadProgress) {
    let formData = new FormData();

    formData.append("file", file);

    return http.post("/public/upload/catalog/1", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  uploadFile(file, path) {
    let formData = new FormData();

    formData.append("file", file);
    return http.post("/public/upload/" + path, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
  }

  getFiles() {
    return http.get("/public/files");
  }
}

export default new UploadFilesService();
