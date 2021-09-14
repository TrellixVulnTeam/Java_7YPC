import React, { Fragment } from "react";
import { connect } from "react-redux";
import { getCategory } from "../../redux/actions/category";

import ProductItem from "./ProductItem";

import { Row, Col, Container } from "react-bootstrap";
import Load from "../Loader/Loader";

class ProductList extends React.Component {
  componentDidMount() {
    // setTimeout(() => {}, 5000);
    let id = this.props.match.params.id;
    this.props.getCategory(id);
  }

  render() {
    const { categories, loading } = this.props;
    return (
      <Fragment>
        <Container>
          {loading ? (
            <Load />
          ) : (
            <Col>
              <h1>CATEGORY: {categories.name}</h1>

              <Row xs={1} md={3} className="g-4">
                {categories != null &&
                categories.length !== 0 &&
                categories.products.length !== 0 ? (
                  categories.products.map((item) => {
                    return (
                      <ProductItem
                        key={item.id}
                        Id={item.id}
                        Name={item.title}
                      />
                    );
                  })
                ) : (
                  <h2>Products not found</h2>
                )}
              </Row>
            </Col>
          )}
        </Container>
      </Fragment>
    );
  }
}

const mapStateToProps = ({ categoryReducer }) => {
  //   console.log("mapStateToProps", catalogReducer);
  const { categories, loading } = categoryReducer;
  return { categories, loading };
};

const mapDispatchToProps = {
  //   getCatalogList,
  getCategory,
};

export default connect(mapStateToProps, mapDispatchToProps)(ProductList);
