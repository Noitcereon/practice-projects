import Keycloak from "keycloak-js";

const keycloak = new Keycloak("./src/keycloak.json");

const initKeycloak = (renderApp: CallableFunction) => {
  keycloak
    .init({
      onLoad: "check-sso",
      silentCheckSsoRedirectUri:
        window.location.origin + "/silent-check-sso.html",
      pkceMethod: "S256",
    })
    .then(function (authenticated) {
      renderApp();
      if(authenticated){
        console.info("Authenticated");
      }
      else{
        console.info("Not authenticated");
      }
    })
    .catch(function () {
      console.error("Failed to initialize Keycloak");
    });
};


export { initKeycloak, keycloak };
