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
import Profile from "./components/Profile/Profile";
import BoardUser from "./components/Home/BoardUser";

import history from "./history";
import Register from "./components/Register/Register";

import "bootstrap/dist/css/bootstrap.min.css";
import Home from "./components/Home/Home";
import CategoryList from "./components/Category/CategoryList";
import ProductList from "./components/Product/ProductList";

function App() {
  return (
    <BrowserRouter history={history}>
      <Navbar />
      <div>
        <Switch>
          <Route path={["/", "/home"]} exact component={() => <Home />} />
          <Route exact path="/login" component={() => <Login />} />
          <Route path="/dashboard" exact component={() => <Dashboard />} />
          <Route path="/register" exact component={() => <Register />} />
          <Route path="/banner" exact component={() => <Banner />} />
          <Route path="/upload" exact component={() => <UploadFiles />} />
          <Route path="/catalogs" exact component={() => <CatalogList />} />
          <Route
            path="/catalog/categories/:id"
            exact
            component={CategoryList}
          />
          <Route path="/category/products/:id" exact component={ProductList} />
          <Route path="/edit" exact component={() => <EditProduct />} />
          <Route path="/profile" exact component={() => <Profile />} />
          <Route path="/user" exact component={() => <BoardUser />} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
