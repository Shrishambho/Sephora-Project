package com.sephora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sephora.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByCustomerCustomerId(Integer customerId);
}
