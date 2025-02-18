package com.jsp.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.entities.Hotel;
import com.jsp.hotelmanagementsystem.entities.Item;
import com.jsp.hotelmanagementsystem.entities.Product;

@Repository
public class ItemDao {

	 @Autowired
		EntityManagerFactory emf ;
		
		@Autowired
		EntityManager em;
		
		@Autowired
		EntityTransaction et;
		
		public void saveItem(Item item) {
	 
			et.begin();
			em.persist(item);
			et.commit();
		}
		
		public  Item findById(int id) {
			return em.find(Item.class, id);
			
		}
		
		public void updateItem(Item item) {
			et.begin();
			em.merge(item);
			et.commit();
		}
		
		public void deleteById(int id) {
			et.begin();
			em.remove(em.find(Item.class, id));
			et.commit();
		}
		
		
		public List<Product> fetchProductsByHotel(String hotelName){
			Query query = em.createQuery("select h from Hotel h where h.name=?1");
			query.setParameter(1, hotelName);
			
			Hotel hotel = (Hotel) query.getSingleResult();
			return hotel.getProducts();
			}
}
