package com.myproject.schedulerpersonal.domain.schedule.dto;

import java.util.List;

import com.myproject.schedulerpersonal.domain.comment.dto.CommentResponseDto;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleWithCommentListResponseDto {

	private final String title;

	private final String content;

	private final String userName;

	private final List<CommentResponseDto> commentResponseDtoList;

	public ScheduleWithCommentListResponseDto(Schedule schedule, List<CommentResponseDto> commentResponseDtoList) {

		this.title = schedule.getTitle();
		this.content = schedule.getContent();
		this.userName = schedule.getUser().getUserName();
		this.commentResponseDtoList = commentResponseDtoList;
	}
}
