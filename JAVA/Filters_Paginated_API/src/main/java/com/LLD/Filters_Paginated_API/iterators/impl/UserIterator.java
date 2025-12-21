package com.LLD.Filters_Paginated_API.iterators.impl;

import com.LLD.Filters_Paginated_API.iterators.Iterator;
import com.LLD.Filters_Paginated_API.models.User;
import com.LLD.Filters_Paginated_API.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// Cursor Based Pagination

@Service
public class UserIterator implements Iterator<List<User>> {
    private final int limit;
    private int page;
    private List<User> currentBatch;
    private final int maxLimit = 5;                           // max limit per page
    private final UserRepository userRepository;

    @Autowired
    public UserIterator(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.page = 0;
        this.limit = this.maxLimit;                  // page size
        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
    }

//    public UserIterator(UserRepository userRepository) {
//        this.page = 0;
//        this.limit = this.maxLimit;                  // page size
//        this.currentBatch = userRepository.findAll(PageRequest.of(this.page, this.limit)).getContent();
//    }

    public UserIterator(UserRepository userRepository, int limit) {
        this.userRepository = userRepository;
        this.page = 0;
        this.limit = Math.min(limit, maxLimit);
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

    public Integer getCurrentPage() {
        return this.page;
    }

    public Integer getLimit() {
        return this.limit;
    }
}
