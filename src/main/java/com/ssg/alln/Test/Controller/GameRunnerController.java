package com.ssg.alln.Test.Controller;

import com.ssg.alln.Test.dto.RegionEnum;
import com.ssg.alln.Test.factory.ThreeSixNineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameRunnerController {

    private final ThreeSixNineFactory threeSixNineFactory;
    @GetMapping("/v1/play")
    public void getPlay(String region) {
        threeSixNineFactory.gameRun(RegionEnum.find(region));
    }
}
