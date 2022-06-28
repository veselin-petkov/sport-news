import axios from "axios";

const REGISTER_REST_API_URL = 'http://localhost:8000/users/add';

class RegisterService{

    createUser(){
          
        let usernameVal =document.getElementById("username").value;
        let passwordVal = document.getElementById("password").value;
        let emailVal = document.getElementById("email").value;

        let userToSave = {username:usernameVal,password:passwordVal,email:emailVal};

        return axios.post(REGISTER_REST_API_URL,userToSave).then((response) => {
            window.location.href = "http://localhost:3000/login";
          });
    }

}

export default new RegisterService();