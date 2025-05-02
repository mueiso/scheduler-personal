package com.myproject.schedulerpersonal.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findAllByWriterId(String writerId);

}
