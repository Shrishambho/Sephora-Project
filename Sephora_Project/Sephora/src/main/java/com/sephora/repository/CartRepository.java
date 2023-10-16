package com.sephora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sephora.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
