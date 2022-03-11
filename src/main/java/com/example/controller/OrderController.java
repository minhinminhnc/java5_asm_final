package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Account;
import com.example.entity.Order;
import com.example.entity.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/order")
	public String order(Model model) {
		Account account = (Account)httpSession.getAttribute("account");
		List<Order> list = orderRepository.findByAccount(account.getId());
		
		model.addAttribute("list", list);
		model.addAttribute("jsp", "order.jsp");
		return "home";
	}
	
	@GetMapping("/order/detail")
	public String detail(Model model, @RequestParam("id") Optional<Integer> id) {
		int order_id = id.get();
		List<OrderDetail> list = orderDetailRepository.findByOrder(order_id);
		model.addAttribute("list", list);
		model.addAttribute("jsp", "detail.jsp");
		return "home";
	}
}
