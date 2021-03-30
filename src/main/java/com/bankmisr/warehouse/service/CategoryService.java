package com.bankmisr.warehouse.service;

import com.bankmisr.warehouse.dao.CategoryRepo;
import com.bankmisr.warehouse.entity.Category;
import com.bankmisr.warehouse.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ItemRepo itemRepo;
    CategoryService(CategoryRepo categoryRepo,ItemRepo itemRepo){
        this.categoryRepo = categoryRepo;
        this.itemRepo = itemRepo;
    }
    //find All
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    //find by id
    public Category findById(int id){return categoryRepo.findById(id);};
    //save
    public Category save(Category category) {
        return categoryRepo.save(category);
    }
    //delete
    public void delete(Category category){categoryRepo.delete(category);}
    //deleteById
    public void deleteById(int id){
        List<Items> itemsList = new ArrayList<Items>();
        itemsList = itemRepo.findAll();
        if(itemsList != null) {
            for (Items item : itemsList) {
                if(item.getCategoryId() != null) {
                    if (item.getCategoryId().getId() == id) {
                        item.setCategoryId(null);
                        itemRepo.save(item);
                    }
                }
            }
        }
        else{
            throw new RuntimeException("there are no items - ");
        }
        categoryRepo.deleteById(id);
    }

}
