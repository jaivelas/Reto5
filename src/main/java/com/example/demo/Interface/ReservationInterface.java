/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Interface;

import com.example.demo.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface ReservationInterface extends CrudRepository <Reservation, Integer> {
 
  
    
public List<Reservation> findAllByStatus(String Status);
/* querry que busca todo por status en la tabla
retorna una lista de entidad reservaciones
fijese que status esta defrinido dentro de reservaciones
como un atributo en la parte de modelo.*/
   
public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date datoUno, Date datodos);
/* querry que busque todo despues de y antes de*/
    
@Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
public List<Object[]> countTotalReservationByClient();

/* anotacion para query metodo nativo (en lenguage de la base de atos)
sin embargo este uso NO ES CONSIDERADO  UNA BUENA PRACTICA
public List<Object()> countTotalReservationByCliet();*/
    
}

    
    
    
    
    
    

