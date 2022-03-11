package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccountDTO2 {
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	private String username;
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	private String password;
}
