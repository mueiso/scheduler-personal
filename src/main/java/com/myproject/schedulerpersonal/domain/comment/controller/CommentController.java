package com.myproject.schedulerpersonal.domain.comment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentRequestDto;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentResponseDto;
import com.myproject.schedulerpersonal.domain.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// 1. 댓글 저장
	@PostMapping("/schedules/{scheduleId}/comments")
	public CommonResponse<CommentResponseDto> saveComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {

		return CommonResponse.of(SuccessCode.SAVE_COMMENT_SUCCESS, commentService.createComment(scheduleId, commentRequestDto));
	}

	// 2. 일정 상세 조회 시 모든 댓글 조회
	@GetMapping("/schedules/{scheduleId}/comments")
	public CommonResponse<List<CommentResponseDto>> getAllComments(@PathVariable Long scheduleId) {

		return CommonResponse.of(SuccessCode.GET_ALL_COMMENTS_SUCCESS, commentService.getCommentList(scheduleId));
	}

	// 3. 댓글 수정

	// 4. 댓글 삭제




}
