package com.example.proyectomictic.repository.crudRepository;


import com.example.proyectomictic.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
