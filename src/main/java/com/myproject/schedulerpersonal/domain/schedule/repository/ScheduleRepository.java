package com.myproject.schedulerpersonal.domain.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findAllByUser(User user);

	Optional<Schedule> findScheduleById(Long id);

	// commentCount 증가
	@Modifying
	@Query("UPDATE Schedule s SET s.commentCount = s.commentCount+1 WHERE s.id = :scheduleId")
	void increaseCommentCounts(Long scheduleId);

	// commentCount 감소
	@Modifying
	@Query("UPDATE Schedule s SET s.commentCount = s.commentCount-1 WHERE s.id = :scheduleId")
	void decreaseCommentCounts(Long scheduleId);

}
