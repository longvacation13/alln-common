package com.ssg.alln.strategy.caseFour.dto;


public class Player {
    private String name;
    private Double errorRate;

    public String getName() {
        return this.name;
    }

    private Player(String name, Double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    public static Player of(String name, Double errorRate) {
        return new Player(name, errorRate);
    }
}
