package com.quasar.payload.request;

import com.quasar.modelo.Satelite;
import java.util.Collection;

public class TopSecretRequest {

    private Collection<Satelite> satellites;

    /**
     * @return the satellites
     */
    public Collection<Satelite> getSatellites() {
        return satellites;
    }

    /**
     * @param satellites the satellites to set
     */
    public void setSatellites(Collection<Satelite> satellites) {
        this.satellites = satellites;
    }

}
