/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.servicio;

import com.quasar.modelo.Coordenada;
import com.quasar.modelo.Satelite;
import java.util.Collection;

/**
 *
 * @author so_ca
 */
class QuasarServiceGeneral {

    private Satelite kenobi;

    private Satelite skywalker;

    private Satelite sato;

    private final String KENOBI = "Kenobi";

    private final String SKYWALKER = "Skywalker";

    private final String SATO = "Sato";

    public QuasarServiceGeneral() {
        reinicio();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuasarServiceGeneral agenteQuasar = new QuasarServiceGeneral();
        try {
            System.out.println(agenteQuasar.kenobi);
            System.out.println(agenteQuasar.skywalker);
            System.out.println(agenteQuasar.sato);
        } catch (Exception e) {
            System.out.println("Error al iniciar");
        }
//        double[][] positions = {{-500d, -200d}, {100d, -100d}, {500d, 100d}, {501d, 110d}};
//        double[] distances = {100d, 115.5d, 142.7d, 140d};
//        try {
//            double[] posFind = agenteQuasar.getLocation(positions, distances);
//            System.out.println(posFind[0] + "," + posFind[1]);
//        } catch (Exception e) {
//            System.out.println("Error " + e.getMessage());
//        }
    }

    private void reinicio() {
        kenobi = crearSatelite(KENOBI, new Coordenada(-500f, -200));
        skywalker = crearSatelite(SKYWALKER, new Coordenada(100f, -100f));
        sato = crearSatelite(SATO, new Coordenada(500f, 100f));
    }

    private Satelite buscarSatelite(String nombre) {
        if (nombre.equalsIgnoreCase(KENOBI)) {
            return kenobi;
        }
        if (nombre.equalsIgnoreCase(SKYWALKER)) {
            return skywalker;
        }
        if (nombre.equalsIgnoreCase(SATO)) {
            return sato;
        }
        return null;
    }

    /**
     * @return the sato
     */
    private Satelite crearSatelite(String nombre, Coordenada coor) {
        Satelite temp = new Satelite();
        temp.setName(nombre);
        temp.setCoordenada(coor);
        return temp;
    }

    protected boolean sonSatelitesValidos(Collection<Satelite> satellites) throws Exception {
        if (satellites == null) {
            throw new Exception("No hay información de satelites para evaluar");
        }
        for (Satelite item : satellites) {
            if (!esSateliteValido(item)) {
                return false;
            }
        }
        return true;
    }

    protected boolean esSateliteValido(Satelite satellite) throws Exception {
        if (satellite == null) {
            throw new Exception("No hay información de satelites para evaluar");
        }

        Satelite aux = buscarSatelite(satellite.getName());
        if (aux != null) {
            satellite.setCoordenada(aux.getCoordenada());
            return true;
        }

        return false;
    }

    protected double[] parsearDistancias(Collection<Satelite> satellites)
            throws Exception {

        if (satellites == null) {
            throw new Exception("No hay información de satelites para evaluar");
        }

        double[] distances = new double[satellites.size()];
        int i = 0;
        for (Satelite item : satellites) {
            distances[i] = item.getDistance();
            i++;
        }

        return distances;
    }

    protected double[][] parsearCoordenadas(Collection<Satelite> satellites)
            throws Exception {
        if (satellites == null) {
            throw new Exception("No hay información de satelites para evaluar");
        }
        double[][] positions = new double[satellites.size()][];
        int i = 0;
        for (Satelite item : satellites) {
            Coordenada coor = item.getCoordenada();
            if (coor != null) {
                positions[i++] = coor.arrayCoordenadas();
            }
        }

        return positions;
    }

}
