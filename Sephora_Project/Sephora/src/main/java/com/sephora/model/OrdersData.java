package com.sephora.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class OrdersData {

	private LocalDate date;
	
	private List<Integer> list;
}
