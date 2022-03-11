package com.example.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

import lombok.Data;

@Service
@SessionScope
@Data
public class CartUtil {
	
	@Autowired
	private ProductRepository productRepository;
	
	private Map<Product, Integer> map = new HashMap<Product, Integer>();
	
	private List<Product> list = new ArrayList<Product>();
	
	public void add(Integer id) {
		Product product = this.productRepository.findById(id).get();
		boolean flag = false;
		for (Map.Entry<Product, Integer> entry : map.entrySet()) {
			if(entry.getKey().getId() == id) {
				flag = true;
			}
		}
		if(!flag) {
			map.put(product, 1);
		}else {
			for(Map.Entry<Product, Integer> entry: map.entrySet()) {
				if(entry.getKey().getId() == id) {
					entry.setValue(entry.getValue() + 1);
				}
			}
		}
	}
	
	public void remove(Integer id) {
		Product product = null;
		for(Map.Entry<Product, Integer> entry: map.entrySet()) {
			if(entry.getKey().getId() == id) {
				if(entry.getValue() == 1) {
					product = entry.getKey();				
				}else {
					entry.setValue(entry.getValue() - 1);
				}
			}
		}
		if(product != null) {
			map.remove(product);
		}
	}
	
	public void delete() {
		map = new HashMap<Product, Integer>();
	}
	
	
	public void clear(Integer id) {
		Product product = null;
		for(Map.Entry<Product, Integer> entry: map.entrySet()) {
			if(entry.getKey().getId() == id) {				
					product = entry.getKey();				
			}
		}
		map.remove(product);
	}
	
	
	public double total() {
		double total = 0.0;
		for(Map.Entry<Product, Integer> entry: map.entrySet()) {
			total += (entry.getKey().getPrice() * entry.getValue());
		}
		return total;
	}
	
}
