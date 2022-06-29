package search;

import java.util.Collection;
import java.util.List;

public abstract class BaseSearchEngine<T> implements ISearchEngine<String>{
    protected List<T> data;

    public BaseSearchEngine(List<T> data){
        this.data = data;
    }
    @Override
    public abstract Collection<String> search(String input);
}
