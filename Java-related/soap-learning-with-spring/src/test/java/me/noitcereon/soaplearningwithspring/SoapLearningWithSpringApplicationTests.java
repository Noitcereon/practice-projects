package me.noitcereon.soaplearningwithspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SoapLearningWithSpringApplicationTests {

    @Test
    void contextLoads() {
        String message = "It loads";
        Assertions.assertEquals("It loads", message);
    }

}
