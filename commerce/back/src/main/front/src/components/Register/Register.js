import React, { Component } from "react";
import axios from "axios";

import { Redirect, withRouter } from "react-router-dom";
import { FormErrors } from "../FormErrors/FormErrors";
import history from "../../history";

import Notification from "../Notification/Notofication";

const regularExpression = RegExp(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/);

class Register extends Component {
  state = {
    username: "",
    password: "",

    error: {
      email: "",
      password: "",
    },
  };

  constructor() {
    super();
    this.submitForm = this.submitForm.bind(this);
  }

  submitForm = (event) => {
    event.preventDefault();

    const url = "http://localhost:8081/api/public/register";

    const user_object = {
      username: this.state.username,
      password: this.state.password,
    };

    if (this.state.error.email == "" && this.state.error.password == "") {
      console.log("yes");
      //axios.post(url, user_object).then((res) => {
      //localStorage.setItem("token", res.data.token);
      //console.log(res.data);
      //return this.handleDashboard();
      //});
    } else {
      console.log("no");
      Notification("danger", "invalid reg");
    }
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

  formObject = (event) => {
    event.preventDefault();

    const { name, value } = event.target;
    let error = { ...this.state.error };

    switch (name) {
      case "email":
        error.email = regularExpression.test(value) ? "" : "Email is not valid";
        break;
      case "password":
        error.password =
          value.length < 5 ? "Password should 5 characaters long" : "";
        break;
      default:
        break;
    }

    this.setState({
      error,
      [name]: value,
    });
  };

  render() {
    const { username, password } = this.state;
    const { error } = this.state;

    return (
      <div>
        <div>
          {/* <form className="card-body" onSubmit={this.submitForm}>
            <div className="form-group mb-3">
              <label className="mb-2">
                <strong>Email</strong>
              </label>
              <input
                required
                type="email"
                name="email"
                className={
                  error.email.length > 0
                    ? "is-invalid form-control"
                    : "form-control"
                }
                onChange={this.formObject}
              />

              {error.email.length > 0 && (
                <span className="invalid-feedback">{error.email}</span>
              )}
            </div>

            <div className="form-group mb-3">
              <label className="mb-2">
                <strong>Password</strong>
              </label>
              <input
                required
                type="password"
                name="password"
                className={
                  error.password.length > 0
                    ? "is-invalid form-control"
                    : "form-control"
                }
                onChange={this.formObject}
              />

              {error.password.length > 0 && (
                <span className="invalid-feedback">{error.password}</span>
              )}
            </div>

            <div className="d-grid mt-3">
              <button type="submit" className="btn btn-block btn-primary">
                Submit
              </button>
            </div>
          </form>
        </div> */}

          <div class="container">
            <div class="row">
              <div class="offset-md-3 col-md-6">
                <h2 class="text-center">REGISTER</h2>
                {/* <div class="mb-2">
                  <a href="/register">Створити новий акаунт</a>
                </div> */}

                <form onSubmit={this.submitForm}>
                  <div class="form-group">
                    <label class="control-label" for="Email">
                      &#x415;&#x43B;&#x435;&#x43A;&#x442;&#x440;&#x43E;&#x43D;&#x43D;&#x430;
                      &#x430;&#x434;&#x440;&#x435;&#x441;&#x430;
                    </label>
                    <input
                      class="form-control"
                      // data-val="true"
                      // data-val-required="&#x412;&#x43A;&#x430;&#x436;&#x456;&#x442;&#x44C; &#x43F;&#x43E;&#x448;&#x442;&#x443;"
                      id="Email"
                      required
                      type="email"
                      name="email"
                      className={
                        error.email.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      onChange={this.formObject}
                    />
                    {error.email.length > 0 && (
                      <span className="invalid-feedback">{error.email}</span>
                    )}
                    <span
                      class="text-danger field-validation-valid"
                      data-valmsg-for="Email"
                      data-valmsg-replace="true"
                    ></span>
                  </div>
                  <div class="form-group">
                    <label class="control-label" for="Password">
                      &#x41F;&#x430;&#x440;&#x43E;&#x43B;&#x44C;
                    </label>
                    <input
                      class="form-control"
                      type="password"
                      data-val="true"
                      // data-val-required="&#x412;&#x43A;&#x430;&#x436;&#x456;&#x442;&#x44C; &#x43F;&#x430;&#x440;&#x43E;&#x43B;&#x44C;"
                      id="Password"
                      required
                      type="password"
                      name="password"
                      className={
                        error.password.length > 0
                          ? "is-invalid form-control"
                          : "form-control"
                      }
                      onChange={this.formObject}
                    />
                    {error.password.length > 0 && (
                      <span className="invalid-feedback">{error.password}</span>
                    )}
                    <span
                      class="text-danger field-validation-valid"
                      data-valmsg-for="Password"
                      data-valmsg-replace="true"
                    ></span>
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
                  {/* <input
                    name="__RequestVerificationToken"
                    type="hidden"
                    value="CfDJ8KrOnY28iqxBpAybiUNiWf-Scbvr4kHVtdJfuyI4xooDxP2gOj3Zo74xmdVLJYSP5hYJB5JQpZD_zjlVkoQM9juRgDGImQkk4Gor1Ht69VG6_S5fr5sKkq0-wieXXjnpvBGpHprhPN1lC8ZL6u_Dkys"
                  /> */}
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Register);
