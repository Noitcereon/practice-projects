import { useContext } from "react";
import { LoginContext } from "../Context/LoginContext";

export default function Login() {
  const keycloak = useContext(LoginContext);
  const isLoggedIn: boolean = keycloak.subject !== undefined;
  console.log(keycloak.subject, "keycloak subject");
  console.log(isLoggedIn);
  return (
    <section>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 
        ${isLoggedIn ? "hidden" : ""}`}
        onClick={() => keycloak.login()}
      >
        Login
      </button>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 
        ${isLoggedIn ? "" : "hidden"}`}
        onClick={() => keycloak.logout()}
      >
        Logout
      </button>
    </section>
  );
}
