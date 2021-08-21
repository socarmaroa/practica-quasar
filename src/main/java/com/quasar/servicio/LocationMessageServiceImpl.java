package com.quasar.servicio;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.quasar.modelo.Coordenada;
import com.quasar.modelo.Satelite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

@Service
class LocationMessageServiceImpl implements LocationService, MessageService {

    public List<String> procesarFrases(List<List<String>> list) {

        List<String> frases = new ArrayList<>();
        for (List<String> msg : list) {
            frases = Stream.concat(frases.stream(), msg.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        frases.remove("");
        return frases;
    }

    public void remove(List<List<String>> list, int size) {
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i).size();
            list.set(i, list.get(i).subList(s - size, s));
        }
    }

    public String completarMensaje(List<List<String>> list) {
        String phrase ;
        for (List<String> m : list) {

            if (m.size() > 0 && !m.get(0).equals("")) {
                phrase = (m.size() == 1) ? m.get(0) : m.get(0) + " ";
                list.stream().forEach(s -> s.remove(0));
                return phrase + completarMensaje(list);
            }
        }
        return "";
    }

    public String procesarMensaje(List<List<String>> msgList) throws Exception {

        List<String> msgPhrases = procesarFrases(msgList);
        if (!esValidoMensaje(msgList, msgPhrases.size())) {
            throw new Exception("Tamaño del mensaje incorrecto");
        }

        remove(msgList, msgPhrases.size());
        String message = completarMensaje(msgList);
//        if (!validateMessagePhrases(msgPhrases, message)) {
//            throw new Exception("No se puede conocer el mensaje");
//        }
        return message;
    }

    public boolean esValidoMensaje(List<List<String>> messages, int size) {
        return messages.stream().noneMatch(m -> (m.size() < size));
    }

    public boolean validateMessagePhrases(List<String> phrases, String message) {
        List<String> msg = Arrays.stream(message.split(" ")).collect(Collectors.toList());
        Collections.sort(phrases);
        Collections.sort(msg);
        return Arrays.equals(phrases.toArray(), msg.toArray());
    }

    @Override
    public Coordenada getLocation(double[][] coordenadas, double[] distancias) throws Exception {
        TrilaterationFunction a = new TrilaterationFunction(coordenadas, distancias);
        LevenbergMarquardtOptimizer b = new LevenbergMarquardtOptimizer();
        NonLinearLeastSquaresSolver c = new NonLinearLeastSquaresSolver(a, b);
        c.solve().getPoint().toArray();
        return Coordenada.getCoordenada(c.solve().getPoint().toArray());
    }

    @Override
    public String getMessage(Collection<Satelite> satellites) throws Exception {
        List<List<String>> valores = new ArrayList<>();
        satellites.forEach(item -> {
            valores.add(item.getMessage());
        });
        return procesarMensaje(valores);
    }

}
