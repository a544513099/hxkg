package com.model.CompanyIntroduce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-28 下午 11:27
 **/
@Entity
@Table(name = "company_culture")
public class CompanyCulture {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public CompanyCulture() {
    }

    @Override
    public String toString() {
        return "CompanyCulture{" +
                "id=" + id +
                ", date=" + date +
                ", photoUrl='" + photoUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
