package com.myproject.schedulerpersonal.schedule.dto;

import java.time.LocalDateTime;

import com.myproject.schedulerpersonal.schedule.entity.Schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

	private final Long id;

	private final String title;

	private final String content;

	private final String userName;

	private final LocalDateTime createdAt;

	private final LocalDateTime updatedAt;

	public ScheduleResponseDto (Schedule schedule) {

		this.id = schedule.getId();
		this.title = schedule.getTitle();
		this.content = schedule.getContent();
		this.userName = schedule.getUser().getUserName();
		this.createdAt = schedule.getCreatedAt();
		this.updatedAt = schedule.getUpdatedAt();
	}

}