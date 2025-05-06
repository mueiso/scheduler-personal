package com.myproject.schedulerpersonal.domain.comment.service;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentRequestDto;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentResponseDto;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.comment.repository.CommentRepository;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final EntityFetcher entityFetcher;

	// 1. 댓글 저장
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

	// 2. 댓글 조회

	// 3. 댓글 수정

	// 4. 댓글 삭제

}
