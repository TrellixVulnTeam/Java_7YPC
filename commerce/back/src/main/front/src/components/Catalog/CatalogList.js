import React, { Fragment } from "react";
import { connect } from "react-redux";

import { getCatalogList } from "../../redux/actions/catalogs";
import CatalogItem from "./CatalogItem";
import { Row, Col, Container } from "react-bootstrap";

class CatalogList extends React.Component {
  componentDidMount() {
    this.props.getCatalogList();
  }

  render() {
    const { catalogs } = this.props;
    return (
      <Fragment>
        <Container>
          <Row xs={1} md={3} className="g-4">
            {catalogs.length !== 0 ? (
              catalogs.map((item) => {
                return (
                  <CatalogItem key={item.id} Id={item.id} Name={item.name} />
                );
              })
            ) : (
              <h2>Gatalogs not found</h2>
            )}
          </Row>
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
