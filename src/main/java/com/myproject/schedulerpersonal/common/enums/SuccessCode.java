package com.myproject.schedulerpersonal.common.enums;

import org.springframework.http.HttpStatus;

public enum SuccessCode implements BaseCode {

	// User
	CREATE_USER_SUCCESS(HttpStatus.CREATED,"유저를 생성했습니다."),

	// Schedule
	CREATE_SCHEDULE_SUCCESS(HttpStatus.CREATED, "일정이 생성되었습니다."),
	GET_ALL_SCHEDULES_SUCCESS(HttpStatus.OK, "일정 목록을 조회합니다."),
	GET_SCHEDULE_SUCCESS(HttpStatus.FOUND,"일정 상세정보를 조회합니다."),
	UPDATE_SCHEDULE_SUCCESS(HttpStatus.OK,"일정을 수정했습니다."),
	DELETE_SCHEDULE_SUCCESS(HttpStatus.OK, "일정을 삭제했습니다."),

	// Comment
	SAVE_COMMENT_SUCCESS(HttpStatus.CREATED,"댓글을 저장했습니다."),
	GET_ALL_COMMENTS_SUCCESS(HttpStatus.FOUND,"모든 댓글을 조회합니다."),
	UPDATE_COMMENT_SUCCESS(HttpStatus.OK,"댓글을 수정했습니다."),
	DELETE_COMMENT_SUCCESS(HttpStatus.OK,"댓글을 삭제했습니다."),

	// Reply
	SAVE_REPLY_SUCCESS(HttpStatus.CREATED,"대댓글을 저장했습니다."),
	GET_REPLY_SUCCESS(HttpStatus.FOUND,"대댓글을 조회합니다."),
	UPDATE_REPLY_SUCCESS(HttpStatus.OK,"대댓글을 수정했습니다."),
	DELETE_REPLY_SUCCESS(HttpStatus.OK,"대댓글을 삭제했습니다.");


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
