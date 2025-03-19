package com.ssg.alln.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Schema(description = "주문 요청 DTO")
public class OrderRequest {

    @Schema(description = "주문 ID", example = "12345")
    private String orderId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "주문 날짜", example = "2024-10-30 23:59:59")
    private LocalDateTime orderDts;

    @Schema(description = "상품 정보 목록")
    private List<ItemInfo> itemInfo;

    @Getter
    @Setter
    @Schema(description = "상품 정보 DTO")
    public static class ItemInfo {

        @Schema(description = "상품 ID", example = "12345")
        private String itemId;

        @Schema(description = "상품명", example = "죠리퐁")
        private String itemNm;
    }
}
