package org.chain.mysqldemo.mapper;

import org.chain.mysqldemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();

    User findById(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
