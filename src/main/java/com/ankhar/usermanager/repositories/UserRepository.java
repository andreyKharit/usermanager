package com.ankhar.usermanager.repositories;

import com.ankhar.usermanager.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    <S extends User> S save(S s);

    @Override
    Iterable<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    @Override
    void delete(User user);
}
