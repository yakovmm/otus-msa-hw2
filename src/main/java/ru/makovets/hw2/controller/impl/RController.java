package ru.makovets.hw2.controller.impl;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.makovets.hw2.model.ResponseStatus;
import ru.makovets.hw2.service.ResponseHelper;

@RestController
@RequestMapping("/")
public class RController {

    private final ResponseHelper helper;

    public RController(ResponseHelper helper) {
        this.helper = helper;
    }

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStatus> healthStatus() {
        return helper.responseStatusOk();
    }
}
