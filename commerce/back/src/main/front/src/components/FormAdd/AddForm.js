import React, { useState } from "react";
import { Button, FormControl, InputGroup } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";

import { addNewCatalog } from "../../redux/actions/catalogs";

const AddForm = ({ dispatch, create }) => {
  const [catalog, setCatalog] = useState({ title: "" });

  //   const dispatch = useDispatch();

  //   function addNewCatalog(e) {
  //     // e.preventDefault();
  //     console.log(catalog.title);

  //     // dispatch(addNewCatalog(catalog.title));

  //     setCatalog({
  //       title: "",
  //     });
  //   }

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
        // onClick={addNewCatalog}
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

{
  /* <Modal.Dialog>
<Modal.Header closeButton>
  <Modal.Title>Modal title</Modal.Title>
</Modal.Header>

<Modal.Body>
  <p>Modal body text goes here.</p>
</Modal.Body>

<Modal.Footer>
  <Button variant="secondary">Close</Button>
  <Button variant="primary">Save changes</Button>
</Modal.Footer>
</Modal.Dialog> */
}
