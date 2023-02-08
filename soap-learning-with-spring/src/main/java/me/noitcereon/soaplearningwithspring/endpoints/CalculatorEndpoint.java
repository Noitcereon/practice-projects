package me.noitcereon.soaplearningwithspring.endpoints;

import com.noitcereon.calculator.AddRequest;
import com.noitcereon.calculator.AddResponse;
import me.noitcereon.soaplearningwithspring.repositories.CalculatorRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;

@Endpoint
public class CalculatorEndpoint {

    // This functions like a java package for XML. "Where can I find the stuff?"
    // The package of this class is "package me.noitcereon.soaplearningwithspring.endpoints;"
    // The namespace URI is defined in the calculator.xsd and the WebServiceConfig
    private static final String NAMESPACE_URI = "http://noitcereon.com/calculator";
    private final CalculatorRepository calculator;

    // @Autowired
    public CalculatorEndpoint(CalculatorRepository calculatorRepository){
        this.calculator = calculatorRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
    @ResponsePayload
    public AddResponse add(@RequestPayload AddRequest request){
        // The AddResponse is an auto-generated class, which is defined by the calculator.xsd. So is the AddRequest.
        AddResponse response = new AddResponse();
        BigDecimal calculation = calculator.add(request.getNumberInputs().getFirstNumber(), request.getNumberInputs().getSecondNumber());
        response.setCalculationResult(calculation);
        return response;
    }
}
