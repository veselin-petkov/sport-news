import React, { Component } from 'react'
import RegisterService from '../services/RegisterService';



 class RegisterFormComponent extends Component {


  render() {
    return (
      <div>
        <label >Username</label>
        <input type="text" className="form-control" id="username" aria-describedby="emailHelp" placeholder="Title"/>
        <label >Password</label>
        <input type="password" className="form-control" id="password" aria-describedby="emailHelp" placeholder="Password"/>
        <label >Email</label>
        <input type="email" className="form-control" id="email" aria-describedby="emailHelp" placeholder="Email"/>
  
      <button type="submit" className="btn btn-primary" to="/login" onClick={RegisterService.createUser}>Register</button>
      </div>
    )
  }
}

export default RegisterFormComponent;
