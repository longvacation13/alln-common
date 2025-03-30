package com.ssg.alln.strategy.caseFour.service;

import com.ssg.alln.strategy.caseFour.Util.CaseForUtils;
import com.ssg.alln.strategy.caseFour.dto.Player;

public abstract class PlayGame {
    public void play(Player p) {
        do369(p);
        do369ForRegion(p);
    }
    // 공통적인 기능
        // 369를 한다
    // 세부적인 기능
        // 지역별로 다르게 한다.
    void do369(Player p) {
        this.do369ForRegion(p);
        System.out.println("게임을 종료합니다.");
    }

    protected abstract void do369ForRegion(Player p);
}
