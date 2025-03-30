package com.ssg.alln.strategy.caseTwo.dto;

import java.util.Arrays;

public enum Region {
    서울("seoul"),
    부산("busan"),
    경기("kyunggi");

    String name;

    Region(String name) {
        this.name = name;
    }

    public static Region findRegionbyString(String region) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(region))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("region is invalid :"+region));
    }
}
