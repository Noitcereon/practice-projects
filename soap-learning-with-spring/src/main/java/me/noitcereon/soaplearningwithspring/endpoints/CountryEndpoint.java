package me.noitcereon.soaplearningwithspring.endpoints;


import io.spring.guides.gs_producing_web_service.*;
import jakarta.xml.bind.JAXBElement;
import me.noitcereon.soaplearningwithspring.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
    @ResponsePayload
    public CreateCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {
        CreateCountryResponse response = new CreateCountryResponse();
        response.setCreatedCountry(countryRepository.createCountry(request.getCountry()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
    @ResponsePayload
    public UpdateCountryResponse updateCountry(@RequestPayload UpdateCountryRequest request) {
        UpdateCountryResponse response = new UpdateCountryResponse();
        response.setUpdatedCountry(countryRepository.updateCountry(request.getNameOfCountryToUpdate(), request.getUpdatedCountry()));
        return response;
    }

    // TODO: Make deleteCountry
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
//    @ResponsePayload
//    public JAXBElement<String> deleteCountry(@RequestPayload DeleteCountryRequest request) {
//        String response = countryRepository.deleteCountry(request.getNameOfCountryToDelete());
//        JAXBElement jaxbElement = new JAXBElement(new QName(NAMESPACE_URI, "deleteCountryResponse"), String)
//        return createResponseObject(response, String.class);
//    }
//    private JAXBElement<?> createResponseObject(T object, Class<?> clazz){
//        return new JAXBElement<>()
//    }
}