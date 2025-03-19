package com.ssg.alln.order.service;

import com.ssg.alln.order.dto.CommonMsgEnum;
import com.ssg.alln.order.dto.CommonResponse;
import com.ssg.alln.order.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static final String CSV_FILE_PATH = "E:\\repository\\ssg-alln-common\\src\\main\\resources\\test_async_tasks.csv"; // CSV 파일 경로
    private static final int BATCH_SIZE = 50; // 한 번에 처리할 데이터 개수
    private static final int THREAD_POOL_SIZE = 4; // 병렬 실행할 스레드 개수

    public CommonResponse<OrderResponse> getProducts() {
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId("ORD12345")
                .orderDts(LocalDate.now())
                .itemInfo(List.of(
                        OrderResponse.ItemInfo.builder().itemId("ITEM001").build(),
                        OrderResponse.ItemInfo.builder().itemId("ITEM002").build()
                ))
                .build();

        return CommonResponse.<OrderResponse>builder()
                .resultCode(CommonMsgEnum.서비스_요청_성공.getCode())
                .resultMsg(CommonMsgEnum.서비스_요청_성공.getMsg())
                .resultDesc(CommonMsgEnum.서비스_요청_성공.getMsg())
                .resultData(orderResponse)
                .build();
    }

    public void AsyncProcess() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            List<String> batch = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null) {
                batch.add(line);
                if(batch.size() == BATCH_SIZE) {
                    futures.add(processBatchAsync(batch, executorService));
                    batch = new ArrayList<>();
                }
            }
            if(!batch.isEmpty()) {
                futures.add(processBatchAsync(batch, executorService));
            }
        } catch (IOException e) {

        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
        System.out.println("모든 데이터 처리가 완료되었습니다.");

    }

    private static CompletableFuture<Void> processBatchAsync(List<String> batch, Executor executor) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Processing batch: " + batch.stream().limit(5).collect(Collectors.toList()) + "... (총" + batch.size() + "개)");
            try {
                    Thread.sleep(100); // 시뮬레이션용 딜레이
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);
    }
}
