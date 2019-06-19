package com.java.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Likes")
public class Like implements Serializable{
	/*@Id
	@GeneratedValue
	int id;*/
	@Id
	int userId;
	@Id
	int postId;

	public Like() {
	}

	public Like(int userId, int postId) {
		this.userId = userId;
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Like{" +
				"userId=" + userId +
				", postId=" + postId +
				'}';
	}
}
