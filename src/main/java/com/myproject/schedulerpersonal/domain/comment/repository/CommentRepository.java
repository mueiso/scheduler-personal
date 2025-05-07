package com.myproject.schedulerpersonal.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	/*
	1. JPA 의 메서드 네이밍 규칙 활용해서 오름차순 정렬하는 방법
		→ 메서드 이름에 OrderBy 추가
		  List<Comment> findAllByScheduleOrderByCreatedAtAsc(Schedule schedule);

	2. @Query 어노테이션 활용
		→ 쿼리 직접 작성
	 */
	@Query("SELECT c FROM Comment c WHERE c.schedule = :schedule ORDER BY c.createdAt ASC")
	List<Comment> findAllBySchedule(@Param("schedule") Schedule schedule);

	Optional<Comment> findCommentById(Long id);

}
