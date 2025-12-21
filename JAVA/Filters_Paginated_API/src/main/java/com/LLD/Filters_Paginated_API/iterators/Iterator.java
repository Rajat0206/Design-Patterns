package com.LLD.Filters_Paginated_API.iterators;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    T next(int limit);
    T next(int page, int limit);
}
