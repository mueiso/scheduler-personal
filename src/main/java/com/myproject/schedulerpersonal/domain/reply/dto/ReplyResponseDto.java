package com.myproject.schedulerpersonal.domain.reply.dto;

import java.time.LocalDateTime;

import com.myproject.schedulerpersonal.domain.reply.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyResponseDto {

	private final Long id;
	private final String content;
	private final Long userId;
	private final Long scheduleId;
	private final Long commentId;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public ReplyResponseDto(Reply reply) {

		this.id = reply.getId();
		this.content = reply.getContent();
		this.userId = reply.getUser().getId();
		this.scheduleId = reply.getSchedule().getId();
		this.commentId = reply.getComment().getId();
		this.createdAt = reply.getCreatedAt();
		this.updatedAt = reply.getUpdatedAt();
	}

}
