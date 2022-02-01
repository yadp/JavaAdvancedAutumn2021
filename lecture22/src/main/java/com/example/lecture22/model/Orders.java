package com.example.lecture22.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Orders {
    @Id
    private Long id;
    private Long userid;
    private Long bookid;
    @JsonIgnore
    private User user;
    @JsonIgnore
    private Book book;

    public Orders(Long userid, Long bookid) {
        this.userid = userid;
        this.bookid = bookid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.userid = user.getId();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.bookid = book.getId();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
}
