package com.adam.wodregister.controller;

import com.adam.wodregister.enitity.Wod;
import com.adam.wodregister.service.WodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/wod")
public class WodController {

    @Autowired
    private WodService wodService;

    @GetMapping("/{wodId}")
    public ResponseEntity<?> findById(@PathVariable UUID wodId){
        return new ResponseEntity<>(wodService.findById(wodId), HttpStatus.FOUND);
    }

    @PostMapping("")
    public ResponseEntity<?> saveOrUpdateWod(@Valid @RequestBody Wod wod){
        return new ResponseEntity<>(wodService.saveOrUpdateWod(wod), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(wodService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{wodId}")
    public ResponseEntity<?> deleteWodById(@Valid @PathVariable UUID wodId){
        wodService.deleteWodById(wodId);
        return new ResponseEntity<String>("Wod with ID:'"+wodId.toString()+"' was deleted.",HttpStatus.OK);

    }

}
