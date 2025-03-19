package com.ssg.alln.order;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


// CSV 파일을 비동기로 읽고 처리하는 Junit test 작성
// 여러개의 CompletableFuture 생성하여 각 행을 독립적으로 처리 (논블로킹)


/**
 * 여기서는 끝나면 결과를 반환하기 때문에 호출한 녀석 (testAsyncCsvProcessing)은 호출 즉시 다음 라인으로 넘어간다 (비동기)
 * 이 녀석(processRowAsync)은 이 내부에서 처리하고 있고, 호출한 녀석은 다른 로직을 수행한다는 관점에서는 넌 블로킹이라고 보면 될까?
 */
public class SyncAsyncBlockNonBlockTest3 {

    private static final String FILE_PATH = "E:\\repository\\ssg-alln-common\\src\\main\\resources\\test_async_tasks.csv";

    @Test
    public void testAsyncCsvProcessing() throws Exception {
        // 1. CSV 파일 읽기 (동기)
        List<String[]> records = readCsvFile(FILE_PATH);

        // 2. 비동기로 각 행을 처리 (논블로킹)
        List<CompletableFuture<String>> futures = records.stream()
                .map(this::processRowAsync) // 각 행을 비동기로 처리
                .collect(Collectors.toList());

        // 3. 모든 작업이 끝날때까지 기다리고 결과 수집
        // 이 메서드(CompletableFuture.allOf)를 호출한 순간에는 즉시 다음 코드로 진행되며 블로킹되지 않음.
        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        // 4. 모든 작업 완료 후 결과 확인
        // 그럼 모든 작업 완료후 결과 확인을 위한 join 때문에 이건 async + 논블로킹 -> 맞음
        // allDone.thenApply() 까지는 비동기
        // join()하거나 get()하면 블로킹이 발생.
        /**
        List<String> results = allDone.thenApply(v ->
                futures.stream().map(CompletableFuture::join).collect(Collectors.toList())
        ).join();

         // 5. 결과 출력 (테스트 결과 확인용)
         results.forEach(System.out::println);
         */

        /**
        // join() 없이 논블로킹 방식으로 모든 작업 완료 후 실행.
        allDone.thenRun(() -> System.out.println("모든 작업 완료! (논블로킹)"));
        */

        // thenAccept()로 개별 결과 출력
        allDone.thenRun(() -> futures.forEach(f -> f.thenAccept(System.out::println)));
    }

    // CSV 파일 읽어서 리스트로 변환
    private List<String[]> readCsvFile(String filePath) throws IOException {
        List<String[]> records = new ArrayList<>();

        // todo : 뭐야?
        try(BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            br.lines().skip(1) // 헤더제외
                    .map(line -> line.split(",")) // 콤마로 분리
                    .forEach(records::add);
        }
        return records;
    }

    // 비동기로 각 행을 처리하는 메서드
    private CompletableFuture<String> processRowAsync(String[] row) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // TODO : 이거 왜 해?
                Thread.sleep(1000); // 각 작업 처리시간 (1초)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Processed: " + Arrays.toString(row);
        });
    }
}
