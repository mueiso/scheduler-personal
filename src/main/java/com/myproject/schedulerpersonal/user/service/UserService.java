package com.myproject.schedulerpersonal.user.service;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.user.dto.UserRequestDto;
import com.myproject.schedulerpersonal.user.dto.UserResponseDto;
import com.myproject.schedulerpersonal.user.entity.User;
import com.myproject.schedulerpersonal.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	// 유저 생성
	@Transactional
	public UserResponseDto createUser(UserRequestDto userRequestDto) {

		User user = User.builder()
			.userName(userRequestDto.getUserName())
			.build();

		User savedUser = userRepository.save(user);

		return new UserResponseDto(savedUser.getId(), savedUser.getUserName());
	}


}
