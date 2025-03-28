package com.ssg.alln.Test.factory;


import com.ssg.alln.Test.dto.RegionEnum;
import com.ssg.alln.Test.service.ThreeSixNine;
import com.ssg.alln.Test.service.ThreeSixNineKyunggi;
import com.ssg.alln.Test.service.ThreeSixNineSeoul;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.Region;
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
