package com.ssg.alln.strategy.caseOne.dto;

import java.util.Arrays;

public enum RegionEnum {
    서울("seoul"),
    경기("kyunggi");

    String region;

    RegionEnum(String region) {
        this.region = region;
    }

    public static RegionEnum findRegionEnumByString(String region) {
        return Arrays.stream(values())
                .filter(value -> value.region.equals(region))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("region is not included region :"+region));

    }
}
