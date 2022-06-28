import axios from "axios";

const CATEGORIES_REST_API_URL = "http://localhost:8000/category";
let user = localStorage.getItem('jwt_token');

class CategoriesService {
  getCategories() {
  
    return axios.get(CATEGORIES_REST_API_URL,{ headers: {"Authorization" : user} })
  }
}
export default new CategoriesService();
