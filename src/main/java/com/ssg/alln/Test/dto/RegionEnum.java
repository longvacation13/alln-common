package com.ssg.alln.Test.dto;

import java.util.Arrays;

public enum RegionEnum {
    서울_seoul("seoul"),
    경기_kyunggi("kyunggi");

    String name;
    RegionEnum(String name) {
        this.name = name;
    }

    // static factory 메서드 : new 키워드를 사용하지 않고 객체 반환
    // 가독성
    public static RegionEnum find(String region) {
        return Arrays.stream(values())      // values란 무엇인가?
                .filter(a -> a.name.equals(region))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal region : "+region)); // ()는 왜 있어야하나?

    }

}
