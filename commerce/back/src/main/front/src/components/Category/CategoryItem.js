import React, { Fragment } from "react";
import { Col, Card, Row } from "react-bootstrap";
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas, faGamepad } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";

library.add(fas, faGamepad);

export default class CategoryItem extends React.Component {
  render() {
    const { Name, Id } = this.props;

    return (
      <Fragment>
        <Col>
          <Link
            to={`/category/products/${Id}`}
            style={{ textDecoration: "none", color: "black" }}
          >
            <Card
              style={{
                height: "230px",
                alignItems: "center",
                cursor: "pointer",
              }}
            >
              <Card.Img
                variant="top"
                // src="https://www.pngall.com/wp-content/uploads/4/Headphone-Transparent-PNG.png"
                src="https://picsum.photos/200/300?random=2"
                style={{ height: "150px", width: "150px" }}
              />
              <Card.Body>
                <Card.Title>
                  <FontAwesomeIcon
                    icon="gamepad"
                    style={{ marginRight: "8px" }}
                  />
                  {Name}
                </Card.Title>
              </Card.Body>
            </Card>
          </Link>
        </Col>
      </Fragment>
    );
  }
}
