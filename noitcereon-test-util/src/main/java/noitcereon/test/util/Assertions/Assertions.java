package noitcereon.test.util.Assertions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

public class Assertions {
    public static void assertStatusCode(HttpStatus expectedStatusCode, ResponseEntity<?> response) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
