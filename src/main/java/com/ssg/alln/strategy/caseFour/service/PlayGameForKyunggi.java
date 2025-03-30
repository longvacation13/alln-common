package com.ssg.alln.strategy.caseFour.service;

import com.ssg.alln.strategy.caseFour.Util.CaseForUtils;
import com.ssg.alln.strategy.caseFour.dto.Player;

public class PlayGameForKyunggi extends PlayGame {
    @Override
    protected void do369ForRegion(Player p) {
        System.out.println("경기 지역의 게임을 시작합니다.");
        int index = 1;
        int errorCount = 0;
        while(errorCount < 10) {
            if(index % 3 == 0 && CaseForUtils.correctOrIncorrect(p.getErrorRate())) {
                System.out.println("현재 번호 : "+index+" 얘기한말 : 짝!");
            }
            else if(index % 4 == 0 && CaseForUtils.correctOrIncorrect(p.getErrorRate())) {
                System.out.println("현재 번호 : "+index+" 얘기한말 : 경기!");
            } else if(index % 4 > 0 && CaseForUtils.correctOrIncorrect(p.getErrorRate())) {
                System.out.println("현재 번호 : "+index+" 얘기한말 : "+ index);
            } else {
                System.out.println("현재 번호 : "+index+" 틀렸습니다.");
                errorCount++;
            }
            index++;
        }
    }
}
