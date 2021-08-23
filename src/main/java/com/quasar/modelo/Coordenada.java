/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.modelo;

/**
 *
 * Clase para representar la posicion en el espacio por medio de dos coordenadas
 * la X y la Y.
 *
 * @author so_ca
 */
public class Coordenada {

    /**
     * Coordenada x
     */
    private double x;

    /**
     * Coordenada y
     */
    private double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coordenada getCoordenada(double[] valores) {
        return new Coordenada(valores[0], valores[1]);
    }

    public double[] arrayCoordenadas() {
        double[] f = {x, y};
        return f;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

}
