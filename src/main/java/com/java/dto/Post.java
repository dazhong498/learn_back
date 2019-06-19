package com.java.dto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;




@Entity
public class Post {
	@Id
	@GeneratedValue
	int pId;
	@JsonSerialize(using = JsonDateSerializer.class)
	@NotNull
	LocalDateTime postedDate;
	// tags;
	@Size(min = 1, max = 250)
	String description;
	String picture;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	/*@JoinColumns({
		@JoinColumn(name="id", referencedColumnName="id"),
		@JoinColumn(name="username", referencedColumnName="username"),
		@JoinColumn(name="profilePic", referencedColumnName="profilePic")
	})*/
	//@NotNull
	User author;
	//int authorId;
	@OneToMany(mappedBy = "postId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Like> likedBy; // userId
	/*
	 * @OneToMany(mappedBy="userId") List<Like> like;
	 */
//	@Override
//	public String toString() {
//		return "Post [pId=" + pId + ", postedDate=" + postedDate + ", description=" + description + ", picture="
//				+ picture + ", author=" + author.getUsername() + ", likedBy=" + likedBy + "]";
//	}
//


	public Post() {
	}

	public Post(@NotNull LocalDateTime postedDate, @Size(min = 1, max = 250) String description, String picture, User author, List<Like> likedBy) {
		this.postedDate = postedDate;
		this.description = description;
		this.picture = picture;
		this.author = author;
		this.likedBy = likedBy;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public LocalDateTime getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDateTime postedDate) {
		this.postedDate = postedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Like> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(List<Like> likedBy) {
		this.likedBy = likedBy;
	}

	@Override
	public String toString() {
		return "Post{" +
				"pId=" + pId +
				", postedDate=" + postedDate +
				", description='" + description + '\'' +
				", picture='" + picture + '\'' +
				", author=" + author +
				", likedBy=" + likedBy +
				'}';
	}
}

class JsonDateSerializer extends JsonSerializer<LocalDateTime> {
	private static final  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String formattedDate = date.format(formatter);
		gen.writeString(formattedDate);
	}
}