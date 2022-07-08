package search;

import java.util.Collection;
import java.util.List;

public abstract class BaseSearchEngine<T> implements ISearchEngine<String>{
    protected Collection<T> data;

    public BaseSearchEngine(Collection<T> data){
        this.data = data;
    }
    @Override
    public abstract Collection<String> search(String input);
}
