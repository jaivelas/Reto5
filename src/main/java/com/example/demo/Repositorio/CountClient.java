/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Client;

/**
 *
 * @author Jaime
 */
public class CountClient {
    
    private Long total;
    private Client client;

    
    /* ahora creamos este constructr para inicializar las variables*/
    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
    
    /* y ahora creamod los setter and getter*/
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }   
    
}



