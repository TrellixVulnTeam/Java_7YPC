import React, { Fragment, useState } from "react";
import { Col, Card, Button } from "react-bootstrap";
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  fas,
  faGamepad,
  faEdit,
  faTrash,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";

library.add(fas, faGamepad, faEdit, faTrash);

const CatalogItem = (props) => {
  const { Name, Id } = props;
  const [style, setStyle] = useState({
    display: "none",
  });

  const deleteItem = (e, id) => {
    e.preventDefault();
    props.delete(id);
  };

  return (
    <Fragment>
      <Col>
        <Link
          to={`/catalog/categories/${Id}`}
          style={{ textDecoration: "none", color: "black" }}
        >
          <Card
            style={{
              height: "230px",
              alignItems: "center",
              cursor: "pointer",
            }}
            onMouseEnter={(e) => {
              setStyle({ display: "block" });
            }}
            onMouseLeave={(e) => {
              setStyle({ display: "none" });
            }}
          >
            <Card.Img
              variant="top"
              src="https://www.pngall.com/wp-content/uploads/4/Headphone-Transparent-PNG.png"
              style={{ height: "150px", width: "150px" }}
            />
            <Card.Body>
              <Card.Title>
                {/* <FontAwesomeIcon
                  icon="gamepad"
                  style={{ marginRight: "8px" }}
                /> */}
                {Name}
              </Card.Title>

              <div style={style}>
                <div style={{ position: "absolute", top: "2px", right: "2px" }}>
                  <Button
                    variant="outline-primary"
                    style={{ marginRight: "2px" }}
                  >
                    <FontAwesomeIcon icon="edit" />
                  </Button>
                  <Button
                    variant="outline-danger"
                    onClick={(e) => deleteItem(e, Id)}
                  >
                    <FontAwesomeIcon icon="trash" />
                  </Button>
                </div>
              </div>
            </Card.Body>
          </Card>
        </Link>
      </Col>
    </Fragment>
  );
};

export default CatalogItem;
