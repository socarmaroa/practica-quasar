/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.servicio;

import com.quasar.payload.request.TopSecretSplitRequest;
import com.quasar.payload.response.TopSecretResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author so_ca
 */
public interface TopSecretSplitService {

    public TopSecretResponse procesarTopSecretSplit(@PathVariable("satellite_name") String satellite_name,
            @RequestBody TopSecretSplitRequest topSecretSplitRequest)throws Exception;
}
