package com.ssg.alln.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonMsgEnum {

    서비스_요청_성공("요청 성공", "00"),

    //클라이언트 에러
    요청_파라미터_오류("파라미터 오류", "40"),

    //서버 에러
    서버_에러("내부 서버 오류", "99"),

    제휴사_서버_오류("제휴사 서버 오류", "98");

    private String msg;
    private String code;

}

