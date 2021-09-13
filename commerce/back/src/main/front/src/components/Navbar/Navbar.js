import React, { Fragment } from "react";
import "bootstrap/dist/css/bootstrap.css";
import { Container, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import { connect } from "react-redux";

import "bootstrap/dist/js/bootstrap.min.js";

import "../Navbar/Navbar.css";

import { logout } from "../../redux/actions/auth";
import { clearMessage } from "../../redux/actions/message";

import history from "../../history";

class Navbar extends React.Component {
  constructor(props) {
    super(props);
    this.logout = this.logout.bind(this);

    this.state = {
      showAdminBoard: false,
      currentUser: undefined,
    };

    history.listen((location) => {
      props.dispatch(clearMessage());
    });
  }

  componentDidMount() {
    const user = this.props.user;

    if (user) {
      this.setState({
        currentUser: user,
        // showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  logout() {
    this.props.dispatch(logout());
  }

  render() {
    const { currentUser, showAdminBoard } = this.state;
    const { isLoggedIn } = this.props;

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
                      <Link
                        className="nav-link active"
                        aria-current="page"
                        to="/"
                      >
                        Home
                      </Link>
                    </li>

                    {showAdminBoard && (
                      <li className="nav-item">
                        <Link to={"/admin"} className="nav-link">
                          Admin Board
                        </Link>
                      </li>
                    )}

                    {currentUser && (
                      <li className="nav-item">
                        <Link to={"/user"} className="nav-link">
                          User
                        </Link>
                      </li>
                    )}

                    <li className="nav-item">
                      <Link to={"/catalogs"} className="nav-link">
                        Catalogs
                      </Link>
                    </li>

                    <li className="nav-item">
                      <Link
                        className="nav-link active"
                        aria-current="page"
                        to="/upload"
                      >
                        Upload
                      </Link>
                    </li>

                    {isLoggedIn ? (
                      <div className="navbar-nav ml-auto">
                        <li className="nav-item">
                          <Link to={"/profile"} className="nav-link">
                            {/* {currentUser.username} */}Bob
                          </Link>
                        </li>
                        <li className="nav-item">
                          <Link
                            to={"/login"}
                            className="nav-link"
                            onClick={this.logout}
                          >
                            Logout
                          </Link>
                        </li>
                      </div>
                    ) : (
                      <div className="navbar-nav ml-auto">
                        <li className="nav-item">
                          <Link to={"/login"} className="nav-link">
                            Login
                          </Link>
                        </li>

                        <li className="nav-item">
                          <Link to={"/register"} className="nav-link">
                            Register
                          </Link>
                        </li>
                      </div>
                    )}
                  </ul>
                </div>
              </div>
            </nav>
          </Row>
        </Container>
      </Fragment>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  const { isLoggedIn } = state.auth;
  return {
    user,
    isLoggedIn,
  };
}

export default connect(mapStateToProps)(Navbar);
