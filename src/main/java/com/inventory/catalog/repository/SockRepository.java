package com.inventory.catalog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.inventory.catalog.bean.Brand;
import com.inventory.catalog.bean.Product;
import com.inventory.catalog.bean.Seller;
import com.inventory.catalog.repository.CapRepository.ProductRowMapper;

@Repository
public class SockRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	SellerRepository sellerRepository;
	
	Map<Integer, Brand> brandMap = new HashMap();
	Map<Integer, Seller> sellerMap = new HashMap();


	public List<Product> loadAll(Map<Integer, Brand> brandMap, Map<Integer, Seller> sellerMap) {

		System.out.println("Sock Repository");

		this.brandMap = brandMap;
		this.sellerMap = sellerMap;

		return jdbcTemplate.query("select * from cap", new ProductRowMapper());
	}

	public List<Product> loadAll() {

		System.out.println("Sock Repository");		

		brandRepository.loadAll().forEach(brand -> {
			brandMap.put(brand.getId(), brand);
		});

		sellerRepository.loadAll().forEach(seller -> {
			sellerMap.put(seller.getId(), seller);
		});

		return jdbcTemplate.query("select * from sock", new ProductRowMapper());
	}

	public class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

			Product product = new Product();
			product.setId(rs.getInt("ID"));
			product.setBrand(brandMap.get(rs.getInt("BRAND_ID")));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setType(rs.getString("TYPE"));
			product.setPrice(rs.getDouble("PRICE"));
			product.setColor(rs.getString("COLOR"));
			product.setSize(rs.getInt("SIZE"));
			product.setSku(rs.getInt("SKU"));
			product.setSeller(sellerMap.get(rs.getInt("SELLER_ID")));
			
			return product;

		}
	}

}
