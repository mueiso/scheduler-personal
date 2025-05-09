package com.myproject.schedulerpersonal.domain.comment.dto;

import java.time.LocalDateTime;

import com.myproject.schedulerpersonal.domain.comment.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponseDto {

	private final Long id;
	private final String content;
	private final Long userId;
	private final Long scheduleId;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public CommentResponseDto(Comment comment) {

		this.id = comment.getId();
		this.content = comment.getContent();
		this.userId = comment.getUser().getId();
		this.scheduleId = comment.getSchedule().getId();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
	}



}
