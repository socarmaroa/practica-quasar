package com.quasar.payload.request;

import java.util.Collection;

public class TopSecretSplitRequest {

    private float distance;

    private Collection<String> message;

    /**
     * @return the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * @return the message
     */
    public Collection<String> getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(Collection<String> message) {
        this.message = message;
    }

}
