package com.adam.wodregister.service;


import com.adam.wodregister.enitity.Wod;
import com.adam.wodregister.repositories.WodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WodService {

    @Autowired
    private WodRepository wodRepository;

    public Optional<Wod> findById(UUID id){
        return wodRepository.findById(id);
    }

    public Wod saveOrUpdateWod(Wod wod){
        return wodRepository.save(wod);
    }

    public Iterable<Wod> findAll(){
        return wodRepository.findAll();
    }
}
