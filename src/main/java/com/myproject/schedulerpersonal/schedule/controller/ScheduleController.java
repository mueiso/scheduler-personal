package com.myproject.schedulerpersonal.schedule.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

	@PostMapping
	public CommonResponse<ScheduleResponseDto> createSchedule (@RequestBody @Valid ScheduleRequestDto requestDto) {
		scheduleService.
		return CommonResponse.of(SuccessCode.CREATE_SCHEDULE_SUCCESS);


	}




}
