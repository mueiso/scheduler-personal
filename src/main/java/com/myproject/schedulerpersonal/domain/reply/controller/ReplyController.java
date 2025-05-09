package com.myproject.schedulerpersonal.domain.reply.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyRequestDto;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyResponseDto;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyWithParentCommentResponseDto;
import com.myproject.schedulerpersonal.domain.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
class ReplyController {

	private final ReplyService replyService;

	// 1. 대댓글 작성
	@PostMapping("/schedules/{scheduleId}/comments/{commentId}/replies")
	public CommonResponse<ReplyResponseDto> createReply(
		@PathVariable Long scheduleId,
		@PathVariable Long commentId,
		@RequestBody ReplyRequestDto replyRequestDto) {

		return CommonResponse.of(SuccessCode.SAVE_REPLY_SUCCESS, replyService.saveReply(scheduleId, commentId, replyRequestDto));
	}

	// 2. 대댓글 조회 (부모 댓글 하위에 함께 조회)
	@GetMapping("/comments/{commentId}/replies")
	public CommonResponse<ReplyWithParentCommentResponseDto> getReplyWithComment(@PathVariable Long commentId) {

		return CommonResponse.of(SuccessCode.GET_REPLY_SUCCESS, replyService.getReplyUnderComment(commentId));
	}

	// 3. 대댓글 수정
	@PatchMapping("/replies/{replyId}")
	public CommonResponse<Void> updateReply(@PathVariable Long replyId, @RequestBody ReplyRequestDto replyRequestDto) {

		replyService.editReply(replyId, replyRequestDto);

		return CommonResponse.of(SuccessCode.UPDATE_REPLY_SUCCESS);
	}

	// 4. 대댓글 삭제
	@DeleteMapping("replies/{replyId}")
	public CommonResponse<Void> deleteReply(@PathVariable Long replyId) {

		replyService.deleteReply(replyId);

		return CommonResponse.of(SuccessCode.DELETE_REPLY_SUCCESS);
	}

}
