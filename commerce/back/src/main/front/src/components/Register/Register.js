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
  constructor() {
    super();
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeInput = this.onChangeInput.bind(this);

    this.state = {
      email: "",
      username: "",
      password: "",
      successful: false,
      loading: false,
    };
  }

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      successful: false,
      loading: true,
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      this.props
        .dispatch(
          register(this.state.username, this.state.email, this.state.password)
        )
        .then(() => {
          this.setState({
            successful: true,
            loading: false,
          });
          console.log(this.state);
        })
        .catch(() => {
          this.setState({
            successful: false,
            loading: false,
          });
        });
    }
  }

  onChangeInput = (e) => {
    var target = e.target;
    this.setState({
      [target.name]: target.value,
    });
  };

  render() {
    const { message } = this.props;

    return (
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
                                id="inputUsername"
                                type="text"
                                placeholder="Username"
                                autofocus=""
                                name="username"
                                value={this.state.username}
                                onChange={this.onChangeInput}
                                validations={[required, vusername]}
                                className="form-control rounded-pill border-0 shadow-sm px-4"
                              />
                            </div>

                            <div className="mb-3">
                              <Input
                                id="inputEmail"
                                type="email"
                                name="email"
                                placeholder="Email"
                                value={this.state.email}
                                onChange={this.onChangeInput}
                                validations={[required, email]}
                                className="form-control rounded-pill border-0 shadow-sm px-4 text-primary"
                              />
                            </div>

                            <div className="mb-3">
                              <Input
                                id="inputPassword"
                                type="password"
                                name="password"
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
                                  <span>Register</span>
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
