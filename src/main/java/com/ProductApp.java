package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.maybank.pms.dao.ProductDAO;
import com.maybank.pms.dao.ProductDAOImpl;
import com.maybank.pms.model.Product;

public class ProductApp {

	Scanner scanner = new Scanner(System.in);
	ProductDAO productDAO = new ProductDAOImpl();
	boolean result;
	List<Product> products = new ArrayList<Product>();

	public void startProductApp() {

		while (true) {
			System.out.println("M E N U ");
			System.out.println("1. Add Product ");
			System.out.println("2. Delete Product ");
			System.out.println("3. Update Product ");
			System.out.println("4. View All Products ");
			System.out.println("5. Search Product By Id ");
			System.out.println("6. Search Product By name ");
			System.out.println("9. E X I T");

			System.out.println("Enter your choice (1-9)");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Please enter the product to save in db :");
				System.out.println("Enter product id :");
				int productId = scanner.nextInt();
				System.out.println("Enter product name :");
				String productName = scanner.next();
				System.out.println("Enter quantity on hand :");
				int quantityOnHand = scanner.nextInt();
				System.out.println("Enter price  :");
				int price = scanner.nextInt();

				Product product = new Product(productId, productName, quantityOnHand, price);
				if (productDAO.isProductExists(productId)) {
					System.out.println("Product already exists , try with different id -- " + productId);
				} else {
					result = productDAO.addProduct(product);
					if (result) {
						System.out.println("Product added successfully");
					} else {
						System.out.println("Product not added successfully");

					}
				}

				break;
			case 2:
				System.out.println("Please enter the product to delete in db :");
				System.out.println("Enter product id :");
				productId = scanner.nextInt();

				if (productDAO.isProductExists(productId)) {
					System.out.println("Product  exists ,deleted -- " + productId);
					result = productDAO.deleteProduct(productId);
					if (result) {
						System.out.println("Product deleted successfully");
					} else {
						System.out.println("Product not deleted successfully");

					}
				} else {

				}
				break;
			case 3:
				System.out.println("Please enter the product to update in db :");
				System.out.println("Enter old product id :");
				productId = scanner.nextInt();
				System.out.println("Enter new product name :");
				productName = scanner.next();
				System.out.println("Enter new quantity on hand :");
				quantityOnHand = scanner.nextInt();
				System.out.println("Enter new price  :");
				price = scanner.nextInt();

				Product productUpdate = new Product(productId, productName, quantityOnHand, price);
				if (productDAO.isProductExists(productId)) {
					result = productDAO.updateProduct(productUpdate);
					if (result) {
						System.out.println("Product updated successfully");
					} else {
						System.out.println("Product not updated successfully");

					}
				} else {

				}
				break;
			case 4:
				products = productDAO.viewProducts();
				System.out.println("List of all the products :");
				System.out.println(products);
				break;
			case 5:
				break;
			case 6:
				break;
			case 9:
				System.out.println("Thanks for using my app");
				System.exit(0);
				break;
			}

		}
	}
}
