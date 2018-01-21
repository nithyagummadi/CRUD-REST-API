package com.egen.service;

import java.util.List;


import com.egen.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findUser( String id);
	
	public User create( User user) ;
	
	public User update(String id, User user);
	
	public void delete( String id);

}
