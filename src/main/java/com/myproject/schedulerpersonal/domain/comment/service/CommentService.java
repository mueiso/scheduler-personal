package com.myproject.schedulerpersonal.domain.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentRequestDto;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentResponseDto;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.comment.repository.CommentRepository;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final EntityFetcher entityFetcher;

	// 1. 댓글 저장
	@Transactional
	public CommentResponseDto createComment(
		Long scheduleId,
		CommentRequestDto commentRequestDto) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(scheduleId);
		User user = schedule.getUser();

		Comment comment = Comment.builder()
			.content(commentRequestDto.getContent())
			.user(user)
			.schedule(schedule)
			.build();

		commentRepository.save(comment);

		return new CommentResponseDto(comment);

	}

	// 2. TODO 일정 상세 조회 시 모든 댓글 조회 (오름차순)
	@Transactional
	public List<CommentResponseDto> getCommentList(Long scheduleId) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(scheduleId);

		List<Comment> commentList = commentRepository.findAllBySchedule(schedule);

		if(commentList.isEmpty()) {
			throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
		}

		// List<Comment> → List<CommentResponseDto>로 변환해서 반환
		return commentList.stream()
			.map(CommentResponseDto::new)
			.toList();
	}

	// 3. 댓글 수정
	@Transactional
	public void editComment(Long commentId, CommentRequestDto commentRequestDto) {

		Comment comment = entityFetcher.getCommentOrThrow(commentId);

		comment.updateComment(commentRequestDto.getContent());

	}


	// 4. 댓글 삭제
	public void deleteComment(Long commentId) {

		Comment comment = entityFetcher.getCommentOrThrow(commentId);

		commentRepository.delete(comment);
	}

}
