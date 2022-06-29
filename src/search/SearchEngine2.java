package search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine2 extends BaseSearchEngine<String>{
    public SearchEngine2(List<String> data) {
        super(data);
    }

    @Override
    public Set<String> search(String searchQuery) {
        // TODO: Write tests for search function
        String normalizedQuery = searchQuery.toLowerCase(Locale.ROOT);

        String[] searchQuerySplitOnQuotes = searchQuery.split("\"");
        boolean containsStrictSearch = searchQuerySplitOnQuotes.length > 1;
        if(containsStrictSearch){
            Collection<String> searchMustContain = findMustContainStrings(searchQuerySplitOnQuotes);
            return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery, searchMustContain)).collect(Collectors.toSet());
        }

        return data.stream().filter(dataPiece -> filter(dataPiece, normalizedQuery)).collect(Collectors.toSet());
    }

    private Collection<String> findMustContainStrings(String[] searchQuerySplitOnQuotes) {
        Collection<String> searchMustContain = new HashSet<>();
        for (int i = 0; i < searchQuerySplitOnQuotes.length; i++) {
            boolean isSurroundedByQuotes = (i+1) % 2 == 0;
            if(isSurroundedByQuotes){
                searchMustContain.add(searchQuerySplitOnQuotes[i]);
            }
        }
        return searchMustContain;
    }

    private Boolean filter(String dataPiece, String searchQuery){
        // Perform loose search
        System.out.println("Simulating loose filter");
        // TODO: implement loose search (based on chars, not everything must exist)
        return true;
    }
    private Boolean filter(String dataPiece, String searchQuery, Collection<String> searchMustContain){
       // Perform strict search
        String normalizedData = dataPiece.toLowerCase(Locale.ROOT);
        for (String mustContainThis:searchMustContain) {
            if(!normalizedData.contains(mustContainThis)) return false;
        }
        // TODO: search further with the searchQuery parameter
        return true;
    }
}
