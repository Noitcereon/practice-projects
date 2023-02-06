# SOAP Learning with Spring

This project is about learning the basics of SOAP. To ease that process
I am using Spring Boot.

I'm following along with the [producing-web-services guide](https://spring.io/guides/gs/producing-web-service/)
made by spring.io

## Installation

Installation steps to run this code.

 **Prerequisites**
- JDK 17+ 
- Maven (IntelliJ comes with a Maven install)

1. Run `mvn clean install` command.
   - If you're using the integrated IntelliJ Maven you need to press `[Ctrl + Enter]` to trigger the command.

## Usage

To run the application use the command `mvn spring-boot:run`

This launches the application. The soap endpoint can be accessed at `localhost:8080/ws`

The wsdl can be seen at `http://localhost:8080/ws/countries.wsdl`

Requests should be sent to the endpoint following the request format as seen below:

(I've still not gotten it to work successfully, because SoapUI needs a wsdl file that can be loaded.)
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:gs="http://spring.io/guides/gs-producing-web-service">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getCountryRequest>
            <gs:name>Spain</gs:name>
        </gs:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

## Maintainer

- Noitcereon (Thomas "Noit" Andersen)