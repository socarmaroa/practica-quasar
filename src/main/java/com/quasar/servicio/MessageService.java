/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.servicio;

import com.quasar.modelo.Satelite;
import java.util.Collection;

/**
 *
 * @author so_ca
 */
interface MessageService {

    public String getMessage(Collection<Satelite> satellites)throws Exception ;

    
}
