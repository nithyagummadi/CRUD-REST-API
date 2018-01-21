package com.egen.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.entity.User;
import com.egen.exception.BadRequestException;
import com.egen.exception.NotFoundException;
import com.egen.repository.UserRepository;
import com.egen.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findUser(String id) {
		
		User exist=repository.findUser(id);
		if(exist==null) {
		throw new NotFoundException("The User with id "+id+" does not exist");
		}
		return exist;
	}

	@Override
	@Transactional
	public User create(User user) {
		User exist=repository.findByMail(user.getEmail());
		if(exist!=null) {
			throw new BadRequestException("The User with email "+user.getEmail()+" already exists");	
		}
		else
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User exist=repository.findUser(id);
		if(exist==null) {
			throw new NotFoundException("The User with id "+id+" does not exist");	
		}
		else
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User exist=repository.findUser(id);
		if(exist==null) {
			throw new NotFoundException("The User with id "+id+" does not exist");
		}
		repository.delete(exist);
	}

}
