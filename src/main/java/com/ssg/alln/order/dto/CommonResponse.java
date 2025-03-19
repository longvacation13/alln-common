package com.ssg.alln.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonResponse<T> {

    @Schema(title = "결과코드", requiredMode = Schema.RequiredMode.REQUIRED)
    private String resultCode;

    @Schema(title = "결과내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String resultMsg;

    @Schema(title = "결과상세내용", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String resultDesc;

    @Schema(title = "결과데이터", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private T resultData;

}
