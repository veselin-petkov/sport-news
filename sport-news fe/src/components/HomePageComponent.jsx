import React, { Component } from "react";
import ListNewsComponent from "./ListNewsComponent";
import MainNewsComponent from "./MainNewsComponent";
import SideNewsComponent from "./SideNewsComponent";

class HomePage extends Component {
  render() {
    return (
      <div>
        <div>
          {/* <h2>HELLO</h2>
        <p>
          Cras facilisis urna ornare ex volutpat, et convallis erat elementum.
          Ut aliquam, ipsum vitae gravida suscipit, metus dui bibendum est, eget
          rhoncus nibh metus nec massa. Maecenas hendrerit laoreet augue nec
          molestie. Cum sociis natoque penatibus et magnis dis parturient
          montes, nascetur ridiculus mus.
        </p>

        <p>Duis a turpis sed lacus dapibus elementum sed eu lectus.</p> */}

          <MainNewsComponent />
          <SideNewsComponent />
        </div>

        <ListNewsComponent/>
      </div>
    );
  }
}

export default HomePage;
