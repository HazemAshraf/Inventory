package com.bankmisr.warehouse.dao;


import com.bankmisr.warehouse.entity.Category;
import com.bankmisr.warehouse.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    public Category findById(int id);
	
}
