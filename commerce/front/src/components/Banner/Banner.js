import React, { Component } from "react";
import ReactDOM from "react-dom";

const Banner = ({ title, description }) => {
  let squares = [];

  //   for (let i = 0; i < 20; i++) {
  //     if (window.CP.shouldStopExecution(0)) break;
  //     squares.push(i);
  //   }
  //   window.CP.exitedLoop(0);

  const generateRandomNum = ({ min, max }) =>
    Math.floor(Math.random() * (max - min + 1) + min);

  return /*#__PURE__*/ React.createElement(
    "div",
    { className: "intro" } /*#__PURE__*/,
    React.createElement(
      "div",
      { className: "quote" } /*#__PURE__*/,
      React.createElement("h1", null, title) /*#__PURE__*/,
      React.createElement("p", null, description)
    ) /*#__PURE__*/,

    React.createElement(
      "div",
      { className: "squares-wrapper" } /*#__PURE__*/,
      React.createElement(
        "ul",
        { className: "squares" },
        squares.map((el, i) => {
          const randomDimensions = Math.floor(
            Math.random() * (150 - 15 + 1) + 15
          );

          return /*#__PURE__*/ React.createElement("li", {
            key: i,
            style: {
              left: `${generateRandomNum({ min: 0, max: 90 })}%`,
              width: randomDimensions,
              height: randomDimensions,
              animationDelay: `${
                i % 2 ? generateRandomNum({ min: 0, max: 20 }) : 0
              }s`,
              animationDuration: `${generateRandomNum({
                min: 10,
                max: 50,
              })}s`,
            },
          });
        })
      )
    ) /*#__PURE__*/,

    React.createElement("div", { className: "image-overlay" })
  );
};

// Banner.propTypes = {
//   title: PropTypes.string,
//   description: PropTypes.string,
// };

const app = /*#__PURE__*/ React.createElement(Banner, {
  title: "Title!",
  description: "Description",
});

export default Banner;
