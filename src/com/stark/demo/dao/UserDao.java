package com.stark.demo.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import com.stark.demo.entitys.User;

public interface UserDao extends CrudRepository<User, String>,JpaSpecificationExecutor<User> {

	@Query("SELECT t FROM User t")
	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<User> findListByCache();
	
}