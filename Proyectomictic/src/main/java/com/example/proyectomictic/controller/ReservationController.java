package com.example.proyectomictic.controller;

import com.example.proyectomictic.entities.Reservation;
import com.example.proyectomictic.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    // /api/Reservation/all
    @GetMapping("/all")
    public List<Reservation> getAll(){

        return reservationService.getAll();
    }
    // /api/Reservation/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Reservation save(@RequestBody Reservation r){

        return  reservationService.save(r);
    }

    @GetMapping("/{id}")
  //  @ResponseStatus(HttpStatus.CREATED)
    public Optional<Reservation> getClient(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
      // /api/Reservation/update
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Reservation update(@RequestBody Reservation r){

        return  reservationService.update(r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);}
}
