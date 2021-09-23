import React, { useEffect, useState } from "react";
import { Button, Modal, InputGroup, FormControl } from "react-bootstrap";
import { useSelector } from "react-redux";
import { getCatalog, updateCatalog } from "../../redux/actions/catalogs";

import ImageSelect from "../image-select";

const EditForm = ({ dispatch, item, close }) => {
  const catalog = useSelector((state) => state.catalogReducer);
  const [newCatalog, setNewCatalog] = useState("");

  useEffect(() => {
    dispatch(getCatalog(item));
  }, [item]);

  return (
    <div style={{ width: "400px" }}>
      <Modal.Header>
        <Modal.Title>Edit catalog '{catalog.curretnCatalog.name}'</Modal.Title>
      </Modal.Header>

      <InputGroup className="mb-3">
        <FormControl
          placeholder="Catalog name"
          aria-describedby="basic-addon2"
          // value={catalog.curretnCatalog.name}
          onChange={(e) => setNewCatalog(e.target.value)}
          type="text"
        />
      </InputGroup>

      <Modal.Footer>
        <Button variant="secondary" onClick={() => close()}>
          Close
        </Button>
        <Button
          variant="primary"
          onClick={() => {
            catalog.curretnCatalog.name = newCatalog;
            console.log(catalog.curretnCatalog);
            dispatch(updateCatalog(catalog.curretnCatalog, item));
            close();
          }}
        >
          Save
        </Button>
      </Modal.Footer>
    </div>
  );
};

export default EditForm;
