package com.inventory.catalog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inventory.catalog.bean.Product;
import com.inventory.catalog.bean.Seller;

@Repository
public class SellerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Seller> loadAll() {

		System.out.println("Seller Repository");
		return jdbcTemplate.query("select * from seller", new BeanPropertyRowMapper(Seller.class));
	}

}
