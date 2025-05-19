package com.myproject.schedulerpersonal.domain.reply.dto;

import java.time.LocalDateTime;

import com.myproject.schedulerpersonal.domain.reply.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyWithParentCommentResponseDto {

	private final Long commentId;
	private final String commentContent;
	private final ReplyDto replyDto;

	// 정적 중첩 클래스 (Dto 안의 Dto)
	@Getter
	@AllArgsConstructor
	public static class ReplyDto {

		private final Long id;
		private final String content;
		private final Long userId;
		private final Long scheduleId;
		private final LocalDateTime createdAt;
		private final LocalDateTime updatedAt;

		// from 활용해 Dto 변환 생성은 Dto 안에서 끝내기
		public static ReplyDto from(Reply reply) {
			return new ReplyDto(
				reply.getId(),
				reply.getContent(),
				reply.getUser().getId(),
				reply.getSchedule().getId(),
				reply.getCreatedAt(),
				reply.getUpdatedAt()
			);
		}
	}
}
