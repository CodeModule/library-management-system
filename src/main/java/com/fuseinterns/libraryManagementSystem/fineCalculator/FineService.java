package com.fuseinterns.libraryManagementSystem.fineCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;


    public Fine getFine(String userId){

        return fineRepository.getByUserId(userId);
    }

    public void setFine(Fine fine){
        this.fineRepository.save(fine);
    }
}
