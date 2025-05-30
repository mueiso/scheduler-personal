package com.myproject.schedulerpersonal.domain.schedule.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.common.util.EntityFetcher;
import com.myproject.schedulerpersonal.domain.comment.dto.CommentResponseDto;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.comment.repository.CommentRepository;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleRequestDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleResponseDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.ScheduleWithCommentListResponseDto;
import com.myproject.schedulerpersonal.domain.schedule.dto.UpdateScheduleRequestDto;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.schedule.repository.ScheduleRepository;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;
	private final CommentRepository commentRepository;
	private final EntityFetcher entityFetcher;

	// 1. 일정 생성
	@Transactional
	public ScheduleResponseDto createSchedule(Long userId, ScheduleRequestDto requestDto) {

		User user = entityFetcher.getUserOrThrow(userId);

		Schedule schedule = Schedule.builder()
			.title(requestDto.getTitle())
			.content(requestDto.getContent())
			.user(user)
			.build();

		Schedule savedSchedule = scheduleRepository.save(schedule);

		return new ScheduleResponseDto(savedSchedule);
	}

	// 2. 일정 목록 조회
	@Transactional
	public List<ScheduleResponseDto> getAllSchedules(Long userId) {

		User user = entityFetcher.getUserOrThrow(userId);

		List<Schedule> scheduleList = scheduleRepository.findAllByUser(user);

		if (scheduleList.isEmpty()) {
			throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND, "일정을 찾을 수 없습니다.");
		}

		// List<Schedule> → List<ScheduleResponseDto>로 변환된 리스트를 반환
		return scheduleList.stream()
			.map(ScheduleResponseDto::new)
			.toList();
	}

	// 3. 일정 단건 상세 조회
	@Transactional
	public ScheduleWithCommentListResponseDto getScheduleWithCommentList(Long scheduleId) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(scheduleId);

		List<Comment> commentList = commentRepository.findAllBySchedule(schedule);

		List<CommentResponseDto> commentResponseDtoList = commentList.stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());

		return new ScheduleWithCommentListResponseDto(schedule, commentResponseDtoList);
	}

	// 4. 일정 수정
	@Transactional
	public void editSchedule(Long id, UpdateScheduleRequestDto updateScheduleDto) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(id);

		schedule.updateSchedule(updateScheduleDto.getTitle(), updateScheduleDto.getContent());
	}

	// 5. 일정 삭제
	@Transactional
	public void deleteSchedule(Long id) {

		Schedule schedule = entityFetcher.getScheduleOrThrow(id);

		// 필요 없어져서 주석처리
		// List<Comment> comment = commentRepository.findAllBySchedule(schedule);

		commentRepository.deleteCommentsBySchedule_Id(schedule.getId());

		scheduleRepository.delete(schedule);
	}

}
