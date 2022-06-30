package search;

import data.FakeData;
import data.IData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

class SearchEngine2Test {

    private static IData<String> fakeData;
    private static ISearchEngine<String> searchEngine;

    @BeforeAll
    static void setUp(){
        List<String> testData = new ArrayList<>();
        testData.add("House of the Rising Sun");
        testData.add("The Forgotten");
        testData.add("Emperor's Cassock");
        testData.add("Industrialism at it's Finest");
        testData.add("What We Seek, We Find");
        testData.add("Cloud Above");
        testData.add("Cloud Below");
        testData.add("As Above, So Below");
        testData.add("Equality is a Tough Concept to Implement Fairly");
        testData.add("Art Thou Whom I Seek");
        testData.add("Eragon");
        testData.add("Eradication of the Cheese: A Blasphemous Event");
        testData.add("Dawn of a New Era");
        fakeData = new FakeData(testData);
        searchEngine = new SearchEngine2(fakeData.get());
    }

    @Test
    void givenStrictSearchQuery_whenSearching_thenShowOnlyElementsContainingStrictSearchWordsCaseInsensitive() {
        // Arrange
        String searchQuery = "\"Below\"";
        String searchQueryDifferentCasing = "\"beLow\"";
        Collection<String> expected = new HashSet<>();
        expected.add("Cloud Below");
        expected.add("As Above, So Below");
        // Act
        Collection<String> result = searchEngine.search(searchQuery);
        Collection<String> result2 = searchEngine.search(searchQueryDifferentCasing);

        // Assert
        Assertions.assertEquals(expected.toString(), result.toString());
        Assertions.assertEquals(expected.toString(), result2.toString());
    }
    @Test
    void givenLooseSearchQuery_whenSearching_thenShowResultsContainingPartialMatchesCaseInsensitive(){
        String searchQuery = "era?";
        Collection<String> expected = new ArrayList<>();
        expected.add("Eragon");
        expected.add("Eradication of the Cheese: A Blasphemous Event");
        expected.add("Dawn of a New Era");

        Collection<String> result = searchEngine.search(searchQuery);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
    @Test
    void givenEmptySearchQuery_whenSearching_thenGetAll(){
        String searchQuery = "";
        Integer expectedSize = fakeData.get().size();
        Collection<String> result = searchEngine.search(searchQuery);

        Assertions.assertEquals(expectedSize, result.size());
    }
}