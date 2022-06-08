import Keycloak from "keycloak-js";

const keycloak = new Keycloak("src/AppConfig/keycloak.json");

const initKeycloak = () => {
  keycloak
    .init({})
    .then(function (authenticated) {
      if (authenticated !== null) console.info("Keycloak initialized");
    })
    .catch(function () {
      console.error("Failed to initialize Keycloak");
    });
};

export { initKeycloak, keycloak };
