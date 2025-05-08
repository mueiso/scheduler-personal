package com.myproject.schedulerpersonal.domain.reply.service;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyRequestDto;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyResponseDto;
import com.myproject.schedulerpersonal.domain.reply.dto.ReplyWithParentCommentResponseDto;
import com.myproject.schedulerpersonal.domain.reply.entity.Reply;
import com.myproject.schedulerpersonal.domain.reply.repository.ReplyRepository;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;
	private final EntityFetcher entityFetcher;

	// 1. 대댓글 작성
	@Transactional
	public ReplyResponseDto saveReply(Long scheduleId, Long commentId, ReplyRequestDto replyRequestDto) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(scheduleId);
		User user = entityFetcher.getUserOrThrow(schedule.getUser().getId());
		Comment comment = entityFetcher.getCommentOrThrow(commentId);

		if (replyRepository.existsByComment(comment)) {
			throw new CustomException(ErrorCode.REPLY_ALREADY_EXISTS);
		}

		Reply reply = Reply.builder()
			.content(replyRequestDto.getContent())
			.user(user)
			.schedule(schedule)
			.comment(comment)
			.build();

		replyRepository.save(reply);

		return new ReplyResponseDto(reply);
	}

	// 2. 대댓글 조회 (부모 댓글 하위에 함께 조회)
	@Transactional
	public ReplyWithParentCommentResponseDto getReplyUnderComment(Long commentId) {

		Comment comment = entityFetcher.getCommentOrThrow(commentId);

		Reply reply = replyRepository.findReplyByComment(comment)
			.orElseThrow(() -> new CustomException(ErrorCode.REPLY_NOT_FOUND));

		ReplyWithParentCommentResponseDto.ReplyDto replyDto = ReplyWithParentCommentResponseDto.ReplyDto.from(reply);

		return new ReplyWithParentCommentResponseDto(
			comment.getId(),
			comment.getContent(),
			replyDto
		);

	}

	// 3. 대댓글 수정
	@Transactional
	public void editReply(Long replyId, ReplyRequestDto replyRequestDto) {

		Reply reply = entityFetcher.getReplyOrThrow(replyId);

		reply.updateReply(replyRequestDto.getContent());
	}

	// 4. 대댓글 삭제
	@Transactional
	public void deleteReply(Long replyId) {

		Reply reply = entityFetcher.getReplyOrThrow(replyId);

		replyRepository.delete(reply);
	}

}
