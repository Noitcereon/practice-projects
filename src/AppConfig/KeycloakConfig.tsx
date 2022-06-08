import Keycloak from "keycloak-js";

const keycloak = new Keycloak("src/AppConfig/keycloak.json");

const initKeycloak = () => {
  keycloak
    .init({
      onLoad: "check-sso",
      silentCheckSsoRedirectUri: window.location.origin + "/silent-check-sso.html"
    })
    .then(function (authenticated) {
      if (authenticated !== undefined) console.info("Keycloak initialized");
    })
    .catch(function () {
      console.error("Failed to initialize Keycloak");
    });
};

export { initKeycloak, keycloak };
