package com.sephora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sephora.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,PagingAndSortingRepository<Product, Integer> {

}
