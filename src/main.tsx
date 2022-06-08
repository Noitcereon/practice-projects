import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css";
import { initKeycloak } from "./AppConfig/KeycloakConfig";
import Router from "./router";

initKeycloak();

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <Router/>
  </React.StrictMode>
);
