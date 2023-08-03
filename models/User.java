package com.dea.codingdojo.blogplatform.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="First Name is required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String firstName;

    @NotEmpty(message="Last Name is required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Please insert a phone number")
    private Number number;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty(message="Username is required!")

    private String userName;

    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;

    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public User() {

    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts;

    @Column(updatable=false)
    @OneToMany(mappedBy="lead", fetch = FetchType.LAZY)
    private List<Post> postsLed;

    @Column(updatable=false)
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Comment> commentCreated;

    @Column(updatable=false)
    @OneToMany(mappedBy="author", fetch = FetchType.LAZY)
    private List<Comment> likeCreated;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirm() {
        return confirm;
    }
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Post> getPostsLed() {
        return postsLed;
    }

    public List<Comment> getCommentCreated() {
        return commentCreated;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setPostsLed(List<Post> postsLed) {
        this.postsLed = postsLed;
    }

    public void setCommentCreated(List<Comment> commentCreated) {
        this.commentCreated = commentCreated;
    }

    public User(Long id, Number number, String email, List<Comment> commentCreated) {
        this.id = id;
        this.number = number;
        this.email = email;
        this.commentCreated = commentCreated;
    }

    public User(Long id, List<Post> posts, List<Post> postsLed) {
        this.id = id;
        this.posts = posts;
        this.postsLed = postsLed;

    }
}
