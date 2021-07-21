import React, { Fragment } from "react";
import "./App.css";
import { Component } from "react";
import axios from "axios";
import Header from "./components/header/header";
import AddNew from "./components/add";

import history from "./history";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

class App extends Component {
  state = {
    data: [],
  };

  componentDidMount() {
    axios.get("http://localhost:8081/api/heroes").then((result) => {
      console.log(result.data);
      this.setState({ data: result.data });
    });
    //axios.post("http://localhost:8081/api/heroes", {name: "Duck"}).then(result=> console.log("Added..."));
  }

  render() {
    const { data } = this.state;
    return (
      <Fragment>
        <Router history={history}>
          <Header />
          <Switch>
            <Route path="/add" exact component={() => <AddNew />} />
            <Route path="/" exact>
              <ul>
                {data.map((item) => (
                  <li key={item.id}>
                    <h3>{item.name}</h3>
                  </li>
                ))}
              </ul>
            </Route>
          </Switch>
        </Router>
      </Fragment>

      // <>
      // <div className="container">
      // <Header/>

      //   <ul>
      //     {data.map(item => (
      //       <li key={item.id}>
      //         <h3>{item.name}</h3>
      //       </li>
      //     ))}
      //   </ul>
      //   <AddNew/>
      //   </div>
      // </>
    );

    // return (
    //     <div className="App">
    //       <header className="App-header">
    //         <img src={logo} className="App-logo" alt="logo"/>
    //         <p>
    //           Edit <code>src/App.js</code> and save to reload.
    //         </p>
    //         <a
    //             className="App-link"
    //             href="https://reactjs.org"
    //             target="_blank"
    //             rel="noopener noreferrer"
    //         >
    //           Learn React
    //         </a>
    //       </header>
    //     </div>
    // );
  }
}

export default App;
