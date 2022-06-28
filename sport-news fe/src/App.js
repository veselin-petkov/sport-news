import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import NewsComponent from "./components/NewsComponent";
import UserComponent from "./components/UserComponent";
import RegisterFormComponent from "./components/RegisterFormComponent";
import { AccountBox } from "./components/accountBox";
import styled from "styled-components";
import Login from "./components/SimpleLoginComponent";
import HomePage from "./components/HomePageComponent";
import Stuff from "./components/StuffComponent";
import Contact from "./components/ContactComponent";
import CreateNewsComponent from "./components/CreateNewsComponent";
import ListIndividualNews from "./components/ListIndividualNews";
import LiveScoreComponent from "./components/LiveScoreComponent";
import ListTagsComponent from "./components/ListTagsComponent";
import UploadComponent from "./components/UploadComponent";
import NewsByCategoryComponent from "./components/NewsByCategoryComponent";

const AppContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
`;

function logOut(){
  localStorage.clear();
  window.location.href = "http://localhost:3000/login"
}
function App() {


  return (
    <div>
      <AppContainer>
        <Routes>
          <Route path="/" element={<HomePage />}></Route>
          <Route path="users" element={<UserComponent />}></Route>
          <Route path="news" element={<NewsComponent />}></Route>
          <Route path="news/:id" element={<ListIndividualNews />}></Route>
          <Route path="register" element={<AccountBox />}></Route>
          <Route path="login" element={<Login />}></Route>
          <Route path="register/old"element={<RegisterFormComponent />}></Route>
          <Route path="stuff" element={<Stuff />} ></Route>
          <Route path="contact" element={<Contact />} ></Route>
          <Route path="create-news" element={<UploadComponent />} ></Route>
          <Route path="tag/:id" element={<ListTagsComponent />} ></Route>
          <Route path="/category/:category" forceRefresh element={<NewsByCategoryComponent />} >{window.location.reload}</Route>

        </Routes>
       

      </AppContainer>
      <LiveScoreComponent/>

    </div>
  );
}

export default App;
