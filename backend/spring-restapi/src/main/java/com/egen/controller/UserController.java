package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.User;
import com.egen.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService service; 
	
	
	@RequestMapping(method= RequestMethod.GET)
	public List<User> findAll(){
		return service.findAll();
		}
	
	
	@RequestMapping(method= RequestMethod.GET, value="getuser/{id}")
	public User findUser(@PathVariable("id") String id) {
		return service.findUser(id);
	}
	
	
	@RequestMapping(method= RequestMethod.POST , value="/create")	
	public User create(@RequestBody User user) {
		User u= new User();
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setEmail(user.getEmail());
		u.setCity(user.getCity());
		return service.create(u);
	}
	
	
	@RequestMapping(method= RequestMethod.PUT, value="/update/{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}
	
	
	@RequestMapping(method= RequestMethod.DELETE, value="/delete/{id}" )
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
}
