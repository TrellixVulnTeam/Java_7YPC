import React, { Component } from "react";
import "../Login/Login.css";
import axios from "axios";
import { Redirect, withRouter } from "react-router-dom";

import history from "../../history";

import Notification from "../Notification/Notofication";
import { validation } from "./validation";

export class Login extends Component {
  state = {
    username: "",
    password: "",
    errors: {},
  };
  constructor() {
    super();
    this.submitForm = this.submitForm.bind(this);
  }

  async submitForm(event) {
    event.preventDefault();

    console.log(this.state);

    let error = validation(this.state);

    const isValid = Object.keys(error).length == 0;

    if (isValid) {
      const url = "http://localhost:8081/api/public/authenticate";

      const user_object = {
        username: this.state.username,
        password: this.state.password,
      };

      await axios
        .post(url, user_object)
        .then((res) => {
          localStorage.setItem("token", res.data.token);
          return this.handleDashboard();
        })
        .catch((error) => {
          Notification("danger", "Login is failed");
        });
    } else {
      this.setState({ errors: error });
    }
  }

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
    const { username, password, errors } = this.state;
    return (
      <div class="container">
        <div class="row">
          <div class="offset-md-3 col-md-6">
            <h2 class="text-center">LOGIN</h2>
            <form onSubmit={this.submitForm}>
              <div class="form-group">
                <label class="control-label">Username</label>
                <input
                  class="form-control"
                  id="username"
                  required
                  type="text"
                  name="username"
                  value={username}
                  onChange={this.onChangeInput}
                />
                {!!errors.username && (
                  <div className="invalid-feedback">{errors.username}</div>
                )}
              </div>
              <div class="form-group">
                <label class="control-label">Password</label>
                <input
                  class="form-control"
                  type="password"
                  data-val="true"
                  id="password"
                  required
                  type="password"
                  name="password"
                  value={password}
                  onChange={this.onChangeInput}
                />
                {!!errors.password && (
                  <div className="invalid-feedback">{errors.password}</div>
                )}
              </div>
              <div class="d-flex align-items-end flex-column">
                <div class="form-group mt-2">
                  <input
                    type="submit"
                    value="Вхід"
                    class="btn btn-warning px-5"
                  />
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Login);
