package me.noitcereon.soaplearningwithspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapLearningWithSpringApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SoapLearningWithSpringApplication.class);
    public static void main(String[] args) {
        if(args.length != 0){
            LOG.info("Starting application with the following arguments: ");
            for (String arg : args){
                LOG.info("Argument: {}", arg);
            }
        }
        else {
            LOG.debug("Application starting without additional arguments set.");
        }
        SpringApplication.run(SoapLearningWithSpringApplication.class, args);
    }

}
