package com.java.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.JsonAdapter;



@Entity
@Table(name="users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames={"username"}),
				@UniqueConstraint(columnNames={"email"})
		}
)
@DynamicUpdate(value=true)
public class User implements Serializable{
	@GeneratedValue
	@Id
	private
	int id;
	@NotNull
	@Column(nullable=false)
	@Size(min=3, max=30)
	private

	String username;
	@NotNull
	String password;
	@NotNull
	String email;
	@NotNull
	String firstName;
	@NotNull
	String lastName;
	String profilePic;
	@OneToMany(mappedBy="author", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnoreProperties("author")
	List<Post> postList; //Post.id?
	@OneToMany(mappedBy="userId", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Like> likes;

	public User() {
	}

	public User(@NotNull @Size(min = 3, max = 30) String username, @NotNull String password, @NotNull String email, @NotNull String firstName, @NotNull String lastName, String profilePic, List<Post> postList, List<Like> likes) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePic = profilePic;
		this.postList = postList;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", profilePic='" + profilePic + '\'' +
				", postList=" + postList +
				", likes=" + likes +
				'}';
	}
}
