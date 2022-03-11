package com.example.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;

@Controller
public class ProductAdController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@GetMapping("/admin/products")
	public String products(Model model) {
		List<Product> listProducts = this.productRepository.findAll();
		model.addAttribute("listProducts", listProducts);
		return "admin/products";
	}
	
	@GetMapping(value="/admin/product/edit", params="id")
	public String editProduct(Model model) {
		Integer id = Integer.parseInt(this.request.getParameter("id"));
		Product product = this.productRepository.getById(id);
		model.addAttribute("product", product);
		return "admin/edit";
	}
	
	@PostMapping(value="/admin/product/update", params="id")
	public String updateProduct(@ModelAttribute("id") Product product) {
		this.productRepository.save(product);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/create")
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("category", this.categoryRepository.findAll());
		return "admin/create";
	}
	
	@PostMapping("/admin/product/create")
	public String createProductPost(@Validated @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("product", productDTO);
			model.addAttribute("category", this.categoryRepository.findAll());
			return "admin/create";
		}else {
			Product product = this.productMapper.convertToEntity(productDTO);
			this.productRepository.save(product);
			return "redirect:/admin/products";
		}
		
	}
	
	@GetMapping(value="/admin/product/delete", params="id")
	public String deleteProduct(@RequestParam("id") Product product) {
		product.setStatus(false);
		this.productRepository.save(product);
		return "redirect:/admin/products";
	}
}
