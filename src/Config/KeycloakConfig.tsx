import Keycloak, { KeycloakInitOptions } from "keycloak-js";

const keycloak = new Keycloak("./keycloak.json");

export default keycloak;
