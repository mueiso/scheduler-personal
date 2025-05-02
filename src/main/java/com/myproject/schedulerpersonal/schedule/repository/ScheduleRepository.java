package com.myproject.schedulerpersonal.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
