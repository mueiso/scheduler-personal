package com.myproject.schedulerpersonal.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

	@NotBlank(message = "제목을 입력해주세요.")
	private final String title;

	@NotBlank(message = "내용을 입력해주세요.")
	private final String content;

	@NotBlank(message = "작성자명을 입력해주세요.")
	private final String writerID;

}
