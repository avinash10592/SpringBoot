package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.Product;
import com.example.api.ProductRowMapper;

@Transactional
@Repository
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT pId, pName, price FROM product_details";
		RowMapper<Product> rowMapper = new ProductRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Product getProductById(int pId) {
		String sql = "SELECT pId, pName, price FROM product_details WHERE pId = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		Product article = jdbcTemplate.queryForObject(sql, rowMapper, pId);
		return article;
	}

	@Override
	public void addProduct(Product product) {
		// Add product
		String sql = "INSERT INTO product_details (pId, pName, price) values (?, ?, ?)";
		jdbcTemplate.update(sql, product.getpId(), product.getpName(), product.getPrice());

		// Fetch product id
		sql = "SELECT pId FROM product_details WHERE pName = ? and price=?";
		int pId = jdbcTemplate.queryForObject(sql, Integer.class, product.getpName(), product.getPrice());

		// Set product id
		product.setpId(pId);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE product_details SET pName=?, price=? WHERE pId=?";
		jdbcTemplate.update(sql, product.getpName(), product.getPrice(), product.getpId());
	}

	@Override
	public void deleteProduct(int pId) {
		String sql = "DELETE FROM product_details WHERE pId=?";
		jdbcTemplate.update(sql, pId);
	}

	@Override
	public boolean productExists(String pName, String price) {
		String sql = "SELECT count(*) FROM product_details WHERE pName = ? and price=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, pName, price);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

}
