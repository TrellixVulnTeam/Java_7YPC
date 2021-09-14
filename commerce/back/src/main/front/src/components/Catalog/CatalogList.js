import React, { Fragment } from "react";
import { connect } from "react-redux";

import { getCatalogList } from "../../redux/actions/catalogs";
import CatalogItem from "./CatalogItem";
import { Row, Col, Container } from "react-bootstrap";
import Load from "../Loader/Loader";

class CatalogList extends React.Component {
  componentDidMount() {
    // setTimeout(() => {}, 5000);

    this.props.getCatalogList();
  }

  render() {
    const { catalogs, loading } = this.props;
    return (
      <Fragment>
        <Container>
          {loading ? (
            <Load />
          ) : (
            <Col>
              <h1>CATALOGS</h1>

              <Row xs={1} md={3} className="g-4">
                {catalogs !== null && catalogs.length !== 0 ? (
                  catalogs.map((item) => {
                    return (
                      <CatalogItem
                        key={item.id}
                        Id={item.id}
                        Name={item.name}
                      />
                    );
                  })
                ) : (
                  <h2>Gatalogs not found</h2>
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
  // console.log("mapStateToProps", catalogReducer);

  const { catalogs, loading } = catalogReducer;
  return { catalogs, loading };
};

const mapDispatchToProps = {
  getCatalogList,
};

export default connect(mapStateToProps, mapDispatchToProps)(CatalogList);
