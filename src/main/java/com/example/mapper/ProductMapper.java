package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDTO;
import com.example.entity.Product;

@Service
public class ProductMapper {
	@Autowired
	private ModelMapper mapper;
	
	public Product convertToEntity(ProductDTO productDTO) {
		Product entity = mapper.map(productDTO, Product.class);
		
		return entity;
	}
	
	public ProductDTO convertToDTO(Product entity) {
		ProductDTO accountDTO = mapper.map(entity, ProductDTO.class);
		
		return accountDTO;
	}
}
