package com.egen.repository.imp;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.egen.entity.User;
import com.egen.repository.UserRepository;

@Repository
public class UserRepositoryImp implements UserRepository {
    
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query= em.createNamedQuery("user.findAll", User.class);
		
		return query.getResultList();
	}

	@Override
	public User findByMail(String email) {
TypedQuery<User> query= em.createNamedQuery("user.findByMail", User.class);
query.setParameter("pEmail",email);
		List<User> users=query.getResultList();
		if(!users.isEmpty()) {
			return users.get(0);
		}
		else
			return null;
	}
	
	@Override
	public User findUser(String id) {
		
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
		
		em.persist(user);
		return user;
	}

	@Override
	public User update( User user) {
		
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
		
	}

	

}
