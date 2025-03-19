package com.ssg.alln.order;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OrderControllerTest {

    @Test
    public void test() {
//        Queue<int[]> servers = new LinkedList<>();
//        int[] a = {1,2,3,4,5};
//        int[] b = {22,33,44,55};
//        servers.add(a);
//        servers.add(b);
//        servers.peek();

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.offer(8);
//        System.out.println(q1.poll());
//        System.out.println(q1.poll());
//        System.out.println(q1.poll());
    }

    @Test
    public void test2() {

        LocalDate date = LocalDate.now();       // LocaleDate.now는 정적(static) 팩토리 메서드이다.
                                                // LocalDate는 private 메서드로 직접 new 키워드로 인스턴스 생성할 수 없다.
        System.out.println("기본 형식 : "+date);


        // 1. yyyy/mm/dd 형식
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("yyyy/mm/dd 형식" + date.format(formatter1));

        // 2. MM-dd-yyyy 형식
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("yyyy/mm/dd 형식" + date.format(formatter2));

        // 3. yyyy-MM-dd HH:mm:ss
        // 2. MM-dd-yyyy 형식
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("yyyy/mm/dd 형식" + now.format(formatter3));
    }

}
