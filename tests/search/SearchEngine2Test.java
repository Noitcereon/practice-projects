package search;

import data.FakeData;
import data.IData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

class SearchEngine2Test {

    private static IData<String> fakeData;
    private static ISearchEngine<String> searchEngine;

    @BeforeAll
    static void setUp(){
        fakeData = new FakeData();
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
}