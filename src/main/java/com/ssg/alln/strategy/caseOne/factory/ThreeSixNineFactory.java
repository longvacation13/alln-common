package com.ssg.alln.strategy.caseOne.factory;


import com.ssg.alln.strategy.caseOne.service.ThreeSixNine;
import com.ssg.alln.strategy.caseOne.service.ThreeSixNineKyunggi;
import com.ssg.alln.strategy.caseOne.service.ThreeSixNineSeoul;
import com.ssg.alln.strategy.caseOne.dto.RegionEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ThreeSixNineFactory {

    private final Map<RegionEnum, ThreeSixNine> serviceMap = new HashMap<>();

    public ThreeSixNineFactory(ThreeSixNineSeoul threeSixNineSeoul, ThreeSixNineKyunggi threeSixNineKyunggi) {
        serviceMap.put(RegionEnum.서울, threeSixNineSeoul);
        serviceMap.put(RegionEnum.경기, threeSixNineKyunggi);
    }

    public String getService(String region) {
        ThreeSixNine threeSixNine = serviceMap.get(RegionEnum.findRegionEnumByString(region));
        return threeSixNine.playGame();
    }
}
