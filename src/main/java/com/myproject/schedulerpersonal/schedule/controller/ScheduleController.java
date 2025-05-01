package com.myproject.schedulerpersonal.schedule.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.schedule.service.ScheduleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

	private final ScheduleService scheduleService;

	// 일정 생성
	@PostMapping
	public CommonResponse<ScheduleResponseDto> createSchedule (@RequestBody @Valid ScheduleRequestDto requestDto) {

		return CommonResponse.of(SuccessCode.CREATE_SCHEDULE_SUCCESS, scheduleService.saveSchedule(requestDto));
	}

	// 일정 목록 조회
	@GetMapping
	public CommonResponse<List<ScheduleResponseDto>> getScheduleList () {

		return CommonResponse.of(SuccessCode.GET_ALL_SCHEDULE_SUCCESS, scheduleService.getAllSchedules());
	}

	// 일정 단건 상세 조회

	// 일정 수정

	// 일정 삭제




}
