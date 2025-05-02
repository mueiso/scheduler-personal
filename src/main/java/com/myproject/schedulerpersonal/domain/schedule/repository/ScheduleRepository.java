package com.myproject.schedulerpersonal.domain.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findAllByUser(User user);

	Optional<Schedule> findScheduleById(Long id);
}
