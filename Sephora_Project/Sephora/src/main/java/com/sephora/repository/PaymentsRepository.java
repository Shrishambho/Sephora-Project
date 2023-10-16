package com.sephora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sephora.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

	
}
