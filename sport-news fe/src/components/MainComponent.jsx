import React, { Component } from "react";
import { NavLink, Routes } from "react-router-dom";
import "../css/maintry.css";
import jwt_decode from "jwt-decode";
import CategoriesService from "../services/CategoriesService";

export default class Main extends Component {
  constructor(props) {
    super(props);
    var token = localStorage.getItem("jwt_token");
    var decoded = token === null ? "" : jwt_decode(token);
    this.state = {
      role_id: decoded === "" ? null : decoded.role,
      categories: []
    };

    this.logOut = this.logOut.bind(this);
  }

  componentDidMount() {
    CategoriesService.getCategories().then((response) => {
      this.setState({
        categories: response.data,
      });
    });
  }

  logOut() {
    localStorage.clear();
    this.setState({ role_id: null });
    // window.location.reload();
    // window.location.href = "http://localhost:3000/login";
  }

  render() {
    return (
      <div>
        <h1>
          <a href="http://localhost:3000">SportNews.bg</a>
        </h1>
        <ul className="header">
          <li>
            <NavLink to="/">Home</NavLink>
          </li>
          <li>
            <NavLink to="/category/football">Football</NavLink>
          </li>
          <li>
            <NavLink to="/category/basketball">Basketball</NavLink>
          </li>
          <li>
            <NavLink to="/category/volleyball/">Voleyball</NavLink>
          </li>
          <li>
            <NavLink to="/category/tennis">Tennis</NavLink>
          </li>
          <li>
            <NavLink to="/category/motorsport">Motorsport</NavLink>
          </li>
          <li>
            <NavLink to="/category/boulevard">Boulevard</NavLink>
          </li>
          {this.state.role_id !== null && (
            <li className="navbar-right">
              <NavLink to="/" className="notactive">
                <div onClick={this.logOut}>Logout</div>
              </NavLink>
            </li>
          )}
          {this.state.role_id === null && (
            <li className="navbar-right">
              <NavLink to="/login">Login</NavLink>
            </li>
          )}
          {this.state.role_id === null && (
            <li className="navbar-right">
              <NavLink to="/register/old">Register</NavLink>
            </li>
          )}
          {this.state.role_id === 2 && (
            <li className="navbar-right">
              <NavLink to="/create-news">Create News</NavLink>
            </li>
          )}
        </ul>
        {/* <div className="content">
          <Routes>
            <Route path="/" element={<HomePage />} ></Route>
            <Route path="stuff" element={<Stuff />}></Route>
            <Route path="contact" element={<Contact />}></Route>
          </Routes>
        </div> */}
      </div>
    );
  }
}
