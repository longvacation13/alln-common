package com.ssg.alln.Test.factory;


import com.ssg.alln.Test.dto.RegionEnum;
import com.ssg.alln.Test.service.ThreeSixNine;
import com.ssg.alln.Test.service.ThreeSixNineKyunggi;
import com.ssg.alln.Test.service.ThreeSixNineSeoul;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ThreeSixNineFactory {
    private final Map<RegionEnum, ThreeSixNine> serviceMap = new HashMap<>();

    // ThreeSixNineSeoul 에 @Service 유무에 따라 왜 빨간줄이 가나?
    // @Service -> bean에 올라갔다. -> IoC에서 DI로 주입받아 쓸수 있다. (autowired 없이 쓸수 있나?) -> 쓸수있다. 생성자주입이기 때문
    // Spring 4.3 부터 생성자 파라미터들이 전부 Bean으로 등록되어 있으면, Spring이 자동으로 그 생성자 사용해서 주입함
    public ThreeSixNineFactory(ThreeSixNineSeoul threeSixNineSeoul, ThreeSixNineKyunggi threeSixNineKyunggi) {
        serviceMap.put(RegionEnum.서울_seoul, threeSixNineSeoul);
        serviceMap.put(RegionEnum.경기_kyunggi, threeSixNineKyunggi);
    }

    private ThreeSixNine getService(RegionEnum regionEnum) {
        return serviceMap.get(regionEnum);
    }

    public String gameRun(RegionEnum regionEnum) {
        return this.getService(regionEnum).playGame();
    }
}
