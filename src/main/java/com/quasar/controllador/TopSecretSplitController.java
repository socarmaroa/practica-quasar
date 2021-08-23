package com.quasar.controllador;

import com.quasar.payload.request.TopSecretSplitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quasar.servicio.TopSecretSplitService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("topsecret_split")
public class TopSecretSplitController {

    @Autowired
    private TopSecretSplitService topSecretSplitService;

    @GetMapping("/test")
    public String allAccess() {
        return "Test Top Secret Split";
    }

    @RequestMapping(value = "/{satellite_name}",
            method = {RequestMethod.POST, RequestMethod.GET},
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> procesarTopSecretSplit(@PathVariable("satellite_name") String satellite_name,
            @RequestBody TopSecretSplitRequest topSecretSplitRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(topSecretSplitService.procesarTopSecretSplit(satellite_name,topSecretSplitRequest));
        } catch (Exception ex) {
            Logger.getLogger(TopSecretSplitController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

}
