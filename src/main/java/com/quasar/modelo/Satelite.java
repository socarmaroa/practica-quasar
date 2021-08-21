/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.modelo;

import java.util.List;

/**
 * Clase que describe el satelite
 *
 * @author so_ca
 */
public class Satelite {

    /**
     * Nombre del satelite
     */
    private String name;

    /**
     * Distancia al emisor
     */
    private float distance;

    /**
     * Mensaje generado por el emisor
     */
    private List<String> message;

    /**
     * Ubicación del satelite
     */
    private Coordenada coordenada;

    /**
     * @return el name del satelite
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el name del satelite.
     *
     * @param name nuevo name del satelite
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Conseguir la distance del emisor
     *
     * @return el valor de la distance del emisor
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Cambia la distance del emisor
     *
     * @param distance nuevo valor de la distance
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * Muesta los message del emisor
     *
     * @return un mensaje como una colección de cadenas de caracteres.
     */
    public List<String> getMessage() {
        return message;
    }

    /**
     * Cambiar el mensaje
     *
     * @param message nuevo valor para los message
     */
    public void setMessage(List<String> message) {
        this.message = message;
    }

    /**
     * Buscar la posición del satelite
     *
     * @return la posición del satelite
     */
    public Coordenada getCoordenada() {
        return coordenada;
    }

    /**
     * Cambiar la posicion del satelite
     *
     * @param coordenada posición nueva
     */
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    
    public Coordenada getLocation(float distances){
        return new Coordenada(0f,3f);
    }
    
    public String getMessage(String[] messages){
        return "mesage";
    }

    @Override
    public String toString() {
        try {
            return "Satelite " + name + ", Coordenadas(" + coordenada.getX() + "," + coordenada.getY() + ")";
        } catch (Exception e) {
            return "Satelite -> " + name + " sin Coordenadas";
        }
    }

}
