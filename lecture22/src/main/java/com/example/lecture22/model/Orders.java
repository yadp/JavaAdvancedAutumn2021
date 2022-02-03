package com.example.lecture22.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

public class Orders {
    @Id
    private Long id;
    private Long userid;
    private Long bookid;

    public Orders(Long userid, Long bookid) {
        this.userid = userid;
        this.bookid = bookid;
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
