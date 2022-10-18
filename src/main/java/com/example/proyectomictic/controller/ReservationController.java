package com.example.proyectomictic.controller;

import com.example.proyectomictic.entities.DTOs.CompletedAndCancelled;
import com.example.proyectomictic.entities.DTOs.TotalAndClient;
import com.example.proyectomictic.entities.ReportClient;
import com.example.proyectomictic.entities.Reservation;
import com.example.proyectomictic.entities.Status;
import com.example.proyectomictic.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    /*
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

     */
    // /api/Reservation/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Reservation save(@RequestBody Reservation r){

        return  reservationService.save(r);
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


    //reto5
    @GetMapping("/report-status")
    public Status getStatus(){

        return reservationService.getStatus();
    }
    @GetMapping("/report-clients")
    public List<ReportClient> getReportClient(){

        return reservationService.getReportClient();
    }

    @GetMapping("/report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReportdate(@PathVariable String startDate,@PathVariable String devolutionDate) {
        Date date1= new Date();
        Date date2= new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            date2=new SimpleDateFormat("yyyy-MM-dd").parse(devolutionDate);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservationService.getReportDates(date1,date2);
    }





    /*
    @GetMapping("/report-dates/{fecha1}/{feche2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1")String fecha1,@PathVariable("fecha2")String feche2){
        return  reservationService.getReservationsBetweenDatesReport(fecha1,feche2);
    }
    @GetMapping ( "/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        return reservationService.getReservationStatusReport();

    }
    @GetMapping("/report-client")
    public List<TotalAndClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }

     */
}
