package me.noitcereon.soaplearningwithspring.endpoints;


import io.spring.guides.gs_producing_web_service.CreateCountryRequest;
import io.spring.guides.gs_producing_web_service.CreateCountryResponse;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import me.noitcereon.soaplearningwithspring.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
    // TODO: Make updateCountry
    // TODO: Make deleteCountry
}