package com.adam.wodregister.controller;

import com.adam.wodregister.service.WodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class WodController {

    @Autowired
    private WodService wodService;

    @GetMapping("/{wodId}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return new ResponseEntity<>(wodService.findById(id), HttpStatus.OK);
    }

}
