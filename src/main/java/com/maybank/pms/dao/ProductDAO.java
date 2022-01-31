package com.maybank.pms.dao;

import java.util.List;

import com.maybank.pms.model.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productId);
	public List<Product> viewProducts();
	public Product searchProductById(int productId);
	public List<Product> searchProductByName(String productName);
	public boolean isProductExists(int productId);

	
}
