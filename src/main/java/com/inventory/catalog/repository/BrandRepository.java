package com.inventory.catalog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inventory.catalog.bean.Brand;
import com.inventory.catalog.bean.Product;

@Repository
public class BrandRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Brand> loadAll() {

		System.out.println("Brand Repository");
		return jdbcTemplate.query("select * from brand", new BeanPropertyRowMapper(Brand.class));
	}

}
