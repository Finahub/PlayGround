import axios from "axios";

const API_URL = "http://localhost:8080";

class ApiService {
  listInfo() {
    return axios.get(API_URL);
  }

  postInfo(bankName, creditCount, debitCount) {
    return axios.post(API_URL + "/bankInfo", {
      bankName,
      creditCount,
      debitCount,
    });
  }
}

export default new ApiService();
