package com.myproject.schedulerpersonal.domain.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.domain.user.dto.UserRequestDto;
import com.myproject.schedulerpersonal.domain.user.dto.UserResponseDto;
import com.myproject.schedulerpersonal.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	// 유저 생성
	@PostMapping
	public CommonResponse<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {

		return CommonResponse.of(SuccessCode.CREATE_USER_SUCCESS, userService.createUser(userRequestDto));
	}

}