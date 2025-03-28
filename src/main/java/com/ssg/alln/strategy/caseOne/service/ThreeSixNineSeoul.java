package com.ssg.alln.strategy.caseOne.service;

import org.springframework.stereotype.Service;

@Service
public class ThreeSixNineSeoul implements ThreeSixNine {
    @Override
    public String playGame() {
        return "seoul";
    }
}
