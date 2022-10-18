package com.example.proyectomictic.service;

import com.example.proyectomictic.entities.Client;
import com.example.proyectomictic.entities.ReportClient;
import com.example.proyectomictic.entities.Reservation;
import com.example.proyectomictic.entities.Status;
import com.example.proyectomictic.repository.ClientRepository;
import com.example.proyectomictic.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
        //return (List<Reservation>) reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {

        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation a) {
        if (a.getIdReservation() == null) {
            return reservationRepository.save(a);
        } else {
            Optional<Reservation> reservaGuardada = getReservation(a.getIdReservation());
            // Optional<Reservation> reservaEncontrado = reservationRepository.getReservation(a.getIdReservation());
            if (reservaGuardada.isEmpty()) {
                return reservationRepository.save(a);
            } else {
                return a;
            }
        }
    }

    public Reservation update(Reservation re) {
        if (re.getIdReservation() != null) {
            Optional<Reservation> reservaEncontrada = getReservation(re.getIdReservation());
            //Optional<Reservation> reservaEncontrada = reservationRepository.getReservation(re.getIdReservation());
            if (!reservaEncontrada.isEmpty()) {
                if (re.getStartDate() != null) {
                    reservaEncontrada.get().setStartDate(re.getStartDate());
                }
                if (re.getStatus() != null) {
                    reservaEncontrada.get().setStatus(re.getStatus());
                }
                if (re.getDevolutionDate() != null) {
                    reservaEncontrada.get().setDevolutionDate(re.getDevolutionDate());
                }
                return reservationRepository.save(reservaEncontrada.get());
            }
        }
        return re;
    }

    public boolean deleteReservation(int id) {
        boolean resultado = getReservation(id).map(reservationporeliminar -> {
            reservationRepository.delete(reservationporeliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

    public Optional<Reservation> getReservationId(int id) {

        return reservationRepository.getReservation(id);
    }
    //reto5

    public Status getStatus() {
        Status status = new Status();
        List<Reservation> reservations=reservationRepository.getAll();
        int contF=0;
        int contC=0;
        for(Reservation res:reservations){
            if(res.getStatus().equals("completed")){
                contF=contF+1;
            }else if(res.getStatus().equals("cancelled")){
                contC=contC+1;
            }
        }
        status.setCompleted(contF);
        status.setCancelled(contC);
        return status;
    }
    public List<ReportClient> getReportClient() {
        List<ReportClient> repoclient=new ArrayList<ReportClient>();
        List<Client> clients=clientRepository.getAll();
        int total=0;
        for(Client cli:clients){
            for(Reservation res:cli.getReservations()){
                total=total+1;
            }
            ReportClient reportclient= new ReportClient();
            reportclient.setTotal(total);
            reportclient.setClient(cli);
            repoclient.add(reportclient);
            total=0;
        }
        return repoclient;
    }
    public List<Reservation> getReportDates(Date date1, Date date2) {
        List<Reservation> reservations= reservationRepository.getAll();
        List<Reservation> reservationsDate =new ArrayList<Reservation>();
        for(Reservation res:reservations){
            if(date1.compareTo(res.getStartDate()) * res.getStartDate().compareTo(date2) >= 0){
                reservationsDate.add(res);
            }
        }
        return reservationsDate;
    }




}
//Reto 5
    /*
    public List<Reservation> getReservationsBetweenDatesReport(String fechaA,String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);

        }catch (ParseException exception){
            exception.printStackTrace();

        }
        if (a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a,b);
        }else {
            return new ArrayList<>();
        }

    }

public CompletedAndCancelled getReservationStatusReport() {
    List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
    List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

    int cantidadCompletadas = completed.size();
    int cantidadCacnceladas = cancelled.size();

    return new CompletedAndCancelled ((long) cantidadCompletadas, (long) cantidadCacnceladas);
}
public List<TotalAndClient> getTopClientsReport(){
        return reservationRepository.getTopClients();
}




}


     */





