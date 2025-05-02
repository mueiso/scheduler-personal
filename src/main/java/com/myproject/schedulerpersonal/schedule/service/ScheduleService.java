package com.myproject.schedulerpersonal.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.schedule.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRespository;

	// 일정 생성
	@Transactional
	public ScheduleResponseDto saveSchedule (ScheduleRequestDto scheduleRequestDto) {

		Schedule schedule = Schedule.builder()
			.title(scheduleRequestDto.getTitle())
			.content(scheduleRequestDto.getContent())
			.writerId(scheduleRequestDto.getWriterId())
			.build();

		Schedule savedSchedule = scheduleRespository.save(schedule);

		return new ScheduleResponseDto(savedSchedule);
	}

	// 일정 목록 조회
	@Transactional
	public List<ScheduleResponseDto> getAllSchedules (String writerId) {

		List<Schedule> scheduleList = scheduleRespository.findAllByWriterId(writerId);

		if (scheduleList.isEmpty()) {
			throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
		}

		// List<Schedule> → List<ScheduleResponseDto>로 변환된 리스트를 반환
		return scheduleList.stream()
			.map(ScheduleResponseDto::new)
			.toList();
	}



}
