package com.quasar.servicio;

import com.quasar.modelo.Coordenada;
import com.quasar.modelo.Satelite;
import com.quasar.payload.request.TopSecretRequest;
import com.quasar.payload.request.TopSecretSplitRequest;
import com.quasar.payload.response.TopSecretResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class QuasarServiceImpl extends QuasarServiceGeneral implements TopSecretService, TopSecretSplitService {

    @Autowired
    private LocationService locationService;

    @Autowired
    private MessageService messageService;

    @Override
    public TopSecretResponse procesarTopSecret(TopSecretRequest topSecretRequest)
            throws Exception {
        if (topSecretRequest == null) {
            throw new Exception("Información incompleta");
        }

        Collection<Satelite> satelites = topSecretRequest.getSatellites();

        if (!sonSatelitesValidos(satelites)) {
            throw new Exception("Nombre de satelites incorrectos");
        }

        return procesarTopSecret(satelites);
    }

    public TopSecretResponse procesarTopSecret(Collection<Satelite> satelites)
            throws Exception {

        double[] distancias = parsearDistancias(satelites);

        double[][] coordenadas = parsearCoordenadas(satelites);

        String message = messageService.getMessage(satelites);

        Coordenada coordenada = locationService.getLocation(coordenadas, distancias);

        return new TopSecretResponse(message, coordenada);
    }

    @Schedule(hour = "*", minute = "*/2", second = "*", persistent = false, info = "Cada 2 minutos")
    public void solicitarMonitoreo() {
        try {
            if (satelites_split.size() > 10) {
                satelites_split = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Error al procesar satelites_split");
        }
    }

    Collection<Satelite> satelites_split = new ArrayList<>();

    @Override
    public TopSecretResponse procesarTopSecretSplit(
            String satellite_name,
            TopSecretSplitRequest topSecretSplitRequest) throws Exception {
        if (topSecretSplitRequest == null) {
            throw new Exception("Información incompleta");
        }

        Satelite temp = new Satelite();
        temp.setName(satellite_name.replace(":", ""));

        if (!esSateliteValido(temp)) {
            throw new Exception("Información incompleta");
        }
        temp.setDistance(topSecretSplitRequest.getDistance());
        temp.setMessage((List<String>) topSecretSplitRequest.getMessage());
        satelites_split.add(temp);
        return procesarTopSecret(satelites_split);
    }

}
