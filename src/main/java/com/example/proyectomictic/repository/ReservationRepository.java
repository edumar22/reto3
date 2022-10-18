package com.example.proyectomictic.repository;

import com.example.proyectomictic.entities.Client;
import com.example.proyectomictic.entities.DTOs.TotalAndClient;
import com.example.proyectomictic.entities.Reservation;
import com.example.proyectomictic.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.*;


@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){

        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation r){

        return  reservationCrudRepository.save(r);
    }
    public  void delete (Reservation r){
        reservationCrudRepository.delete(r);
    }

    //Reto 5


    /*
    public List<Reservation>getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA,fechaB);
    }
    public List<Reservation>getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.getTotalReservationsByClient();
        for (int i = 0; i<reporte.size();i++){
            //casteo
            respuesta.add(new TotalAndClient( (Long) reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

     */
}
