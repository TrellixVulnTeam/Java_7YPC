import React, { Fragment, useState, useEffect } from "react";
import { connect, useDispatch, useSelector } from "react-redux";

import { getCatalogList } from "../../redux/actions/catalogs";
import CatalogItem from "./CatalogItem";
import { Row, Col, Container, Button } from "react-bootstrap";
import Load from "../Loader/Loader";
import MyModal from "../../components/Modal/MyModal";
import AddForm from "../FormAdd/AddForm";
import DeleteForm from "../FormDelete/DeleteForm";
import EditForm from "../FormEdit/EditForm";
const CatalogList = () => {
  const [modal, setModal] = useState(false);
  const [isDel, setIsDel] = useState(false);
  const [isAdd, setIsAdd] = useState(false);
  const [isEdit, setIsEdit] = useState(false);
  const [removeItem, setRemoveItem] = useState();
  const [editItem, setEditItem] = useState();

  const catalog = useSelector((state) => state.catalogReducer);

  const dispatch = useDispatch();

  const createCatalog = () => {
    setModal(false);
    setIsAdd(false);
  };

  const closeDel = () => {
    setModal(false);
    setIsDel(false);
  };

  const closeEdit = () => {
    setModal(false);
    setIsEdit(false);
  };

  const removeCatalog = (item) => {
    setIsDel(true);
    setModal(true);
    setRemoveItem(item);
  };

  const editCatalog = (item) => {
    setIsEdit(true);
    setModal(true);
    setEditItem(item);
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
            <Button
              variant="secondary"
              onClick={() => {
                setModal(true);
                setIsAdd(true);
              }}
            >
              Add catalog
            </Button>
            <hr style={{ margin: "15px 0" }} />
            <Row xs={1} md={3} className="g-4">
              {catalog.catalogs !== null && catalog.catalogs.length !== 0 ? (
                catalog.catalogs.map((item) => {
                  return (
                    <CatalogItem
                      key={item.id}
                      Id={item.id}
                      Name={item.name}
                      Image={item.image}
                      delete={removeCatalog}
                      edit={editCatalog}
                    />
                  );
                })
              ) : (
                <h2>Gatalogs not found</h2>
              )}
            </Row>
          </Col>
        )}
        <MyModal visible={modal} setVisible={setModal}>
          {isDel && (
            <DeleteForm
              dispatch={dispatch}
              item={removeItem}
              close={closeDel}
            />
          )}
          {isAdd && <AddForm dispatch={dispatch} create={createCatalog} />}
          {isEdit && (
            <EditForm dispatch={dispatch} item={editItem} close={closeEdit} />
          )}
        </MyModal>
      </Container>
    </Fragment>
  );
};

export default CatalogList;
