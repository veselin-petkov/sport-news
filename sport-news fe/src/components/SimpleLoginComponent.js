import React, { Component } from 'react'
import LoginService from '../services/LoginService';

 class SimpleLoginComponent extends Component {


  render() {
    return (
        <div>
        <label >Username</label>
        <input type="text" className="form-control" id="username" aria-describedby="emailHelp" placeholder="Title"/>


        <label >Password</label>
        <input type="password" className="form-control" id="password" aria-describedby="emailHelp" placeholder="Password"/>

      <button type="submit" className="btn btn-primary" onClick={LoginService.login}>Login</button>
      </div>
    )
  }
}

export default SimpleLoginComponent;
