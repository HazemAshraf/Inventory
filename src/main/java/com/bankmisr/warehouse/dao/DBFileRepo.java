package com.bankmisr.warehouse.dao;


import com.bankmisr.warehouse.entity.ItemPictures;
import com.bankmisr.warehouse.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepo extends JpaRepository<ItemPictures,Integer> {

    public ItemPictures findById(int id);
	
}
