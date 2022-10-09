/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository

public class ReservationRepositorio {

    @Autowired
    private ReservationInterface reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

/*///////////////// Reto 5 informe//////////*/
/* recordemos que el repositorio lo usamos para hacer la conexion entre
    la interface y el servicio
*/ 
    
public List<Reservation> getReservationByStatus (String status){
    return reservationCrudRepository.findAllByStatus(status);
}
    
public List<Reservation> informePeriodoTiempoReservas (Date a, Date b){
    return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
}

public List<CountClient> getTopClient(){
    List<CountClient> res = new ArrayList<>();/*convertimos la lista en un arraylist*/
    List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
    /* debemos iterar por la tabla para encontral las repeticiones
    y el cliente. para eso creamos una nueva clase CountClient dentro del mismo paquete
    */
    for(int i=0;i < report.size();i++){
        res.add(new CountClient((Long)report.get(i)[1], (Client) report.get(i)[0]));
    }
    return res;
    }

}




