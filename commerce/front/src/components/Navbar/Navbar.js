import React, { Fragment } from "react";
import "bootstrap/dist/css/bootstrap.css";
import { Container, Row } from "react-bootstrap";
import { Link } from "react-router-dom";

import "bootstrap/dist/js/bootstrap.min.js";

import "./Navbar.css";

const Navbar = () => {
  return (
    <Fragment>
      <Container>
        <Row>
          <nav class="navbar navbar-expand-lg navbar-light bg">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">
                Navbar
              </a>
              <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Home
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">
                      Login
                    </a>
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      aria-current="page"
                      href="/register"
                    >
                      Register
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Logout
                    </a>
                  </li>
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      aria-current="page"
                      href="/dashboard"
                    >
                      Dashboard
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
        </Row>
      </Container>
    </Fragment>
  );
};

export default Navbar;
