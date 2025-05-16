package com.myproject.schedulerpersonal.common.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements BaseCode {

	// User
	USER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저를 찾을 수 없습니다."),
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST,"입력한 값의 형식이 잘못되었습니다."),

	// Schedule
	SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "일정을 찾을 수 없습니다."),

	// Comment
	COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND,"댓글을 찾을 수 없습니다."),

	// Reply
	REPLY_NOT_FOUND(HttpStatus.NOT_FOUND,"대댓글을 찾을 수 없습니다."),
	REPLY_ALREADY_EXISTS(HttpStatus.NOT_ACCEPTABLE,"대댓글이 이미 존재합니다.");

	private final HttpStatus httpStatus;
	private final String message;

	ErrorCode(HttpStatus httpStatus, String message) {
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

	// log 에도 에러메시지 출력하기 위한 메서드
	public String getMessage(Object... args) {
		return String.format(message, args);
	}

}
