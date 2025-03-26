package com.ssg.alln.Test.service;

import org.springframework.stereotype.Service;

@Service
public class ThreeSixNineKyunggi implements ThreeSixNine {

    @Override
    public String playGame() {
        return "kyunggi";
    }
}
