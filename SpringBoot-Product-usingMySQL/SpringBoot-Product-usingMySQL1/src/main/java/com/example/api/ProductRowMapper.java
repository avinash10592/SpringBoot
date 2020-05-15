package com.example.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet row, int rowNum) throws SQLException {
		Product product = new Product();
		product.setpId(row.getInt("pId"));
		product.setpName(row.getString("pName"));
		product.setPrice(row.getString("price"));
		return product;
	}
}

