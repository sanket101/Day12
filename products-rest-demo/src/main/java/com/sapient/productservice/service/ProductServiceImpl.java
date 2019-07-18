package com.sapient.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductServiceDao;
import com.sapient.productservice.model.Product;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier(value = "hibernateDAOImpl")
	private ProductServiceDao productServiceDao;
	
	public ProductServiceImpl(@Qualifier(value = "hibernateDAOImpl") ProductServiceDao productServiceDao) {
		this.productServiceDao = productServiceDao;
	}
	
	@Transactional
	 public Product saveProduct(Product product) {
		 System.out.println("Inside the save product method of Product service class ....");
	     return productServiceDao.save(product);
	 }
	
	@Transactional
	 public List<Product> fetchAllProduct() {
		 System.out.println("Inside the fetchAll product method of Product service class ....");
	     return productServiceDao.listAll();
	 }
	
	@Transactional
	 public Product findById(long id) {
		 System.out.println("Inside the findById method of Product service class ....");
	     return productServiceDao.findById(id);
	 }

	@Transactional
	 public void deleteProduct(long id) {
		 System.out.println("Inside the delete product method of Product service class ....");
		 productServiceDao.deleteProduct(id);
	 }
	 
	@Transactional
	 public void updateProduct(long id, Product p) {
		 System.out.println("Inside the update product method of Product service class ....");
		 productServiceDao.updateProduct(id, p);
	 }
}
