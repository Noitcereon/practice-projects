package search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine2 extends BaseSearchEngine<String> {
    public SearchEngine2(Collection<String> data) {
        super(data);
    }

    @Override
    public Set<String> search(String searchQuery) {
        String normalizedQuery = searchQuery.toLowerCase(Locale.ROOT);
        // regex: (.*)("\w+")+(.*)
        // Checks if double quotes surrounds 1 or more alphanumeric characters anywhere in the query
        boolean containsStrictSearch = normalizedQuery.matches("(.*)(\"\\w+\")+(.*)");
        if (containsStrictSearch) {
            String[] searchQuerySplitOnQuotes = searchQuery.split("\"");
            Collection<String> searchMustContain = findMustContainStrings(searchQuerySplitOnQuotes);
            return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery, searchMustContain)).collect(Collectors.toSet());
        }

        return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery)).collect(Collectors.toSet());
    }

    private Collection<String> findMustContainStrings(String[] searchQuerySplitOnQuotes) {
        Collection<String> searchMustContain = new HashSet<>();
        for (int i = 0; i < searchQuerySplitOnQuotes.length; i++) {
            boolean isSurroundedByQuotes = (i + 1) % 2 == 0;
            if (isSurroundedByQuotes) {
                searchMustContain.add(searchQuerySplitOnQuotes[i]);
            }
        }
        return searchMustContain;
    }

    private Boolean filter(String dataPiece, String searchQuery) {
        // Perform loose search
        System.out.println("Simulating loose filter");
        // TODO: implement loose search (based on chars, not everything must exist)
        // TODO: Write test for loose search
        return true;
    }

    private Boolean filter(String dataPiece, String searchQuery, Collection<String> searchMustContain) {
        // Perform strict search
        String normalizedData = dataPiece.toLowerCase(Locale.ROOT);
        for (String mustContainThis : searchMustContain) {
            if (!normalizedData.contains(mustContainThis.toLowerCase(Locale.ROOT))) return false;
        }
        // TODO: search further with the searchQuery parameter
        // TODO: Write test for combined strict + loose scenario
        return true;
    }
}
