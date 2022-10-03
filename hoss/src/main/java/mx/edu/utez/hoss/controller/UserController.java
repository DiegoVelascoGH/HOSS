package mx.edu.utez.hoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.hoss.entity.Role;
import mx.edu.utez.hoss.entity.Status;
import mx.edu.utez.hoss.entity.User;
import mx.edu.utez.hoss.service.RoleService;
import mx.edu.utez.hoss.service.StatusService;
import mx.edu.utez.hoss.service.UserService;

@RestController
@RequestMapping("/hoss")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/users")
	public List<User> list() {
		return userService.getAll();
	}
	
	@GetMapping("/users/{id}")
	public User edit(@PathVariable("id") long id) {
		return userService.getOne(id);
	}
	
	@PostMapping("/users")
	public User save(@RequestBody User user) {
		return userService.saveOrUpdate(user);
	}
	
	@PutMapping("/users")
	public User update(@RequestBody User user) {
		Role role = roleService.getOne(user.getRole().getId());
		Status status = statusService.getOne(user.getStatus().getId());
		user.setRole(role);
		user.setStatus(status);
		return userService.saveOrUpdate(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable("id") long id) {
		userService.remove(id);
	}
	
}
