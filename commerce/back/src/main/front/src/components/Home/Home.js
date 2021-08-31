import React, { Component } from "react";
import "./home.css";

class Home extends Component {
  render() {
    return (
      <div className="container catalogs">
        <ul>
          <li>
            <a href="#home">Home</a>
          </li>
          <li>
            <a href="#news">News</a>
          </li>
          <li>
            <a href="#contact">Contact</a>
          </li>
          <li>
            <a href="#about">About</a>
          </li>
        </ul>
      </div>
    );
  }
}

export default Home;
