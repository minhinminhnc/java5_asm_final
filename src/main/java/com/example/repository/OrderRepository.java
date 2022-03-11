package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("select o from Order o where o.account.id = ?1")
	public List<Order> findByAccount(Integer id);
}
