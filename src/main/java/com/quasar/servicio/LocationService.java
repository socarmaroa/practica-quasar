/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.servicio;

import com.quasar.modelo.Coordenada;

/**
 *
 * @author so_ca
 */
interface LocationService {

    public Coordenada getLocation(double[][] coordenadas, double[] distancias) throws Exception;

}
