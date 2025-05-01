package com.myproject.schedulerpersonal.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.schedule.entity.Schedule;

public interface ScheduleRespository extends JpaRepository<Schedule, Long> {

	Optional<Schedule> findScheduleById (Long id);

	List<Schedule> findAll (Schedule schedule);

}
