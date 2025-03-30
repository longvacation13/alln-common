package com.ssg.alln.strategy.caseTwo;

import com.ssg.alln.strategy.caseTwo.factory.ThreeSixNineFactory;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineBusan;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineKyunggi;
import com.ssg.alln.strategy.caseTwo.service.ThreeSixNineSeoul;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Hello world");
        String regionStr = "seoul";
        ThreeSixNineSeoul seoul = new ThreeSixNineSeoul();
        ThreeSixNineKyunggi kyunggi = new ThreeSixNineKyunggi();
        ThreeSixNineBusan busan = new ThreeSixNineBusan();
        ThreeSixNineFactory t1 = new ThreeSixNineFactory(seoul, kyunggi, busan);
        System.out.println("result : " +t1.getService(regionStr));
    }

}
