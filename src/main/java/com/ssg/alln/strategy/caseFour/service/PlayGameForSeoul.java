package com.ssg.alln.strategy.caseFour.service;

import com.ssg.alln.strategy.caseFour.Util.CaseForUtils;
import com.ssg.alln.strategy.caseFour.dto.Player;

public class PlayGameForSeoul extends PlayGame {
    @Override
    protected void do369ForRegion(Player p) {
        System.out.println("seoul 지역의 게임을 시작합니다.");
        int index = 1;
        int errorCount = 0;
        while(errorCount < 10) {
            System.out.println("에러 건수 :"+errorCount);
            if(index % 3 == 0 && CaseForUtils.correctOrIncorrect(p.getErrorRate())) {
                System.out.println("현재 번호 : "+index+" 얘기한말 : 짝!");
            } else if(index % 3 > 0 && CaseForUtils.correctOrIncorrect(p.getErrorRate())) {
                System.out.println("현재 번호 : "+index+" 얘기한말 : "+ index);
            } else {
                System.out.println("현재 번호 : "+index+" 틀렸습니다.");
                errorCount++;
            }
            index++;
        }
    }
}
