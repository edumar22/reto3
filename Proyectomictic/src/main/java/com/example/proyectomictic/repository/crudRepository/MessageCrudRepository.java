package com.example.proyectomictic.repository.crudRepository;


import com.example.proyectomictic.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
