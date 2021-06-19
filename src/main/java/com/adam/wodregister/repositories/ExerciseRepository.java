package com.adam.wodregister.repositories;


import com.adam.wodregister.enitity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, UUID> {

    Exercise findByName(String name);

    Iterable<Exercise> findAll();
}
