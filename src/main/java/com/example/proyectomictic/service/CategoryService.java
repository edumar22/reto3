package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Admin;
import com.example.proyectomictic.entities.Bike;
import com.example.proyectomictic.entities.Category;
import com.example.proyectomictic.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.getAll();
       // return (List<Category>)categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }
    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> categoryGuardada = getCategory(c.getId());
            //Optional<Category> categoryGuardada = categoryRepository.getCategory(c.getId());
            if (!categoryGuardada.isEmpty()) {
                return categoryRepository.save(c);

            } else {
                return c;
            }
        }
    }


    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> categoryEncontrada = getCategory(c.getId());
            //Optional<Category> categoryEncontrada = categoryRepository.getCategory(c.getId());
            if (!categoryEncontrada.isEmpty()) {
                if (c.getName() != null) {
                    categoryEncontrada.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    categoryEncontrada.get().setDescription(c.getDescription());
                }

                return categoryRepository.save(categoryEncontrada.get());
            }
        }
        return c;
    }

public boolean deleteCategory(int id){
        boolean resultado = getCategory(id).map(categoryporEliminar ->{
            categoryRepository.delete(categoryporEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }
    public Optional<Category> getCategoryId(int id){
        return categoryRepository.getCategory(id);}


}
/*
    public boolean delete(int categoryId) {
        Boolean resultado = getCategory(categoryId).map(categoryPorEliminar -> {
            categoryRepository.delete(categoryPorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

 */