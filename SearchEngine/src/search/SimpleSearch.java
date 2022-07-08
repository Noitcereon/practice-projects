package search;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleSearch implements ISearchEngine<String>{

    private final List<String> data;

    public SimpleSearch(List<String> data){
        this.data = data;
    }

    @Override
    public List<String> search(String input) {
        return data.stream().filter(x -> x.contains(input)).collect(Collectors.toList());
    }
}
