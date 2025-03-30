package com.ssg.alln.strategy.caseThree.factory;


import com.ssg.alln.strategy.caseThree.dto.RegionThird;
import com.ssg.alln.strategy.caseThree.service.ThreeSixNineThird;
import com.ssg.alln.strategy.caseThree.service.ThreeSixNineThirdKyunggi;
import com.ssg.alln.strategy.caseThree.service.ThreeSixNineThirdSeoul;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("threeSixNineFactoryThird")
public class ThreeSixNineFactory {
    private final Map<RegionThird, ThreeSixNineThird> serviceMap = new HashMap<>();

    public ThreeSixNineFactory(ThreeSixNineThirdKyunggi kyunggi, ThreeSixNineThirdSeoul seoul) {
        serviceMap.put(RegionThird.경기, kyunggi);
        serviceMap.put(RegionThird.서울, seoul);
    }

    public String getService(String region) {
         ThreeSixNineThird threeSixNineThird = serviceMap.get(RegionThird.findRegionByString(region));
         return threeSixNineThird.playGame(region);
    }
}
