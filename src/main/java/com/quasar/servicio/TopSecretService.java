package com.quasar.servicio;

import com.quasar.payload.request.TopSecretRequest;
import com.quasar.payload.response.TopSecretResponse;

public interface TopSecretService{ 

    public TopSecretResponse procesarTopSecret(TopSecretRequest topSecretRequest)throws Exception;
}

