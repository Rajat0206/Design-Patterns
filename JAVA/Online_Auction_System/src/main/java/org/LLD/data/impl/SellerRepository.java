package org.LLD.data.impl;

import org.LLD.data.IUserRepository;
import org.LLD.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SellerRepository implements IUserRepository {
    private final List<User> sellers;

    public SellerRepository() {
        this.sellers = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.sellers.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.sellers.remove(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.sellers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
