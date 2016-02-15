package com.stark.demo.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.stark.demo.entitys.User;

public interface IUserService {

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
	
	/**
	 * 使用Specification查询
	 * @param spec
	 * @return
	 * @throws Exception
	 */
	public List<User> findList(Specification<User> spec) throws Exception;
	
	/**
	 * 开启二级查询缓存的列表查询
	 * @return
	 * @throws Exception
	 */
	public List<User> findListByCache() throws Exception;

}
