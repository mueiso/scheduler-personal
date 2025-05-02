package com.myproject.schedulerpersonal.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {

	@NotBlank(message = "유저명을 입력해주세요.")
	private final String userName;

}
