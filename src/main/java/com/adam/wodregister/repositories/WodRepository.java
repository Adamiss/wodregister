package com.adam.wodregister.repositories;


import com.adam.wodregister.enitity.Wod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WodRepository extends CrudRepository<Wod,UUID> {

    Optional<Wod> findById(UUID id);

    Iterable<Wod> findAll();


}
