// import { useContext } from "react";
// import { LoginContext } from "../Context/LoginContext";
import UserService from '../Services/KeycloakService';

export default function Login() {
  // const keycloak = useContext(LoginContext);
  console.log(UserService.isLoggedIn(), "isLoggedIn");
  return (
    <section>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 my-2 
        ${UserService.isLoggedIn() ? "hidden" : ""}`}
        onClick={() => UserService.login()}
      >
        Login
      </button>
      <button
        className={`bg-blue-600 rounded-lg px-5 py-1 my-2 
        ${UserService.isLoggedIn() ? "" : "hidden"}`}
        onClick={() => UserService.logout()}
      >
        Logout
      </button>
      <span className={UserService.isLoggedIn() ? "" : "hidden"}>Current user: {UserService.getUsername()}</span>
      
    </section>
  );
}
