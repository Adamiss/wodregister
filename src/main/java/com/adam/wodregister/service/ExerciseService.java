package com.adam.wodregister.service;

import com.adam.wodregister.enitity.Exercise;
import com.adam.wodregister.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;


    public Exercise saveOrUpdateExercise (Exercise exercise) {

        if(exerciseRepository.findByName(exercise.getName()) != null){
            throw new RuntimeException("This exercise Already exists.");
        }


        return exerciseRepository.save(exercise);
    }

    public Exercise findByName (String name){
        return exerciseRepository.findByName(name);
    }
}
