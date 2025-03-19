package com.ssg.alln.order;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.io.InputStream;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SyncAsyncBlockNonBlockTest2 {


    @Test
    @Description("커피 만들기와 빵굽기로 보는 비동기 작업")
    public void nonBlockingAsyncTest() {

        // Q1. CompletableFuture와 Future의 차이
        // Q2.

        // 1. 커피만들기
        CompletableFuture<String> makeCoffee = CompletableFuture.supplyAsync(() -> {
           try {
               Thread.sleep(3000); // 커피 만드는 시간 3초
           } catch (Exception e) {
               e.printStackTrace();
           }
           return "커피 준비 완료!";
        });

        // 2. 빵 굽기(비동기)
        CompletableFuture<String> bakeBread = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "빵 준비 완료!";
        });

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(makeCoffee, bakeBread)
                .thenRun(() -> {
                    try {
                        System.out.println("▶ " + makeCoffee.get()); // 커피 결과 출력
                        System.out.println("▶ " + bakeBread.get());  // 빵 결과 출력
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        // 4. 테스트가 끝나기 전에 비동기 작업이 완료되도록 대기
        allTasks.join();

    }
}
