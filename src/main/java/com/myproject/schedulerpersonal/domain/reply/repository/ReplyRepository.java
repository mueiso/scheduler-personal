package com.myproject.schedulerpersonal.domain.reply.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.reply.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	Optional<Reply> findReplyById(Long id);

	Optional<Reply> findReplyByComment(Comment comment);

	boolean existsByComment(Comment comment);

}
