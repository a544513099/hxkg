package com.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-27 上午 9:03
 * 时间轴
 **/
@Entity
@Table(name = "time_axis")
public class TimeAxis {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name = "context")
    private String context;
    @Column(name = "photo_url")
    private String photoUrl;

    public TimeAxis() {
    }

    @Override
    public String toString() {
        return "TimeAxis{" +
                "id=" + id +
                ", date=" + date +
                ", context='" + context + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
