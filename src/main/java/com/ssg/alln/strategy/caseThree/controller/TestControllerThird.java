package com.ssg.alln.strategy.caseThree.controller;


import com.ssg.alln.strategy.caseThree.factory.ThreeSixNineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
@RequiredArgsConstructor
public class TestControllerThird {

    @Qualifier("threeSixNineFactoryThird")
    private final ThreeSixNineFactory threeSixNineFactory;

    @GetMapping("test1")
    public void test(@RequestParam String region) {
        threeSixNineFactory.getService(region);
    }
}
