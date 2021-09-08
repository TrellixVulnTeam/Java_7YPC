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
import UploadFiles from "./components/upload-files";
import CatalogList from "./components/Catalog/CatalogList";
import EditProduct from "./components/Product/edit-product-page";

import history from "./history";
import Register from "./components/Register/Register";

import "bootstrap/dist/css/bootstrap.min.css";
import Home from "./components/Home/Home";

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
          <Route path="/" exact component={() => <Home />} />
          <Route exact path="/login" component={() => <Login />} />
          <Route path="/dashboard" exact component={() => <Dashboard />} />
          <Route path="/register" exact component={() => <Register />} />
          <Route path="/banner" exact component={() => <Banner />} />
          <Route path="/upload" exact component={() => <UploadFiles />} />
          <Route path="/catalogs" exact component={() => <CatalogList />} />
          <Route path="/edit" exact component={() => <EditProduct />} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
