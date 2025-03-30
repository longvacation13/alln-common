package com.ssg.alln.strategy.caseThree.dto;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum RegionThird {
    서울("seoul"),
    경기("kyunggi");

    String name;

    RegionThird(String name) {
        this.name = name;
    }

    public static RegionThird findRegionByString(String region) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(region))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("illegal region :" + region));

    }
}
