import "./App.css";

import { useState } from "react";

import {
  BrowserRouter,
  Route,
  Switch,
  Router,
  Provider,
  Link,
} from "react-router-dom";
import Dashboard from "./components/Dashboard/Dashboard";
import Login from "./components/Login/Login";
import Navbar from "./components/Navbar/Navbar";
import Banner from "./components/Banner/Banner";

import history from "./history";
import Register from "./components/Register/Register";

//import interseptors from "./interseptors/Interceptors";

function App() {
  // const [token, setToken] = useState();

  // if (!token) {
  //   return <Login setToken={setToken} />;
  // }

  return (
    <BrowserRouter history={history}>
      <Navbar />
      <div>
        <Switch>
          <Route exact path="/">
            <Login />
          </Route>
          <Route path="/dashboard" exact component={() => <Dashboard />} />
          <Route path="/register" exact component={() => <Register />} />
          <Route path="/banner" exact component={() => <Banner />} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
