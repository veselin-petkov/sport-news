import axios from "axios";

const LOGIN_REST_API_URL = "http://localhost:8000/authenticate";

class LoginService {
  login() {
    let usernameVal = document.getElementById("username").value;
    let passwordVal = document.getElementById("password").value;

    let userLogin = { username: usernameVal, password: passwordVal };

    function getJWT(response) {
      localStorage.setItem("jwt_token", "Bearer " + response.data.jwt);
    }
    return axios.post(LOGIN_REST_API_URL, userLogin).then((response) => {
      getJWT(response);
      window.location.href = "http://localhost:3000";
    });
  }
}
export default new LoginService();
