package com.ssg.alln.strategy.caseFour.main;

import com.ssg.alln.strategy.caseFour.Util.CaseForUtils;
import com.ssg.alln.strategy.caseFour.factory.PlayGameFactory;
import com.ssg.alln.strategy.caseFour.service.PlayGameForKyunggi;
import com.ssg.alln.strategy.caseFour.service.PlayGameForSeoul;
import com.ssg.alln.strategy.caseFour.dto.Player;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class GameRun {
    public static void main(String[] args) {
        Player a1 = Player.of("David", 5.3);
        Player a2 = Player.of("Ahn", 10.3);

        PlayGameFactory p = new PlayGameFactory(new PlayGameForSeoul(), new PlayGameForKyunggi());

        /** // sync
        p.getService("seoul", a1);
        p.getService("kyunggi", a2);
        */

        /**
         * // OS Thread
         * ExecutorService executorService = Executors.newFixedThreadPool(2);
         * executorService.submit(() -> p.getService("seoul", a1));
         * executorService.submit(() -> p.getService("kyunggi", a2));
         * executorService.shutdown();
         */

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        Random random = new Random();
        for(int i = 0; i < 5 ; i++) {
            Player seoulPlayer = Player.of("seoul_player_"+ i, random.nextDouble()*100);
            Player kyunggiPlayer = Player.of("kyunggi_player"+ i, random.nextDouble()*100);
            System.out.println("seoul player ["+ seoulPlayer.getName() +"] 오류율"+seoulPlayer.getErrorRate());
            System.out.println("kyunggi player ["+ kyunggiPlayer.getName() +"] 오류율"+kyunggiPlayer.getErrorRate());
            executorService.submit(() -> p.getService("seoul", seoulPlayer));
            executorService.submit(() -> p.getService("kyunggi", kyunggiPlayer));
        }
        executorService.shutdown(); // 없으면 일부만 실행되고 프로그램 끝나버림
        try {
            if (!executorService.awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("일부 작업이 아직 끝나지 않았습니다.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("대기 중 인터럽트 발생");
        }

    }
}
