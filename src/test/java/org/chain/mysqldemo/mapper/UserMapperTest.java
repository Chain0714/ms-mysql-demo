package org.chain.mysqldemo.mapper;

import org.chain.mysqldemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    public void findById() {
        User user = userMapper.findById(1L);
        Assert.assertNotNull(user);
    }

    @Test
    @Transactional
    public void insert() {
        User user = new User();
        user.setName("test");
        user.setAge(23);
        user.setGender("男");
        user.setAddress("test");
        userMapper.insert(user);
        List<User> users = userMapper.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    @Transactional
    public void update() {
        User user = new User();
        user.setId(1L);
        user.setName("test");
        userMapper.update(user);
        List<User> users = userMapper.findAll();
        Assert.assertNotNull(users);
    }

    @Test
    @Transactional
    public void delete() {
        userMapper.delete(1L);
        userMapper.delete(2L);
        List<User> users = userMapper.findAll();
        Assert.assertEquals(0, users.size());
    }
}