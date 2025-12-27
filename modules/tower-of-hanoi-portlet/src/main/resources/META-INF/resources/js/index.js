import React from "react";
import ReactDOM from "react-dom";
import TowerOfHanoi from "./TowerOfHanoi.jsx";

export default function (elementId) {
  ReactDOM.render(<TowerOfHanoi />, document.getElementById(elementId));
}
