package search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine2 extends BaseSearchEngine<String> {
    public SearchEngine2(Collection<String> data) {
        super(data);
    }

    @Override
    public List<String> search(String searchQuery) {
        String normalizedQuery = searchQuery.toLowerCase(Locale.ROOT);
        // regex: (.*)("\w+")+(.*)
        // Checks if double quotes surrounds 1 or more alphanumeric characters anywhere in the query
        boolean containsStrictSearch = normalizedQuery.matches("(.*)(\"\\w+\")+(.*)");
        if (containsStrictSearch) {
            String[] searchQuerySplitOnQuotes = searchQuery.split("\"");
            Collection<String> searchMustContain = findMustContainStrings(searchQuerySplitOnQuotes);
            System.out.println("Strict filter");
            return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery, searchMustContain)).collect(Collectors.toList());
        }
        System.out.println("Loose filter");
        return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery)).collect(Collectors.toList());
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
        // TODO: implement loose search (partial match & count chars is)
        // lowerCase dataPiece
        String normalizedData = dataPiece.toLowerCase(Locale.ROOT);
        // split searchQuery on spaces
        String[] splitSearchQuery = searchQuery.split("\\s{1,2}"); // 1 or 2 space/linebreak/tabs
        for (String searchWord : splitSearchQuery) {
            // if dataPiece contains any of the split pieces
            if (normalizedData.contains(searchWord)) return true;  // return true
            if (containsPartialMatch(normalizedData, searchWord)) return true;
            // if the count of the individual chars matches words (optional)
            // return true
        }

        return false;
    }

    private boolean containsPartialMatch(String normalizedData, String searchWord) {
        if (searchWord.length() < 3 || normalizedData.length() < searchWord.length()) return false;
        char[] dataChars = normalizedData.toCharArray();
        char[] searchWordChars = searchWord.toCharArray();

        // if 3 chars in a row are the same, return true
        for (int searchIndex = 0; searchIndex < searchWord.length() - 2; searchIndex++) {
            for (int dataCharIndex = 0; dataCharIndex < normalizedData.length()-2; dataCharIndex++) {
                if (dataChars[dataCharIndex] == searchWordChars[searchIndex]
                        && dataChars[dataCharIndex + 1] == searchWordChars[searchIndex + 1]
                        && dataChars[dataCharIndex + 2] == searchWordChars[searchIndex + 2]) {
                    return true;
                }
            }
        }
        return false;
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
