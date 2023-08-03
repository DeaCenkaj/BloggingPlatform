package com.dea.codingdojo.blogplatform.repositories;

import com.dea.codingdojo.blogplatform.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findByUserName(String userName);
    User findByIdIs(Long id);
}
