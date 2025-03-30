package com.ssg.alln.strategy.caseThree.service;


import org.springframework.stereotype.Service;

@Service
public class ThreeSixNineThirdKyunggi extends ThreeSixNineThird {

    @Override
    protected void setRules(String region) {
        System.out.println("setRules for "+region);
    }
}
