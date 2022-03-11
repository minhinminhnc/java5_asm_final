package com.example.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.AccountDTO2;
import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Controller
public class AdminController {

	@Autowired
	private HttpSession session;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/admin/login")
	public String loginAdmin(Model model) {
		model.addAttribute("account", new AccountDTO2());
		return "admin/login";
	}

	@PostMapping("/admin/login")
	public String admin(@Validated @ModelAttribute("account") AccountDTO2 accountDTO2, BindingResult result,
			Model model) {
		Account account = this.accountRepository.getByUsername(accountDTO2.getUsername());
		if (result.hasErrors()) {
			return "admin/login";
		} else {
			if (account == null) {
				model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
				model.addAttribute("account", accountDTO2);
				System.out.println(1);
				return "admin/login";
			} else {
				if (account.getPassword().equals(accountDTO2.getPassword())) {
					if (account.getRole() == false) {
						model.addAttribute("message", "Đây không phải là tài khoản của admin");
						System.out.println(2);
						return "redirect:/admin/login";
					} else {
						session.setAttribute("account", account);
						System.out.println(3);
						return "redirect:/admin/products";
					}
				} else {
					model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
					model.addAttribute("account", accountDTO2);
					System.out.println(4);
					return "admin/login";
				}
			}
		}

	}

}
