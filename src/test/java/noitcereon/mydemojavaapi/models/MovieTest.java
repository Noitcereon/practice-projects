package noitcereon.mydemojavaapi.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void given_invalidUidInput_when_settingUid_then_uidIsNotSet() {

    }

    @Test
    void given_invalidYearInput_when_settingReleaseYear_then_yearIsNotSet() {

    }

    @Test
    void given_invalidDuration_when_settingMovieDuration_then_durationIsNotSet() {

    }
}