package com.ssg.alln.strategy.caseTwo.factory;

import com.ssg.alln.strategy.caseTwo.dto.Region;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNine;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineBusan;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineKyunggi;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineSeoul;

import java.util.HashMap;
import java.util.Map;

public class ThreeSixNineFactory {

    private Map<Region, ThreeSixNine> serviceMap = new HashMap<>();

    public ThreeSixNineFactory() {}
    public ThreeSixNineFactory(ThreeSixNineSeoul a2, ThreeSixNineKyunggi a1, ThreeSixNineBusan a3) {
        serviceMap.put(Region.경기, a1);
        serviceMap.put(Region.서울, a2);
        serviceMap.put(Region.부산, a3);
    }

    public String getService(String regionStr) {
        ThreeSixNine service =  serviceMap.get(Region.findRegionbyString(regionStr));
        return service.playGame();
    }
}
