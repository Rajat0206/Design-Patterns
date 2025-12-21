package com.LLD.Filters_Paginated_API.repositories;

import com.LLD.Filters_Paginated_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
