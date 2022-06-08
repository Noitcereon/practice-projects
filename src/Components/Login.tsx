import { useContext } from "react";
import { LoginContext } from "../Context/LoginContext";

export default function Login() {
  const keycloak = useContext(LoginContext);
  return (
    <section>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 my-2 
        ${keycloak.authenticated ? "hidden" : ""}`}
        onClick={() => keycloak.login()}
      >
        Login
      </button>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 my-2 
        ${keycloak.authenticated ? "" : "hidden"}`}
        onClick={() => keycloak.logout()}
      >
        Logout
      </button>
    </section>
  );
}
