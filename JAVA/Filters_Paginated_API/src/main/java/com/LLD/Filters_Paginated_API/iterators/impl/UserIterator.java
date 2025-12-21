package com.LLD.Filters_Paginated_API.iterators.impl;

import com.LLD.Filters_Paginated_API.iterators.Iterator;
import com.LLD.Filters_Paginated_API.models.User;
import com.LLD.Filters_Paginated_API.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;

// Cursor Based Pagination
public class UserIterator implements Iterator<List<User>> {
    private int limit;
    private int page;
    private List<User> currentBatch;
    private int maxLimit;                           // max limit per page
    private final UserRepository userRepository;

    public UserIterator(UserRepository userRepository) {
        this.page = 0;
        this.maxLimit = 20;
        this.limit = this.maxLimit;                  // page size
        this.userRepository = userRepository;
        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
    }

    public UserIterator(UserRepository userRepository, int limit) {
        this.page = 0;
        this.maxLimit = 20;
        this.limit = Math.min(limit, maxLimit);
        this.userRepository = userRepository;
        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
    }

    @Override
    public boolean hasNext() {
        return !currentBatch.isEmpty();
    }

    @Override
    public List<User> next() {
        List<User> result = currentBatch;
        this.page++;
        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
        return result;
    }

    @Override
    public List<User> next(int limit) {
        limit = Math.min(limit, this.limit);

        List<User> result = this.currentBatch.subList(0, Math.min(limit, this.currentBatch.size()));

        if(this.currentBatch.size() <= limit) {
            this.page++;
            this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
            limit -= result.size();
            result.addAll(this.currentBatch.subList(0, Math.min(limit, this.currentBatch.size())));
        }

        this.currentBatch = this.currentBatch.subList(limit, this.currentBatch.size());
        return result;
    }

    @Override
    public List<User> next(int page, int limit) {
        limit = Math.min(limit, this.maxLimit);
        this.page = page;

        List<User> result = userRepository.findAll(PageRequest.of(this.page, limit)).getContent();
        this.page++;
        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();

        return result;
    }
}
