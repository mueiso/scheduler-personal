package com.myproject.schedulerpersonal.schedule.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	// 1. 일정 생성
	@PostMapping("/schedules")
	public CommonResponse<ScheduleResponseDto> saveSchedule (Long userId, ScheduleRequestDto scheduleRequestDto) {

		return CommonResponse.of(SuccessCode.CREATE_SCHEDULE_SUCCESS, scheduleService.createSchedule(userId, scheduleRequestDto));
	}

	// 2. 일정 목록 조회
	// @GetMapping("/{userId}/schedules")
	// public CommonResponse<List<ScheduleResponseDto>> getScheduleList (User user) {
	//
	// 	return CommonResponse.of(SuccessCode.GET_ALL_SCHEDULE_SUCCESS, scheduleService.getAllSchedules(user));
	// }

	// 일정 단건 상세 조회

	// 일정 수정

	// 일정 삭제




}
