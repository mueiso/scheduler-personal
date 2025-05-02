package com.myproject.schedulerpersonal.common.enums;

import org.springframework.http.HttpStatus;

public enum SuccessCode implements BaseCode {

	// User
	CREATE_USER_SUCCESS(HttpStatus.CREATED,"유저를 성공적으로 생성했습니다."),

	// Schedule
	CREATE_SCHEDULE_SUCCESS(HttpStatus.CREATED, "일정이 생성되었습니다."),
	GET_ALL_SCHEDULE_SUCCESS(HttpStatus.OK, "일정 목록을 조회합니다."),
	GET_SCHEDULE_SUCCESS(HttpStatus.FOUND,"일정 상세정보를 조회합니다."),
	UPDATE_SCHEDULE_SUCCESS(HttpStatus.OK,"일정을 수정하였습니다.");

	private final HttpStatus httpStatus;
	private final String message;

	SuccessCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	@Override
	public HttpStatus getStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return message;
	}


}
