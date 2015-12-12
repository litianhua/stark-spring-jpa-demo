package com.stark.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stark.demo.entitys.User;
import com.stark.demo.service.UserService;
import com.stark.demo.specifications.UserSpecs;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 新增用户，并返回新增之后的用户信息页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addUser.do")
	public String addUser(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception{
		String name = request.getParameter("name");
		String pwd =request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user = this.userService.saveVo(user);
		model.addAttribute("user", user);
		return "/WEB-INF/jsp/result";
	}
	
	/**
	 * 根据id获取用户信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getUser.do")
	public Object loadUser(HttpServletRequest request) throws Exception{
		String id = request.getParameter("id");
		User user = this.userService.loadVo(id);
		return user;
	}
	
	/**
	 * 获取指定条件的用户列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/userlist.do")
	public Object userList(HttpServletRequest request) throws Exception{
		//获取参数
		String _key = request.getParameter("key");
		//创建存放参数的Map
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//存放参数
		if(_key != null && _key.trim() != ""){
			paramMap.put("key", _key);
		}
		//查询数据
		List<User> userList = this.userService.findList(UserSpecs.setQuery(paramMap));
		return userList;
	}
	
}
