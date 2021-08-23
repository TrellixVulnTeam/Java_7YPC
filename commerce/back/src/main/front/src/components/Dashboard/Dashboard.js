import React, { Component } from "react";
import { Redirect, withRouter } from "react-router-dom";

class Dashboard extends Component {
  handleLogout() {
    localStorage.clear();
    window.location.href = "/";
  }

  render() {
    console.log(this);
    return (
      <div>
        <h1>DASHBOARD</h1>
        <button
          onClick={this.handleLogout}
          className="d-b td-n pY-5 bgcH-grey-100 c-grey-700"
        >
          <i className="ti-power-off mR-10"></i>
          <span style={{ color: "white" }}>Logout</span>
        </button>
      </div>
    );
  }
}
export default withRouter(Dashboard);
