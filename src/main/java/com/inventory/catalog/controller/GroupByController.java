package com.inventory.catalog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.catalog.bean.Brand;
import com.inventory.catalog.bean.Product;
import com.inventory.catalog.bean.Seller;
import com.inventory.catalog.repository.BrandRepository;
import com.inventory.catalog.repository.CapRepository;
import com.inventory.catalog.repository.PantRepository;
import com.inventory.catalog.repository.SellerRepository;
import com.inventory.catalog.repository.ShirtRepository;
import com.inventory.catalog.repository.SockRepository;

@Controller
public class GroupByController {

	@Autowired
	ShirtRepository shirtRepository;

	@Autowired
	PantRepository pantRepository;

	@Autowired
	SockRepository sockRepository;

	@Autowired
	CapRepository capRepository;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	SellerRepository sellerRepository;

	@RequestMapping("/groupByBrand")
	public String groupByBrand(Model model) {

		List<Product> responseStr = loadAllProducts();
		
		Map<String, Long> mapGroupByBrand = responseStr.stream().collect(Collectors.groupingBy(obj -> obj.getBrand().getBrandName(), Collectors.counting()));
		
		model.addAttribute("type", "groupByBrand");

		model.addAttribute("groupBy", mapGroupByBrand);

		return "display";
	}

	@RequestMapping("/groupByPrice")
	public String groupByPrice(Model model) {

		List<Product> responseStr = loadAllProducts();
		
		Map<Double, Long> mapGroupByPrice = responseStr.stream().collect(Collectors.groupingBy(obj -> obj.getPrice(), Collectors.counting()));
		
		model.addAttribute("type", "groupByPrice");

		model.addAttribute("groupBy", mapGroupByPrice);

		return "display";
	}
	
	@RequestMapping("/groupByColor")
	public String groupByColor(Model model) {

		List<Product> responseStr = loadAllProducts();
		
		Map<String, Long> mapGroupByColor = responseStr.stream().collect(Collectors.groupingBy(obj -> obj.getColor(), Collectors.counting()));
		
		model.addAttribute("type", "groupByColor");

		model.addAttribute("groupBy", mapGroupByColor);

		return "display";
	}
	
	@RequestMapping("/groupBySize")
	public String groupBySize(Model model) {

		List<Product> responseStr = loadAllProducts();
		
		Map<Integer, Long> mapGroupBySize =  responseStr.stream().collect(Collectors.groupingBy(obj -> obj.getSize(), Collectors.counting()));
		
		model.addAttribute("type", "groupBySize");

		model.addAttribute("groupBy", mapGroupBySize);

		return "display";
	}

	//Stock Keeping Unit
	@RequestMapping("/getBySku")
	public String getBySku(Model model) {

		List<Product> responseStr = loadAllProducts();
		
		Map<Integer, Long> mapGetBySku =  responseStr.stream().collect(Collectors.groupingBy(obj -> obj.getSku(), Collectors.counting()));
		
		model.addAttribute("type", "getBySku");

		model.addAttribute("groupBy", mapGetBySku);

		return "display";
	}
	
	private List<Product> loadAllProducts() {
		
		List<Product> responseStr = new ArrayList();
		
		Map<Integer, Brand> brandMap = new HashMap();
		Map<Integer, Seller> sellerMap = new HashMap();

		
		brandRepository.loadAll().forEach(brand -> {
			brandMap.put(brand.getId(), brand);
		});

		sellerRepository.loadAll().forEach(seller -> {
			sellerMap.put(seller.getId(), seller);
		});


		shirtRepository.loadAll(brandMap, sellerMap).forEach(shirt -> {
			responseStr.add(shirt);
		});

		pantRepository.loadAll(brandMap, sellerMap).forEach(pant -> {
			responseStr.add(pant);
		});

		sockRepository.loadAll(brandMap, sellerMap).forEach(sock -> {
			responseStr.add(sock);
		});

		capRepository.loadAll(brandMap, sellerMap).forEach(cap -> {
			responseStr.add(cap);
		});

		
		return responseStr;
	}

}
