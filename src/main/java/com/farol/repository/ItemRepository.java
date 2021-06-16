package com.farol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farol.models.Item;


	public interface ItemRepository extends JpaRepository<Item, Long>{
		Item findById(long id);

	}
