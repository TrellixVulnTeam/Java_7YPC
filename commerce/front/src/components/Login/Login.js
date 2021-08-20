import React, { Component } from "react";
import "../Login/Login.css";
import axios from "axios";
import { Redirect, withRouter } from "react-router-dom";

import history from "../../history";

import Notification from "../Notification/Notofication";

class Login extends Component {
  state = {
    username: "",
    password: "",
  };
  constructor() {
    super();
    this.submitForm = this.submitForm.bind(this);
  }

  submitForm = (event) => {
    event.preventDefault();

    const url = "http://localhost:8081/api/public/authenticate";

    const user_object = {
      username: this.state.username,
      password: this.state.password,
    };

    axios
      .post(url, user_object)
      .then((res) => {
        localStorage.setItem("token", res.data.token);
        return this.handleDashboard();
      })
      .catch((error) => {
        Notification("danger");
      });
  };

  handleDashboard() {
    const token = localStorage.getItem("token");

    const config = {
      headers: { Authorization: `Bearer ${token}` },
    };

    const bodyParameters = {
      key: "value",
    };

    axios
      .post("http://localhost:8081/dashboard", bodyParameters, config)
      .then((res) => {
        if (res.data === "success") {
          this.props.history.push("/dashboard");
        } else alert("Authentication failure");
      });
  }

  onChangeInput = (e) => {
    var target = e.target;
    this.setState({
      [target.name]: target.value,
    });
  };

  render() {
    const { username, password } = this.state;
    return (
      <div>
        <div className="wrapper">
          <div>LOGIN</div>
          <form onSubmit={this.submitForm}>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">
                Username
              </label>
              <input
                //type="email"
                class="form-control"
                //aria-describedby="emailHelp"
                value={username}
                id="username"
                name="username"
                onChange={this.onChangeInput}
              />
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">
                Password
              </label>
              <input
                type="password"
                class="form-control"
                id="password"
                name="password"
                value={password}
                onChange={this.onChangeInput}
              />
            </div>

            <button type="submit" class="btn btn-secondary">
              Login
            </button>
          </form>
        </div>
        <button
          class="btn btn-secondary"
          onClick={() => {
            console.log("hi");
            Notification("danger");
          }}
        >
          Hi
        </button>
      </div>
    );
  }
}

export default withRouter(Login);
