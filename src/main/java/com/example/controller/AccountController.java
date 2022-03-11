package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.AccountDTO;
import com.example.dto.AccountDTO3;
import com.example.dto.AccountDTO4;
import com.example.entity.Account;
import com.example.mapper.AccountMapper;
import com.example.repository.AccountRepository;

@Controller
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AccountMapper accountMapper;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("accountr", new AccountDTO4());
		model.addAttribute("jsp", "registration.jsp");
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("account", new AccountDTO());
		model.addAttribute("jsp", "login.jsp");
		return "home";
	}

	@PostMapping("/login")
	public String setLogin(Model model, @ModelAttribute(name = "account") AccountDTO accountDTO) {
		Account account = this.accountRepository.getByUsername(accountDTO.getUsername());
		if (account == null) {
			return "redirect:/login";
		} else if (accountDTO.getPassword().equals(account.getPassword())) {
			session.setAttribute("account", account);
			return "redirect:/products";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.removeAttribute("account");
		return "redirect:/home";
	}
	
	@GetMapping("/account/update")
	public String updateAccount(Model model) {
		Account account = (Account) session.getAttribute("account");
		Account account2 = this.accountRepository.getByUsername(account.getUsername());
		model.addAttribute("account", account2);
		model.addAttribute("jsp", "update.jsp");
		return "home";
	}
	
	@PostMapping("/account/update")
	public String updateAccountPost(@ModelAttribute("account") AccountDTO3 accountDTO3) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		accountDTO3.setId(id);
		Account account = this.accountMapper.convertToEntity(accountDTO3);
		this.accountRepository.save(account);
		System.out.println(account);
		return "redirect:/home";
	}
	
	@PostMapping("/registration")
	public String registrationPost(@Validated @ModelAttribute("accountr") AccountDTO4 accountDTO4, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("jsp", "registration.jsp");
			return "home";
		}else {
			Account account = this.accountMapper.convertToEntity2(accountDTO4);
			this.accountRepository.save(account);
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/forgot-password")
	public String forgotPassword(Model model) {
		
		model.addAttribute("jsp", "forgot_password.jsp");
		return "home";
	}
	
}
