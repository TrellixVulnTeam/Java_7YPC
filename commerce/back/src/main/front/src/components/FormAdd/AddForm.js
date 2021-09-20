import React, { useState } from "react";
import { Button, FormControl, InputGroup } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";

import { addNewCatalog } from "../../redux/actions/catalogs";

const AddForm = ({ dispatch, create }) => {
  const [catalog, setCatalog] = useState({ title: "" });

  return (
    <InputGroup className="mb-3">
      <FormControl
        placeholder="Catalog name"
        aria-describedby="basic-addon2"
        value={catalog.title}
        onChange={(e) =>
          setCatalog({
            title: e.target.value,
          })
        }
        type="text"
      />
      <Button
        type="submit"
        variant="outline-secondary"
        id="button-addon2"
        onClick={() => {
          dispatch(addNewCatalog(catalog.title));
          create();
        }}
      >
        Add
      </Button>
    </InputGroup>
  );
};

export default AddForm;
