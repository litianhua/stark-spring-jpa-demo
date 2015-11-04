package com.stark.demo.service;

import java.util.List;
import org.apache.openjpa.persistence.ReadOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stark.demo.dao.UserDao;
import com.stark.demo.entitys.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(rollbackFor = { Exception.class })
	public User saveVo(User vo) throws Exception {
		User user = null;
		try {
			user = this.userDao.save(vo);
		} catch (Exception e) {
			System.out.println("出错信息：" + e.getMessage());
		}
		return user;
	}

	@ReadOnly
	public User loadVo(String id) throws Exception {
		User user = null;
		try {
			user = this.userDao.findOne(id);
		} catch (Exception e) {
			System.out.println("出错信息：" + e.getMessage());
		}
		return user;
	}

	@ReadOnly
	public List<User> findAllList() throws Exception {
		List<User> userList = null;
		try {
			userList = (List<User>) this.userDao.findAll();
		} catch (Exception e) {
			System.out.println("出错信息：" + e.getMessage());
		}
		return userList;
	}

}
