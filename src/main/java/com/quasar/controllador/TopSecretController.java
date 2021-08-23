package com.quasar.controllador;

import com.quasar.payload.request.TopSecretRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.quasar.servicio.TopSecretService;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("topsecret")
public class TopSecretController {

    @Autowired
    private TopSecretService topSecretService;

    @GetMapping("/test")
    public String allAccess() {
        return "Test Top Secret";
    }

    @PostMapping
    public ResponseEntity<?> procesarTopSecret(@Valid @RequestBody TopSecretRequest topSecretRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(topSecretService.procesarTopSecret(topSecretRequest));
        } catch (Exception ex) {
            Logger.getLogger(TopSecretController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }
}
