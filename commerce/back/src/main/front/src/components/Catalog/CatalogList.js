import React, { Fragment, useState, useEffect } from "react";
import { connect, useDispatch, useSelector } from "react-redux";

import { getCatalogList } from "../../redux/actions/catalogs";
import CatalogItem from "./CatalogItem";
import { Row, Col, Container, Button } from "react-bootstrap";
import Load from "../Loader/Loader";
import MyModal from "../../components/Modal/MyModal";
import AddForm from "../FormAdd/AddForm";

const CatalogList = () => {
  const [modal, setModal] = useState(false);

  const catalog = useSelector((state) => state.catalogReducer);

  const dispatch = useDispatch();

  const createCatalog = () => {
    setModal(false);
  };

  useEffect(() => {
    dispatch(getCatalogList());
  }, []);

  return (
    <Fragment>
      <Container>
        {catalog.loading ? (
          <Load />
        ) : (
          <Col>
            <h1>CATALOGS</h1>
            <Button variant="secondary" onClick={() => setModal(true)}>
              Add catalog
            </Button>
            <hr style={{ margin: "15px 0" }} />
            <Row xs={1} md={3} className="g-4">
              {catalog.catalogs !== null && catalog.catalogs.length !== 0 ? (
                catalog.catalogs.map((item) => {
                  return (
                    <CatalogItem key={item.id} Id={item.id} Name={item.name} />
                  );
                })
              ) : (
                <h2>Gatalogs not found</h2>
              )}
            </Row>
          </Col>
        )}
        <MyModal visible={modal} setVisible={setModal}>
          <AddForm dispatch={dispatch} create={createCatalog} />
        </MyModal>
      </Container>
    </Fragment>
  );
};

export default CatalogList;
