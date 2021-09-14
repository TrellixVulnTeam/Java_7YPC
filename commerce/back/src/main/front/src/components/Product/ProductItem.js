import React, { Fragment } from "react";
import { Col, Card, Row } from "react-bootstrap";
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas, faGamepad } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";

library.add(fas, faGamepad);

export default class ProductItem extends React.Component {
  render() {
    const { Name } = this.props;

    return (
      <Fragment>
        <Col>
          <Link to="/" style={{ textDecoration: "none", color: "black" }}>
            <Card
              style={{
                height: "230px",
                alignItems: "center",
                cursor: "pointer",
              }}
            >
              <Card.Img
                variant="top"
                src="https://www.pngall.com/wp-content/uploads/4/Headphone-Transparent-PNG.png"
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
