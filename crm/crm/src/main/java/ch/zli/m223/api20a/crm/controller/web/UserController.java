package ch.zli.m223.api20a.crm.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.zli.m223.api20a.crm.model.AppUser;
import ch.zli.m223.api20a.crm.service.UserService;

@Controller
@RequestMapping("/web/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("")
	public String getAllUsers(Model model) {
		
		List<AppUser> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "userList";
	}
}
