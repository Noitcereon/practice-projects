package search;

import java.util.Collection;

public interface ISearchEngine<T> {
    Collection<T> search(String input);
}
