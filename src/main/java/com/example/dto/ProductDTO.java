package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.entity.Category;

import lombok.Data;

@Data
public class ProductDTO {
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	private String name;
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	private String image;
	
	@NotNull(message = "Không được để trống")
	private Double price;
	
	@NotNull(message = "Không được để trống")
	private Integer quantity;
	
	@NotNull(message = "Không được để trống")
	private Category category;
}
