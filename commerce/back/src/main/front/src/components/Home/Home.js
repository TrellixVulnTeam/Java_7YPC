import React, { Component } from "react";

import UserService from "../../redux/services/user-service";
import CatalogList from "../Catalog/CatalogList";

import ItemCard from "../Product/product-cart";

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: "",
    };
  }

  componentDidMount() {
    // UserService.getPublicContent().then(
    //   (response) => {
    //     this.setState({
    //       content: response.data,
    //     });
    //   },
    //   (error) => {
    //     this.setState({
    //       content:
    //         (error.response && error.response.data) ||
    //         error.message ||
    //         error.toString(),
    //     });
    //   }
    // );
    // let jwt = localStorage.getItem("accessToken");
    // let jwtData = jwt.split(".")[1];
    // let decodedJwtJsonData = window.atob(jwtData);
    // let decodedJwtData = JSON.parse(decodedJwtJsonData);
    // let isAdmin = decodedJwtData.admin;
    // console.log("jwtData: " + jwtData);
    // console.log("decodedJwtJsonData: " + decodedJwtJsonData);
    // console.log("decodedJwtData: " + decodedJwtData);
    // console.log("Is admin: " + isAdmin);
  }

  render() {
    const item = {
      id: 1,
    };

    return (
      <div className="container">
        <header className="jumbotron">
          <h3>{this.state.content}</h3>
        </header>

        <CatalogList />
        {/* <ItemCard item={item} /> */}
      </div>
    );
  }
}
