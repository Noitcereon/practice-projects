import React from "react";
import App from "../App";
import { keycloak } from "../AppConfig/KeycloakConfig";

export const LoginContext = React.createContext(keycloak);

function LoginProvider(){
    return(
        <LoginContext.Provider value={keycloak}>
            <App/>
        </LoginContext.Provider>
    )
}

export default LoginProvider;