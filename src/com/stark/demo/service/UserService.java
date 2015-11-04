package com.stark.demo.service;

import java.util.List;
import com.stark.demo.entitys.User;

public interface UserService {

	/**
	 * 保存User对象
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public User saveVo(User vo) throws Exception;
	
	/**
	 * 根据id获取User对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User loadVo(String id) throws Exception;
	
	/**
	 * 查询所有的User
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllList() throws Exception;
	
}
