package com.ssg.alln.order;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.helpers.TransformedHeader;
import org.springframework.context.annotation.Description;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SyncAsyncBlockNonBlockTest {
    /**
       Sync(동기): 호출한 함수가 결과를 반환할 때까지 기다림. (함수가 끝날 때까지 다음 코드 실행 안 됨)
       Async(비동기): 호출한 함수가 즉시 반환하고, 나중에 결과를 받을 수 있음.
       Blocking(블로킹): 호출한 스레드가 멈춘 상태에서 기다림.
       Non-Blocking(논블로킹): 호출한 스레드가 계속 실행 가능
    ✅ Sync-Blocking: 함수가 끝날 때까지 스레드가 멈춤. (Thread.sleep() 같은 것)
    ✅ Sync-NonBlocking: 일반적으로 없음. (Future.get(timeout) 같은 예외적인 경우 가능)
    ✅ Async-Blocking: 비동기 호출을 했지만 결과를 기다리는 경우 (future.get()을 호출)
    ✅ Async-NonBlocking: 이게 진짜 완전 비동기! (CompletableFuture나 Callback 사용)
    **/
    // Q1. checked Exception와 unChecked exception의 차이는 무엇인가?

    @Test
    @Description("동기 + 블로킹")
    void testSyncBlocking() {
        long start = System.currentTimeMillis();
        String result = this.syncBlockingMethod();
        long end = System.currentTimeMillis();

        assertEquals("완료", result);
        assertTrue(end - start >= 1000);
    }

    private String syncBlockingMethod() {
        try {
            Thread.sleep(1000); // 블로킹
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "완료";
    }


    @Test
    @Description("비동기 + 블로킹")
    void testAsyncBlocking() throws ExecutionException, InterruptedException {
        Future<String> future = this.asyncBlockingMethod();
        System.out.println("testAsnycBlocking >>>");
        // future.get 하는 순간에 블로킹이 발생함
        // future객체의 내부작업이 완료될때까지 현재 스레드가 대기함
        String result = future.get();

        assertEquals("완료", result);
    }

    private Future<String> asyncBlockingMethod() {
        // 단일 스레드기 때문에 하나씩 처리하고 따라서 블로킹
        // 멀티스레드라고 해도 submit() 이 반환하는 future 객체는 기본적으로 블로킹 API이다.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService.submit(() -> {
            Thread.sleep(500);
            System.out.println("asyncBlockingMethod >>>");
           return "완료";
        });
    }


    @Test
    void testAsyncNonBlocking() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = this.asyncNonBlockingMethod();
        future.get();
        System.out.println("testAsyncNonBlocking >>"); // 1번 
        
    }

    private CompletableFuture<String> asyncNonBlockingMethod() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("asyncNonBlockingMethod>>"); // 2번
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "완료";
        });
    }


    @Test
    void testAsyncNonBlocking2() throws InterruptedException, ExecutionException {

    }

    private CompletableFuture<String> asyncNonBlockingMethod2() {
        return CompletableFuture.supplyAsync(() -> {
            for(int i = 0; i < 1000; i ++) {
                System.out.println("비동기 작업 실행>>");
            }
            try { Thread.sleep(50); } catch (InterruptedException e) { throw new RuntimeException(e); }
            return "완료";
        });
    }

}
