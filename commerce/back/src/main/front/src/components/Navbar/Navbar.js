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
          <nav className="navbar navbar-expand-lg navbar-light bg">
            <div className="container-fluid">
              <a className="navbar-brand" href="#">
                Navbar
              </a>
              <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span className="navbar-toggler-icon"></span>
              </button>
              <div
                className="collapse navbar-collapse"
                id="navbarSupportedContent"
              >
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                  <li className="nav-item">
                    <a className="nav-link active" aria-current="page" href="/">
                      Home
                    </a>
                  </li>

                  <li className="nav-item">
                    <Link to={"/catalogs"} className="nav-link">
                      Catalogs
                    </Link>
                  </li>

                  <li className="nav-item">
                    <a
                      className="nav-link active"
                      aria-current="page"
                      href="/login"
                    >
                      Login
                    </a>
                  </li>
                  <li className="nav-item">
                    <a
                      className="nav-link active"
                      aria-current="page"
                      href="/register"
                    >
                      Register
                    </a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link active" aria-current="page" href="#">
                      Logout
                    </a>
                  </li>
                  <li className="nav-item">
                    <a
                      className="nav-link active"
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
