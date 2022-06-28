import axios from "axios";

const USERS_REST_API_URL = 'http://localhost:8000/users';
let user = localStorage.getItem('jwt_token');
   
class UserService{


    getUsers(){
        return axios.get(USERS_REST_API_URL,{ headers: {"Authorization" : user} })
    }
}

export default new UserService();