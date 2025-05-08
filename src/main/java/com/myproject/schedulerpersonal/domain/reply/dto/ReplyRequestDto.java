package com.myproject.schedulerpersonal.domain.reply.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyRequestDto {

	@NotBlank(message = "대댓글을 작성해주세요.")
	private final String content;

}
