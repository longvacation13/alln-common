package com.ssg.alln.strategy.caseThree.service;

public abstract class ThreeSixNineThird {
    public String playGame(String region) {
        this.setRules(region);
        return region;
    }

    protected abstract void setRules(String region);
}
