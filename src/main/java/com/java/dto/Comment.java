package com.java.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Comment {
	@Id
	@GeneratedValue
	int id;
	@NotNull
	LocalDateTime commentDate;
	@Size(min=1, max=250)
	String description;
	@NotNull
	int authorId;
	@NotNull
	int postId;

	public Comment() {
	}

	public Comment(@NotNull LocalDateTime commentDate, @Size(min = 1, max = 250) String description, @NotNull int authorId, @NotNull int postId) {
		this.commentDate = commentDate;
		this.description = description;
		this.authorId = authorId;
		this.postId = postId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", commentDate=" + commentDate +
				", description='" + description + '\'' +
				", authorId=" + authorId +
				", postId=" + postId +
				'}';
	}
}
