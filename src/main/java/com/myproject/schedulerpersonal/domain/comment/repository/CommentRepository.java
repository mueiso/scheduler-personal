package com.myproject.schedulerpersonal.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
