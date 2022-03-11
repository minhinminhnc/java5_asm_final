package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public String getProducts(Model model, @RequestParam(name="page")Optional<Integer> page) {
		int pages = page.orElse(1);
		Pageable pageable = PageRequest.of(pages - 1, 6);
		Page<Product> proPage = this.productRepository.findAll(pageable);
		model.addAttribute("page", proPage);
		model.addAttribute("navbar", "navbar.jsp");
		model.addAttribute("jsp", "products.jsp");
		return "home";
	}
	
	@GetMapping("/product/{id}")
	public String productDetail(@PathVariable(name="id") Product product, Model model) {
		model.addAttribute("navbar", "navbar.jsp");
		model.addAttribute("product", product);
		model.addAttribute("jsp", "product.jsp");
		return "home";
	}
	// 3 phương thức dưới có thể viết gọn trong 1 phương thức (thay vì truyền link cứng, mình có thể truyền param theo nhóm loai sp)
	@GetMapping("/products/bike")// Có thể truyền theo kiểu nhóm loại sản phẩm rồi truy vấn ra sản phẩm
	public String getProductBike(Model model, @RequestParam("category") Optional<Category> category) {

		Pageable pageable = PageRequest.of(0, 5);
		//category.id
		List<Product> list = this.productRepository.getByCategory(1, pageable);

		model.addAttribute("listProducts", list);
		return "product-bike";
	}

	@GetMapping("/products/electric-bicycle")// Có thể truyền theo kiểu nhóm loại sản phẩm rồi truy vấn ra sản phẩm
	public String getProductElectricBicycle(Model model, @RequestParam("category") Optional<Category> category) {

		Pageable pageable = PageRequest.of(0, 5);
		//category.id
		List<Product> list = this.productRepository.getByCategory(2, pageable);

		model.addAttribute("listProducts", list);
		return "product-electric-bicycle";
	}

	@GetMapping("/products/accessary")// Có thể truyền theo kiểu nhóm loại sản phẩm rồi truy vấn ra sản phẩm
	public String getProductAccessary(Model model, @RequestParam("category") Optional<Category> category) {

		Pageable pageable = PageRequest.of(0, 5);
		//category.id
		List<Product> list = this.productRepository.getByCategory(3, pageable);

		model.addAttribute("listProducts", list);
		return "product-accessary";
	}

}
