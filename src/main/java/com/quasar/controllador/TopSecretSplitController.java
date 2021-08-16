package com.quasar.controllador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topsecret_split")
public class TopSecretSplitController {

    @GetMapping("/test")
    public String allAccess() {
        return "Test Top Secret Split";
    }

}
