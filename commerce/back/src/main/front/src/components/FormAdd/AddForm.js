import React, { useState } from "react";
import { Button, FormControl, InputGroup } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";

import { addNewCatalog } from "../../redux/actions/catalogs";
import ImageSelect from "../image-select";

const AddForm = ({ dispatch, create }) => {
  const [catalog, setCatalog] = useState({ title: "", image: null });

  return (
    <div style={{ width: "400px" }}>
      <InputGroup className="mb-3">
        <FormControl
          placeholder="Catalog name"
          aria-describedby="basic-addon2"
          value={catalog.title}
          onChange={(e) =>
            setCatalog({
              title: e.target.value,
              catalog: catalog.image,
            })
          }
          type="text"
        />

        <Button
          type="submit"
          variant="outline-secondary"
          id="button-addon2"
          onClick={() => {
            dispatch(addNewCatalog(catalog.title, catalog.image));
            create();
            // console.log(catalog);
          }}
        >
          Add
        </Button>
      </InputGroup>
      <ImageSelect addImage={setCatalog} title={catalog.title} />
    </div>
  );
};

export default AddForm;
