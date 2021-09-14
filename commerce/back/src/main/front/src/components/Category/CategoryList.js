import React, { Fragment } from "react";
import { connect } from "react-redux";
import { getCatalogCategory } from "../../redux/actions/catalogs";

import CategoryItem from "./CategoryItem";

import { Row, Col, Container } from "react-bootstrap";
import Load from "../Loader/Loader";

class CategoryList extends React.Component {
  componentDidMount() {
    // setTimeout(() => {}, 5000);
    let id = this.props.match.params.id;
    this.props.getCatalogCategory(id);
  }

  render() {
    const { curretnCatalog, loading } = this.props;

    return (
      <Fragment>
        <Container>
          {loading ? (
            <Load />
          ) : (
            <Col>
              <h1>CATALOG: {curretnCatalog.name}</h1>
              <Row xs={1} md={3} className="g-4">
                {curretnCatalog !== null &&
                curretnCatalog.length !== 0 &&
                curretnCatalog.categories.length !== 0 ? (
                  curretnCatalog.categories.map((item) => {
                    return (
                      <CategoryItem
                        key={item.id}
                        Id={item.id}
                        Name={item.name}
                      />
                    );
                  })
                ) : (
                  <h2>Categories not found</h2>
                )}
              </Row>
            </Col>
          )}
        </Container>
      </Fragment>
    );
  }
}

const mapStateToProps = ({ catalogReducer }) => {
  //   console.log("mapStateToProps", catalogReducer);
  const { curretnCatalog, loading } = catalogReducer;
  return { curretnCatalog, loading };
};

const mapDispatchToProps = {
  //   getCatalogList,
  getCatalogCategory,
};

export default connect(mapStateToProps, mapDispatchToProps)(CategoryList);
