package ru.makovets.hw2.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.makovets.hw2.model.ResponseStatus;

@Service
public class ResponseHelper {
    
    public ResponseEntity<ResponseStatus> responseStatusOk() {
        return ResponseEntity.ok(ResponseStatus.builder().status("OK").build());
    }
}
