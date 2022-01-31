package com.maybank.pms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maybank.pms.model.Product;

public class ProductDAOImpl implements ProductDAO {
	Configuration configuration = new Configuration().configure();			//hibernate.cfg.xml
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session ;
	@Override
	public boolean addProduct(Product product) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		return true;
	}
	@Override
	public boolean updateProduct(Product product) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
		return true;
	}
	@Override
	public boolean deleteProduct(int productId) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = new Product();
		product.setProductId(productId);
		session.delete(product);
		transaction.commit();
		session.close();
		return true;
	}
	@Override
	public boolean isProductExists(int productId) {
		session = sessionFactory.openSession();
		Product product = session.get(Product.class,productId );
		session.close();
		if(product == null)
			return false;
		else
			return true;
	}
	
	
	
	
	@Override
	public List<Product> viewProducts() {
	
		
		return null;
	}

	@Override
	public Product searchProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
