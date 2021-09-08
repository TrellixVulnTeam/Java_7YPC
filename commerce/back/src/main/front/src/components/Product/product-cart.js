import React from "react";
import { Card, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function ItemCard(props) {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Img
        variant="top"
        src="https://www.sony.ru/image/8f499d4640b363762e66edd1a4916a10?fmt=pjpeg&wid=330&bgcolor=FFFFFF&bgc=FFFFFF"
      />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
      </Card.Body>
      <Card.Body>
        <Link to="/edit" style={{ marginRight: "5px" }}>
          <Button variant="primary">View</Button>
        </Link>
        {/* <Link to="/edit" style={{ marginRight: "5px" }}> */}
        <Link to={`/edit/${props.item.id}`} style={{ marginRight: "5px" }}>
          <Button variant="primary">Edit</Button>
        </Link>
        <Button variant="primary">Delete</Button>
      </Card.Body>
    </Card>
  );
}
