import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getProduct } from "../../redux/actions/product";
import Load from "../Loader/Loader";

import "./productView.css";

const ProductView = (props) => {
  const dispatch = useDispatch();

  const url = "http://localhost:8081/api/public/files/";
  const product = useSelector((state) => state.productReducer);

  const [mainImage, setMainImage] = useState("");

  useEffect(() => {
    let id = props.match.params.id;
    dispatch(getProduct(id));
  }, []);

  const click = () => {
    console.log("this >> " + product.products.images[0].name);
  };

  const changeMainImage = (e) => {
    console.log(e.target.currentSrc);
    setMainImage(`${e.target.currentSrc}`);
  };

  return (
    <div>
      {product.loading ? (
        <Load />
      ) : (
        <div className="container mt-5 mb-5">
          <div className="card">
            <div className="row g-0">
              <div className="col-md-6 border-end">
                <div className="d-flex flex-column justify-content-center">
                  <div className="main_image">
                    {product.products.images ? (
                      <img
                        src={mainImage}
                        onError={(event) => {
                          event.target.src = `${url}${product.products.images[0].name}`;
                          event.onerror = null;
                        }}
                        id="main_product_image"
                        width="350"
                      />
                    ) : (
                      <img
                        src="https://ang-projects.com/public/uploads/contents/testi-no-image.png"
                        id="main_product_image"
                        width="350"
                      />
                    )}
                  </div>
                  <div className="thumbnail_images">
                    <ul id="thumbnail">
                      {product.products.images.map((img, index) => {
                        return (
                          <li key={index}>
                            <img
                              onClick={changeMainImage}
                              src={`${url}${img.name}`}
                              width="70"
                            />
                          </li>
                        );
                      })}
                    </ul>
                  </div>
                </div>
              </div>
              <div className="col-md-6">
                <div className="p-3 right-side">
                  <div className="d-flex justify-content-between align-items-center">
                    <h3>{product.products.title}</h3>
                    <span className="heart">
                      <i className="bx bx-heart"></i>
                    </span>
                  </div>
                  <div className="mt-2 pr-3 content">
                    <p>{product.products.description}</p>
                  </div>
                  <h3>${product.products.price}</h3>
                  <div className="ratings d-flex flex-row align-items-center">
                    <div className="d-flex flex-row">
                      <i className="bx bxs-star"></i>{" "}
                      <i className="bx bxs-star"></i>
                      <i className="bx bxs-star"></i>{" "}
                      <i className="bx bxs-star"></i>
                      <i className="bx bx-star"></i>
                    </div>
                    <span>441 reviews</span>
                  </div>
                  <div className="mt-5">
                    <span className="fw-bold">Color</span>
                    <div className="colors">
                      <ul id="marker">
                        <li id="marker-1"></li>
                        <li id="marker-2"></li>
                        <li id="marker-3"></li>
                        <li id="marker-4"></li>
                        <li id="marker-5"></li>
                      </ul>
                    </div>
                  </div>
                  <div className="buttons d-flex flex-row mt-5 gap-3">
                    <button className="btn btn-outline-dark" onClick={click}>
                      Buy Now
                    </button>
                    <button className="btn btn-dark">Add to Basket</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ProductView;
