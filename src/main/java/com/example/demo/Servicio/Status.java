/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

/**
 *
 * @author Jaime
 */
public class Status {

    private int completed;
    private int cancelled;

    /* creamos el constructor para inicialisar las dos variables*/
    public Status(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    /* creamos los setter and getter*/
    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
    


    
}
