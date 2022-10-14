package com.example.proyectomictic.repository;

import com.example.proyectomictic.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.proyectomictic.repository.crudRepository.CategoryCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){

        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id){

        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c){

        return categoryCrudRepository.save(c);
    }

    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }



}

