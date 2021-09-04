import React, { Component } from "react";
import axios from "axios";

import { Redirect, withRouter } from "react-router-dom";
import { FormErrors } from "../FormErrors/FormErrors";
import history from "../../history";

import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { connect } from "react-redux";

import { isEmail } from "validator";
import { register } from "../../redux/actions/auth";

import Notification from "../Notification/Notofication";

const regularExpression = RegExp(/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/);

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const email = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The username must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

class Register extends Component {
  state = {
    username: "",
    password: "",

    error: {
      email: "",
      password: "",
    },
    // email: "",
    successful: false,
  };

  constructor() {
    super();
    this.submitForm = this.submitForm.bind(this);
    this.handleRegister = this.handleRegister.bind(this);
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

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      successful: false,
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      this.props
        .dispatch(register(this.state.username, this.state.password))
        .then(() => {
          this.setState({
            successful: true,
          });
        })
        .catch(() => {
          this.setState({
            successful: false,
          });
        });
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
    const { message } = this.props;

    return (
      // <div>
      //   <div>
      /* <form className="card-body" onSubmit={this.submitForm}>
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
        </div> */

      /* <div class="container">
            <div class="row">
              <div class="offset-md-3 col-md-6">
                <h2 class="text-center">REGISTER</h2>
                {/* <div class="mb-2">
                  <a href="/register">Створити новий акаунт</a>
                </div> */

      // <form onSubmit={this.submitForm}>
      //   <div class="form-group">
      //     <label class="control-label" for="Email">
      //       &#x415;&#x43B;&#x435;&#x43A;&#x442;&#x440;&#x43E;&#x43D;&#x43D;&#x430;
      //       &#x430;&#x434;&#x440;&#x435;&#x441;&#x430;
      //     </label>
      //     <input
      //       class="form-control"
      //       // data-val="true"
      //       // data-val-required="&#x412;&#x43A;&#x430;&#x436;&#x456;&#x442;&#x44C; &#x43F;&#x43E;&#x448;&#x442;&#x443;"
      //       id="Email"
      //       required
      //       type="email"
      //       name="email"
      //       className={
      //         error.email.length > 0
      //           ? "is-invalid form-control"
      //           : "form-control"
      //       }
      //       onChange={this.formObject}
      //     />
      //     {error.email.length > 0 && (
      //       <span className="invalid-feedback">{error.email}</span>
      //     )}
      //     <span
      //       class="text-danger field-validation-valid"
      //       data-valmsg-for="Email"
      //       data-valmsg-replace="true"
      //     ></span>
      //   </div>
      //   <div class="form-group">
      //     <label class="control-label" for="Password">
      //       &#x41F;&#x430;&#x440;&#x43E;&#x43B;&#x44C;
      //     </label>
      //     <input
      //       class="form-control"
      //       type="password"
      //       data-val="true"
      //       // data-val-required="&#x412;&#x43A;&#x430;&#x436;&#x456;&#x442;&#x44C; &#x43F;&#x430;&#x440;&#x43E;&#x43B;&#x44C;"
      //       id="Password"
      //       required
      //       type="password"
      //       name="password"
      //       className={
      //         error.password.length > 0
      //           ? "is-invalid form-control"
      //           : "form-control"
      //       }
      //       onChange={this.formObject}
      //     />
      //     {error.password.length > 0 && (
      //       <span className="invalid-feedback">{error.password}</span>
      //     )}
      //     <span
      //       class="text-danger field-validation-valid"
      //       data-valmsg-for="Password"
      //       data-valmsg-replace="true"
      //     ></span>
      //   </div>
      //   <div class="d-flex align-items-end flex-column">
      //     <div class="form-group mt-2">
      //       <input
      //         type="submit"
      //         value="Вхід"
      //         class="btn btn-warning px-5"
      //       />
      //     </div>
      //   </div>
      /* <input
                    name="__RequestVerificationToken"
                    type="hidden"
                    value="CfDJ8KrOnY28iqxBpAybiUNiWf-Scbvr4kHVtdJfuyI4xooDxP2gOj3Zo74xmdVLJYSP5hYJB5JQpZD_zjlVkoQM9juRgDGImQkk4Gor1Ht69VG6_S5fr5sKkq0-wieXXjnpvBGpHprhPN1lC8ZL6u_Dkys"
                  /> */
      //     </form>
      //   </div>
      // </div>
      //     </div>
      //   </div>
      // </div> */}

      <div className="maincontainer">
        <div className="container-fluid">
          <div className="row no-gutter">
            <div className="col-md-6 d-none d-md-flex bg-image"></div>
            <div className="col-md-6 bg-light">
              <div className="login d-flex align-items-center py-5">
                <div className="container">
                  <div className="row">
                    <div className="col-lg-10 col-xl-7 mx-auto">
                      <h3 className="display-4">Register</h3>

                      <Form
                        onSubmit={this.handleRegister}
                        ref={(c) => {
                          this.form = c;
                        }}
                      >
                        {!this.state.successful && (
                          <div>
                            <div className="mb-3">
                              <Input
                                id="inputEmail"
                                type="email"
                                placeholder="Email address"
                                autofocus=""
                                value={this.state.username}
                                onChange={this.onChangeInput}
                                validations={[required, email]}
                                className="form-control rounded-pill border-0 shadow-sm px-4"
                              />
                            </div>

                            <div className="mb-3">
                              <Input
                                id="inputPassword"
                                type="password"
                                placeholder="Password"
                                value={this.state.password}
                                onChange={this.onChangeInput}
                                validations={[required, vpassword]}
                                className="form-control rounded-pill border-0 shadow-sm px-4 text-primary"
                              />
                            </div>

                            <div className="d-grid gap-2 mt-2">
                              <button
                                type="submit"
                                disabled={this.state.loading}
                                className="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm"
                              >
                                {this.state.loading ? (
                                  <span className="spinner-border spinner-border-sm"></span>
                                ) : (
                                  <span>Sign up</span>
                                )}
                              </button>
                            </div>
                          </div>
                        )}

                        {message && (
                          <div className="form-group">
                            <div
                              className={
                                this.state.successful
                                  ? "alert alert-success"
                                  : "alert alert-danger"
                              }
                              role="alert"
                            >
                              {message}
                            </div>
                          </div>
                        )}
                        <CheckButton
                          style={{ display: "none" }}
                          ref={(c) => {
                            this.checkBtn = c;
                          }}
                        />
                      </Form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  const { message } = state.message;
  return {
    message,
  };
}

export default connect(mapStateToProps)(Register);
