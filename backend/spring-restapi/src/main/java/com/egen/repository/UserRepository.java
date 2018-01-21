package com.egen.repository;

import java.util.List;

import com.egen.entity.User;

public interface UserRepository {
	
public List<User> findAll();
	
	public User findUser( String id);
	
	public User findByMail( String email);
	
	public User create( User user) ;
	
	public User update( User user);
	
	public void delete( User user);

}
