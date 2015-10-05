package com.haier.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haier.pojo.User;
import com.haier.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	/**
	 * 测试
	 * <pre>
	 *     请求地址：http://localhost:8080/user/showUser?id=1
	 * </pre>
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	/**
	 * 测试
	 * <pre>
	 *     请求地址：http://localhost:8080/user/test
	 * </pre>
	 * @return
	 */
	@RequestMapping(value="/test")
	@ResponseBody
	public Object test() {
		User user = new User();
		user.setUserName("Paul");
		user.setPassword("888");
		user.setAge(26);
		return user;
	}
}
