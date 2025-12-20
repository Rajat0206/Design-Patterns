package org.LLD.data;

import org.LLD.models.User;

import java.util.Optional;

// we can have different implementations of this interface like Buyer, Seller, Mediator, SpecialUser etc.
public interface IUserRepository {
    void addUser(User user);
    void removeUser(User user);
    Optional<User> getUserById(Long id);
}
