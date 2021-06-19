package com.adam.wodregister.controller;

import com.adam.wodregister.enitity.Exercise;
import com.adam.wodregister.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {


    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("")
    public ResponseEntity<?> createNewExercise(@Valid @RequestBody Exercise exercise, Principal principal ){

        System.out.println("exercise.name"+ exercise.getName());
        Exercise exercise1 = exerciseService.saveOrUpdateExercise(exercise );
        return new ResponseEntity<>(exercise1, HttpStatus.CREATED);
    }


}
