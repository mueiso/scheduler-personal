package com.myproject.schedulerpersonal.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllBySchedule(Schedule schedule);

}
