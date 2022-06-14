import Keycloak from "keycloak-js";

const keycloak = new Keycloak("./src/keycloak.json"); // relative path from index.html

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
      if (authenticated) {
        console.info("Authenticated");
      } else {
        console.info("Not authenticated");
      }
    })
    .catch(function () {
      console.error("Failed to initialize Keycloak");
    });
};

const getUsername = () => String(keycloak.tokenParsed?.preferred_username);
const getToken = () => keycloak.token;

const login = () => keycloak.login();
const logout = () => keycloak.logout();
const isLoggedIn = () => keycloak.authenticated;

export default {
  initKeycloak,
  keycloak,
  getUsername,
  isLoggedIn,
  login,
  logout,
};
