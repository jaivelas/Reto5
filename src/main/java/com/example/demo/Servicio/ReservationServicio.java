/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.CountClient;
import com.example.demo.Repositorio.ReservationRepositorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ReservationServicio {
     @Autowired
    private ReservationRepositorio reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean d=getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }

    ///////// reto 5 informes///////
    
    /* como ststus se divide en dos (canceladas y confirmadas), debo crear una clase adicional
    (Sstatus.java)  dentro de este paquete (servicio) para manejar estas variables*/
    
    public Status getReservationStatusReport(){
        List <Reservation> completed = reservationRepository.getReservationByStatus("completed");
        /* ("completed")...esto es lo que va a mostrar en el JSON */
        List <Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new Status (completed.size(), cancelled.size());
    /* este completed.size y canceleled.size son las dos vatiables
        definidas em Status */
    }
    

    public List<Reservation> informePeriodoTiempoReservas(String datoA, String datoB){
        /* traemos las fechas en un formato, aca las´'parceamos' (convertimos)
        a un formato que necesitamos para la consulta
        */   
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
          Date a = new Date();
          Date b = new Date();
          
          try {
              a = parser.parse(datoA);
              b = parser.parse(datoB);
          }catch(ParseException e){
              e.printStackTrace();
          }
          if(a.before(b)){
           return reservationRepository.informePeriodoTiempoReservas(a, b);
          }else{
              return new ArrayList<>();
          }
      }
      
      public List<CountClient> getTopClients(){
          return reservationRepository.getTopClient();
      }
/*este ya lo habiamso creado en el paquete de repositorios
      ... luego solo lo estamos mapiando*/
   
    
}
