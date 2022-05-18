package noitcereon.mydemojavaapi.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.server.UID;
import java.time.Year;
import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    // Given-When-Then test naming (Behaviour Driven Testing)

    private Movie _movie;

    @BeforeEach
    void setUp() {
        _movie = new Movie();
    }

    @Test
    void given_validInput_when_usingFullConstructor_then_movieObjectIsCreatedWithGivenInput() {
        UUID id = UUID.randomUUID();
        String title = "My Movie";
        int releaseYear = 2022;
        int durationInMinutes = 98;

        Movie movie = new Movie(id.toString(), title, releaseYear, durationInMinutes);

        assertEquals(id.toString(), movie.getUuid());
        assertEquals(title, movie.getTitle());
        assertEquals(releaseYear, movie.getReleaseYear().get(Calendar.YEAR));
        assertEquals(durationInMinutes, movie.getDurationInMinutes());
    }

    @Test
    void given_invalidUuidInput_when_settingUuid_then_uuidIsDifferentToInput() {
        String invalidUuid1 = "abcd";
        String invalidUuid2 = new UID().toString();

        _movie.setUuid(invalidUuid1);
        assertNotEquals(invalidUuid1, _movie.getUuid());

        _movie.setUuid(invalidUuid2);
        assertNotEquals(invalidUuid2, _movie.getUuid());
    }

    @Test
    void given_invalidYearInput_when_settingReleaseYear_then_yearIsNotSet() {
        int invalidYear = 25555;
        _movie.setReleaseYear(invalidYear);

        assertNotEquals(invalidYear, _movie.getReleaseYear().get(Calendar.YEAR));
    }

    @Test
    void given_invalidDuration_when_settingMovieDuration_then_durationIsNotSet() {

    }
}