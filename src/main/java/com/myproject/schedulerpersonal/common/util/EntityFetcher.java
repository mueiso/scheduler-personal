package com.myproject.schedulerpersonal.common.util;

import org.springframework.stereotype.Component;

import com.myproject.schedulerpersonal.common.enums.ErrorCode;
import com.myproject.schedulerpersonal.common.exception.CustomException;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.comment.repository.CommentRepository;
import com.myproject.schedulerpersonal.domain.reply.entity.Reply;
import com.myproject.schedulerpersonal.domain.reply.repository.ReplyRepository;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.schedule.repository.ScheduleRepository;
import com.myproject.schedulerpersonal.domain.user.entity.User;
import com.myproject.schedulerpersonal.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityFetcher {

	private final UserRepository userRepository;
	private final ScheduleRepository scheduleRepository;
	private final CommentRepository commentRepository;
	private final ReplyRepository replyRepository;

	// User
	public User getUserOrThrow(Long userId) {
		return userRepository.findUserById(userId)
			.orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
	}

	// Schedule
	public Schedule getScheduleOrThrow(Long scheduleId) {
		return scheduleRepository.findScheduleById(scheduleId)
			.orElseThrow(() -> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));
	}

	// Comment
	public Comment getCommentOrThrow(Long commentId) {
		return commentRepository.findCommentById(commentId)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
	}

	// Reply
	public Reply getReplyOrThrow(Long replyId) {
		return replyRepository.findReplyById(replyId)
			.orElseThrow(() -> new CustomException(ErrorCode.REPLY_NOT_FOUND));
	}

}
