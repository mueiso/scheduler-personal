package com.myproject.schedulerpersonal.domain.schedule.dto;

import java.time.LocalDateTime;

import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

	private final Long id;
	private final String title;
	private final String content;
	private final String userName;
	private final int commentCount;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;

	public ScheduleResponseDto (Schedule schedule) {

		this.id = schedule.getId();
		this.title = schedule.getTitle();
		this.content = schedule.getContent();
		this.userName = schedule.getUser().getUserName();
		this.commentCount = schedule.getCommentCount();
		this.createdAt = schedule.getCreatedAt();
		this.updatedAt = schedule.getUpdatedAt();
	}

}