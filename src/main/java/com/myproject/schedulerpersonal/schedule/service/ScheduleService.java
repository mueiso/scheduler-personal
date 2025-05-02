package com.myproject.schedulerpersonal.schedule.service;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.schedule.repository.ScheduleRepository;
import com.myproject.schedulerpersonal.user.entity.User;

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



	// @Transactional
	// public ScheduleResponseDto saveSchedule (Long userId, ScheduleRequestDto scheduleRequestDto) {
	//
	// 	// 엔티티 조회
	// 	User userEntity = entityFetcher.getUserOrThrow(userId);
	//
	// 	Schedule schedule = Schedule.builder()
	// 		.title(scheduleRequestDto.getTitle())
	// 		.content(scheduleRequestDto.getContent())
	// 		.user(userEntity.)
	// 		.build();
	//
	// 	Schedule savedSchedule = scheduleRepository.save(schedule);
	//
	// 	return new ScheduleResponseDto(savedSchedule);
	// }

	// 일정 목록 조회
	// @Transactional
	// public List<ScheduleResponseDto> getAllSchedules (String writerId) {
	//
	// 	List<Schedule> scheduleList = scheduleRepository.findAllByWriterId(writerId);
	//
	// 	if (scheduleList.isEmpty()) {
	// 		throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
	// 	}
	//
	// 	// List<Schedule> → List<ScheduleResponseDto>로 변환된 리스트를 반환
	// 	return scheduleList.stream()
	// 		.map(ScheduleResponseDto::new)
	// 		.toList();
	// }



}
