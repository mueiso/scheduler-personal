package com.myproject.schedulerpersonal.domain.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.schedule.repository.ScheduleRepository;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;
	private final EntityFetcher entityFetcher;

	// 일정 생성
	@Transactional
	public ScheduleResponseDto createSchedule(Long userId, ScheduleRequestDto scheduleRequestDto) {

		User user = entityFetcher.getUserOrThrow(userId);

		Schedule schedule = Schedule.builder()
			.title(scheduleRequestDto.getTitle())
			.content(scheduleRequestDto.getContent())
			.user(user)
			.build();

		Schedule savedSchedule = scheduleRepository.save(schedule);

		return new ScheduleResponseDto(savedSchedule);
	}

	// 일정 목록 조회
	@Transactional
	public List<ScheduleResponseDto> getAllSchedules(Long userId) {

		List<Schedule> scheduleList = scheduleRepository.findAllByUserId(userId);

		if (scheduleList.isEmpty()) {
			throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
		}

		// List<Schedule> → List<ScheduleResponseDto>로 변환된 리스트를 반환
		return scheduleList.stream()
			.map(ScheduleResponseDto::new)
			.toList();
	}


}
