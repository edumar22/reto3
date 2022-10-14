package com.example.proyectomictic.service;


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

    public Optional<Category> getCategory(int id) {

        return categoryRepository.getCategory(id);
    }

    public List<Category> getAll() {

        return categoryRepository.getAll();
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if (!e.isEmpty()) {
                return categoryRepository.save(c);

            } else {
                return c;
            }
        }
    }

    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if (!e.isEmpty()) {
                if (c.getName() != null) {
                    e.get().setName(c.getName());

                }
                if(c.getDescription()!=null){
                    e.get().setDescription(c.getDescription());
                }

                return categoryRepository.save(e.get());
            }
        }

        return c;
    }



/*
    bikeRepository.save( bikeEncontrado.get());
                return bikeEncontrado.get();
            }else{
            return b;
        }
        }else{

        return b;
    }
    }
*/


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