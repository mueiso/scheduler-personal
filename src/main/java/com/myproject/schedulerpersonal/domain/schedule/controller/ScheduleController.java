package com.myproject.schedulerpersonal.domain.schedule.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.schedulerpersonal.common.dto.CommonResponse;
import com.myproject.schedulerpersonal.common.enums.SuccessCode;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.UpdateScheduleRequestDto;
import com.myproject.schedulerpersonal.domain.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

	private final ScheduleService scheduleService;

	// 1. 일정 생성
	@PostMapping("/{userId}/schedules")
	public CommonResponse<ScheduleResponseDto> saveSchedule(@PathVariable Long userId, @RequestBody ScheduleRequestDto scheduleRequestDto) {

		return CommonResponse.of(SuccessCode.CREATE_SCHEDULE_SUCCESS, scheduleService.createSchedule(userId, scheduleRequestDto));
	}

	// 2. 일정 목록 조회
	@GetMapping("/{userId}/schedules")
	public CommonResponse<List<ScheduleResponseDto>> getScheduleList(@PathVariable Long userId) {

		return CommonResponse.of(SuccessCode.GET_ALL_SCHEDULES_SUCCESS, scheduleService.getAllSchedules(userId));
	}

	// 3. 일정 단건 상세 조회
	// @GetMapping("/schedules/{scheduleId}")
	// public CommonResponse<ScheduleResponseDto> getSchedule(@PathVariable Long scheduleId) {
	//
	// 	// return CommonResponse.of(SuccessCode.GET_SCHEDULE_SUCCESS, scheduleService.)
	// }

	// 4. 일정 수정
	@PatchMapping("/schedules/{scheduleId}")
	public CommonResponse<Void> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequestDto updateScheduleDto) {

		scheduleService.editSchedule(scheduleId, updateScheduleDto);

		return CommonResponse.of(SuccessCode.UPDATE_SCHEDULE_SUCCESS);
	}

	// 5. 일정 삭제
	@DeleteMapping("/schedules/{scheduleId}")
	public CommonResponse<Void> deleteSchedule(@PathVariable Long scheduleId) {

		scheduleService.deleteSchedule(scheduleId);

		return CommonResponse.of(SuccessCode.DELETE_SCHEDULE_SUCCESS);
	}


}
