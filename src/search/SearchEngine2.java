package search;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchEngine2 extends BaseSearchEngine<String>{
    public SearchEngine2(List<String> data) {
        super(data);
    }

    @Override
    public Set<String> search(String input) {
        String normalizedInput = input.toLowerCase(Locale.ROOT);
        return data.stream().filter(x -> x.toLowerCase().contains(normalizedInput)).collect(Collectors.toSet());
    }
}
