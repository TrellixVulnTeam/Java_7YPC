import React from "react";
import { Form, Button, Row, Col, Container, Image } from "react-bootstrap";
import ImageSelect from "../image-select";
const EditProduct = () => {
  return (
    <Container>
      <Form>
        <Row className="mb-3">
          <Col sm={6}>
            <Form.Group as={Col}>
              <Form.Label>Title</Form.Label>
              <Form.Control />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Description</Form.Label>
              <Form.Control />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Description</Form.Label>
              <Form.Control />
            </Form.Group>

            <Form.Group as={Col}>
              <Form.Label>Description</Form.Label>
              <Form.Control />
            </Form.Group>
          </Col>

          <Col sm={6}>
            {/* <Form.Group controlId="formFileMultiple" className="mb-3">
              <Form.Label>Multiple files input example</Form.Label>
              <Form.Control type="file" multiple />
            </Form.Group> */}

            <Container>
              <Row>
                <Col>
                  {/* <Image
                    style={{ width: 100, height: "auto" }}
                    src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Icons8_flat_add_image.svg/1024px-Icons8_flat_add_image.svg.png"
                    rounded
                  /> */}

                  <ImageSelect />
                </Col>
              </Row>
            </Container>
          </Col>
        </Row>

        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </Container>
  );
};

export default EditProduct;
