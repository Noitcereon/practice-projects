package me.noitcereon;

import com.baeldung.jaxws.server.topdown.EmployeeServiceTopDown;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(
        name = "EmployeeServiceTopDown",
        endpointInterface = "com.baeldung.jaxws.server.topdown.EmployeeServiceTopDown",
        targetNamespace = "http://topdown.server.jaxws.baeldung.com/")
public class EmployeeServiceTopDownImpl
        implements EmployeeServiceTopDown {

    @WebMethod
    public int countEmployees() {
        return 9001; // "It's over NINE-THOUSAND!"
    }
}