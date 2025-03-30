package com.ssg.alln.strategy.caseFour.service;

import com.ssg.alln.strategy.caseFour.dto.Player;

public abstract class PlayGame {

    // 공통적인 기능
        // 369를 한다
    // 세부적인 기능
        // 지역별로 다르게 한다.
    public void do369(Player a1) {
        System.out.println(a1.getName() + "do 369 for common");
        this.do369ForRegion();
    }

    protected abstract void do369ForRegion();
}
