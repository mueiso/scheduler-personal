package com.myproject.schedulerpersonal.schedule.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.schedule.repository.ScheduleRespository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRespository scheduleRespository;

	// 일정 생성
	@Transactional
	public ScheduleResponseDto saveSchedule (ScheduleRequestDto scheduleRequestDto) {

		Schedule schedule = Schedule.builder()
			.title(scheduleRequestDto.getTitle())
			.content(scheduleRequestDto.getContent())
			.writerID(scheduleRequestDto.getWriterID())
			.build();

		Schedule savedSchedule = scheduleRespository.save(schedule);

		return new ScheduleResponseDto(savedSchedule);
	}

	// 일정 목록 조회
	@Transactional
	public List<ScheduleResponseDto> getAllSchedules () {

		List<Schedule> schduleList = scheduleRespository.findAll();

		List<ScheduleResponseDto> scheduleResponseDtoList = schduleList.stream()
			.map(schedule -> new ScheduleResponseDto(schedule))
			.collect(Collectors.toList());

		return scheduleResponseDtoList;

	}







}
