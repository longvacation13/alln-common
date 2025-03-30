package com.ssg.alln.strategy.caseFour.factory;


import com.ssg.alln.strategy.caseFour.dto.Player;
import com.ssg.alln.strategy.caseFour.service.PlayGame;
import com.ssg.alln.strategy.caseFour.service.PlayGameForKyunggi;
import com.ssg.alln.strategy.caseFour.service.PlayGameForSeoul;

import java.util.HashMap;
import java.util.Map;

// 적절한 PlayGame객체를 받음
public class PlayGameFactory {
    private Map<String, PlayGame> serviceMap = new HashMap<>();

    public PlayGameFactory(PlayGameForSeoul s, PlayGameForKyunggi k) {
        serviceMap.put("seoul", s);
        serviceMap.put("kyunggi", k);
    }

    public void getService(String region, Player a1) {
        PlayGame p = serviceMap.get(region);
        p.do369(a1);
    }
}
