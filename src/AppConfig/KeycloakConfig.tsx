import Keycloak, { KeycloakInitOptions } from "keycloak-js";

const initKeycloak = () => {
    const keycloak = new Keycloak("src/AppConfig/keycloak.json");
    
    keycloak.init({}).then(function(authenticated) {
        if(authenticated !== null) console.info("Keycloak initialized");
    }).catch(function() {
        console.error('failed to initialize Keycloak');
    });
}

export default initKeycloak;
