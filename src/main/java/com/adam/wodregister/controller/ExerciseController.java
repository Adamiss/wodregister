package com.adam.wodregister.controller;

import com.adam.wodregister.enitity.Exercise;
import com.adam.wodregister.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {


    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("")
    public ResponseEntity<?> createNewExercise(@Valid @RequestBody Exercise exercise ){

        System.out.println("exercise.name"+ exercise.getName());
        Exercise exercise1 = exerciseService.saveOrUpdateExercise(exercise );
        return new ResponseEntity<>(exercise1, HttpStatus.CREATED);
    }

    @GetMapping("/{exerciseName}")
    public ResponseEntity <?> getExerciseByName(@PathVariable String exerciseName){
        Exercise exercise = exerciseService.findByName(exerciseName);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable <Exercise> getAllExercise(){return exerciseService.findAll();}

    @DeleteMapping("/{exerciseName}")
    public ResponseEntity<?> deleteExercise(@PathVariable String exerciseName){
        exerciseService.deleteExerciseByName(exerciseName);
        return new ResponseEntity<String>("Exercise with name: '"+exerciseName+"' was deleted.", HttpStatus.OK);
    }


}
