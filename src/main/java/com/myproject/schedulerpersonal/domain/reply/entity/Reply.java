package com.myproject.schedulerpersonal.domain.reply.entity;

import org.springframework.util.StringUtils;

import com.myproject.schedulerpersonal.common.entity.BaseEntity;
import com.myproject.schedulerpersonal.domain.comment.entity.Comment;
import com.myproject.schedulerpersonal.domain.schedule.entity.Schedule;
import com.myproject.schedulerpersonal.domain.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "reply")
public class Reply extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id")
	private Comment comment;

	/*
	대댓글에 또 대대댓글을 달기 위한 자기참조 방법
		→ @ManyToOne
		  private Reply parentReply;
	 */

	@Builder
	public Reply(String content, User user, Schedule schedule, Comment comment) {

		this.content = content;
		this.user = user;
		this.schedule = schedule;
		this.comment = comment;
	}

	public void updateReply(String content) {

		if(!StringUtils.isEmpty(content)) {
			this.content = content;
		}
	}

}
