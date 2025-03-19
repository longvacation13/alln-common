package com.ssg.alln.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderResponse {
    private String orderId;
    private LocalDate orderDts;     // 이뮤터블 -> 멀티스레드 환경에서 안전함
    private List<ItemInfo> itemInfo;

    @Getter
    @Setter
    @Builder
    public static class ItemInfo {
        private String itemId;
    }
}
