package com.example.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="create_date")
	private LocalDate createDate = LocalDate.now();
	
	@Column(name="address")
	private String address;
	
	@ManyToOne()
	@JoinColumn(
		name="account_id",
		referencedColumnName = "id"
	)
	private Account account;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> listOrderDetail;
}
