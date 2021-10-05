package com.example.demo.layer3;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public BaseRepository() {
		System.out.println("BaseRepository()....");
	}
	
	@Transactional
	public void persist(Object obj) { //persist is a dummy/userdefined name
		
		try {
				entityManager.persist(obj);			
		} finally { entityManager.close(); }

	}
	
	@Transactional
	public <AnyClass> AnyClass find(Class<AnyClass> theClass, Serializable pk ) {
		AnyClass foundSavingsAccObj = null;
		try {			
			foundSavingsAccObj = entityManager.find(theClass, pk);	
		} finally { entityManager.close(); }
			return foundSavingsAccObj;
	}
	
	@Transactional
	public <E> List  findAll(String pojoName) {
		try {			
			Query query = entityManager.createQuery(" from "+ pojoName);
			return query.getResultList();
		} finally { entityManager.close(); }
	}
	
	@Transactional
	public void merge(Object obj) {

		try {
			entityManager.merge(obj); //<--real call for jdbc here		
		} finally { entityManager.close(); }
		
	}
	@Transactional
	public<AnyClass> void remove(Class<AnyClass> theClass, Serializable pk ) {
		try {
			AnyClass obj1=entityManager.find(theClass,pk);
			entityManager.remove(obj1);
			//<--this is the real call
		} finally { entityManager.close(); }
	}
	
	
	@Transactional
	public <E> Object findQuery(String whereQuery) {
		try {			
			Query query = entityManager.createQuery(" from "+ whereQuery);
			return query.getSingleResult();
		} finally { entityManager.close(); }
	}
	
	
	
	
	@Transactional
	public boolean isUserPresent(String emailId) {
		return (Long)
				entityManager
				.createQuery("select count(u.id) from AirUser u where u.emailId = :entityManager")
				.setParameter("em", emailId)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int findByEmailAndPassword(String emailId, String password) {
		return (Integer) entityManager
				.createQuery("select c.id from Customer c where c.email = :em and c.password = :pw")
				.setParameter("em", emailId)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
}
