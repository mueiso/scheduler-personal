package com.myproject.schedulerpersonal.domain.schedule.entity;

import com.myproject.schedulerpersonal.common.entity.BaseEntity;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public Schedule (String title, String content, User user) {

		this.title = title;
		this.content = content;
		this.user = user;
	}

	// public void updateSchedule () {
	//
	// 	if (!StringUtils.isEmpty(title)) {
	// 		this.title = title;
	// 	}
	//
	// 	if (!StringUtils.isEmpty(content)) {
	// 		this.content = content;
	// 	}
	// }


}
