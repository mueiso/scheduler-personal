package com.myproject.schedulerpersonal.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CommonResponse<Object>> handleCustomException(CustomException e) {
		log.error("CustomException: {}", e.getMessage());
		return ResponseEntity
			.status(e.getErrorCode().getStatus())
			.body(CommonResponse.of(e.getErrorCode()));

	}

	// @Valid 예외처리
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CommonResponse<Object>> handldValidException(MethodArgumentNotValidException e) {
		return ResponseEntity
			.status(ErrorCode.INVALID_INPUT_VALUE.getStatus())
			.body(CommonResponse.of(ErrorCode.INVALID_INPUT_VALUE,
				e.getBindingResult().getFieldError().getDefaultMessage()));
	}

}
