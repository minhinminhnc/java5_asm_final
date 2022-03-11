package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Account;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.example.util.CartUtil;

@Controller
public class CartController {
	@Autowired
	private CartUtil cart;
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@GetMapping("/cart")
	public String cart(Model model) {
		Map<Product, Integer> map = this.cart.getMap();
		model.addAttribute("map", map);
		model.addAttribute("jsp", "cart.jsp");
		model.addAttribute("total", cart.total());
		return "home";
	}
	
	@GetMapping("/cart/add")
	public String addCart(Model model, @RequestParam(name="id") Optional<Integer> id) {
		int idProduct = id.get();
		this.cart.add(idProduct);
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/remove")
	public String removeCart(Model model, @RequestParam(name="id") Optional<Integer> id) {
		int idProduct = id.get();
		this.cart.remove(idProduct);
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/clear")
	public String clearCart(Model model, @RequestParam(name="id") Optional<Integer> id) {
		int idProduct = id.get();
		this.cart.clear(idProduct);
		return "redirect:/cart";
	}
	
	@GetMapping(value="/cart/delete")
	public String deleteCart() {
		cart.delete();
		return "redirect:/cart";
	}
	
	@PostMapping("/cart/checkout")
	public String checkOut(HttpServletRequest request) {
		Account account = (Account)request.getSession().getAttribute("account");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		if(!StringUtils.hasText(phone) || !StringUtils.hasText(address)) {
			return "redirect:/cart";
		}else {
			Order order = new Order();
			order.setAccount(account);
			order.setAddress(address);
			order = orderRepository.save(order);
			Map<Product, Integer> map = this.cart.getMap();
			for(Map.Entry<Product, Integer> entry: map.entrySet()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(order);
				orderDetail.setPrice(entry.getKey().getPrice());
				orderDetail.setProduct(entry.getKey());
				orderDetail.setQuantity(entry.getValue());
				orderDetailRepository.save(orderDetail);
			}
			
			cart.setMap(new HashMap<Product, Integer>());
			
			return "redirect:/order";
		}
		
	}
	
}
