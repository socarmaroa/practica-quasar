package com.quasar.payload.response;

import com.quasar.modelo.Coordenada;

public class TopSecretResponse {

    private String message;
    
    private Coordenada position;

    public TopSecretResponse(String message,Coordenada position) {
        this.message = message;
        this.position=position;
    }

   
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the position
     */
    public Coordenada getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Coordenada position) {
        this.position = position;
    }

}
