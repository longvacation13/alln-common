package com.ssg.alln.strategy.caseFour.main;

import com.ssg.alln.strategy.caseFour.factory.PlayGameFactory;
import com.ssg.alln.strategy.caseFour.service.PlayGameForKyunggi;
import com.ssg.alln.strategy.caseFour.service.PlayGameForSeoul;
import com.ssg.alln.strategy.caseFour.dto.Player;

public class GameRun {
    public static void main(String[] args) {
        Player a1 = Player.of("David", 20.3);
        Player a2 = Player.of("Lionel", 10.2);

        PlayGameFactory p = new PlayGameFactory(new PlayGameForSeoul(), new PlayGameForKyunggi());
        p.getService("seoul", a1);
    }
}
