package com.stark.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.stark.demo.entitys.User;

public interface UserDao extends CrudRepository<User, String> {

}