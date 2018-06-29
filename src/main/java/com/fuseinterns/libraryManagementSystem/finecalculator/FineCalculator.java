package com.fuseinterns.libraryManagementSystem.finecalculator;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("fineCalculator")
public class FineCalculator {

    public FineCalculator() {
        calculateFine(new Date());
    }

    public float calculateFine(Date date){
        Date currentDate = new Date();

        if(date.compareTo(currentDate)<0){
            System.out.println("Here");
            return 5.0f*((currentDate.getTime()-date.getTime())/ (1000*60*60*24));
        }

        return 0.0f;
    }

}
