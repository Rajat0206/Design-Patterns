package org.LLD.data.impl;

import org.LLD.data.IUserRepository;
import org.LLD.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuyerRepository implements IUserRepository {
    private final List<User> buyers;

    public BuyerRepository() {
        this.buyers = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.buyers.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.buyers.remove(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.buyers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
