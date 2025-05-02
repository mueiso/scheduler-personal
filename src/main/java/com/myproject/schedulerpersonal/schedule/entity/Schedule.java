package com.myproject.schedulerpersonal.schedule.entity;

import org.springframework.util.StringUtils;

import com.myproject.schedulerpersonal.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private String writerId;

	@Column(nullable = true)
	private Long commentCount;

	@Builder
	public Schedule (String title, String content, String writerId) {

		this.title = title;
		this.content = content;
		this.writerId = writerId;
	}

	@Builder
	public Schedule (String title, String content, String writerId, Long commentCount) {

		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.commentCount = commentCount;
	}

	public void updateSchedule () {

		if (!StringUtils.isEmpty(title)) {
			this.title = title;
		}

		if (!StringUtils.isEmpty(content)) {
			this.content = content;
		}
	}





}
