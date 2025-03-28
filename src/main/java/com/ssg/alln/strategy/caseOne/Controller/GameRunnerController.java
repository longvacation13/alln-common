package com.ssg.alln.strategy.caseOne.Controller;

import com.ssg.alln.strategy.caseOne.factory.ThreeSixNineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameRunnerController {

    private final ThreeSixNineFactory factory;

    @GetMapping("/v1/play")
    public void getPlay(String region) {
        System.out.println(factory.getService(region));
    }
}
