import React, { useState } from "react";
import { Image, Button } from "react-bootstrap";

import UploadService from "../services/upload-files-service";

const ImageSelect = ({ addImage, title }) => {
  const [inputs, setInpunts] = useState([]);
  const [files, setFiles] = useState([]);
  const [isHovered, setHover] = useState(false);
  const hiddenFileInput = React.useRef();

  const appendInput = () => {
    var newInput = `input-${inputs.length}`;
    setInpunts([...inputs, newInput]);
  };

  const uploadImage = () => {
    appendInput();
    setTimeout(() => {
      if (!hiddenFileInput.current) return;
      // console.log("Отправленное имя: " + hiddenFileInput.current.name);
      handleClick();
    }, 500);
  };

  const handleClick = (event) => {
    hiddenFileInput.current.click();
  };

  const handleChange = (event) => {
    const fileUploaded = event.target.files[0];
    console.log("upload file" + fileUploaded);

    addImage({
      image: fileUploaded,
      title: title,
    });

    var newFile = URL.createObjectURL(event.target.files[0]);
    setFiles([...files, newFile]);
    console.log(files);
  };

  return (
    <div>
      <h4>Add image</h4>
      <div className="row">
        <div className="col-md-3" onClick={uploadImage}>
          <img
            src="https://cdn2.iconfinder.com/data/icons/leto-most-searched-mix-5/64/__image_plus_add-512.png"
            width="100%"
            alt="Пошук фото"
            style={{ cursor: "pointer" }}
            id="btnAddImage"
          />
        </div>
        {files.map((file, index) => (
          <div
            key={index}
            className="col-md-3"
            onMouseOver={() => setHover(true)}
            onMouseLeave={() => setHover(false)}
            style={{
              position: "relative",
              width: "100px",
              height: "100px",
            }}
          >
            <Image
              //   key={index}
              src={file}
              width="100%"
              alt="обране фото"
              //   style={{"cursor: pointer"}}
              id="img"
              name="img"
            />
            {isHovered && (
              <Button
                size="sm"
                style={{
                  position: "absolute",
                  top: "2px",
                  right: "15px",
                }}
                variant="primary"
              >
                x
              </Button>
            )}
          </div>
        ))}
      </div>

      <div id="dynamicInput">
        {inputs.map((input, index) => (
          <span key={index}>
            <input
              key={input}
              type="file"
              style={{ display: "none" }}
              ref={hiddenFileInput}
              name="images"
              onChange={handleChange}
            />

            {/* <button>X</button> */}
          </span>
        ))}
      </div>
    </div>
  );
};

export default ImageSelect;
