package com.model.CompanyIntroduce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-28 下午 11:30
 **/
@Entity
@Table(name = "honor")
public class Honor {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "content")
    private String content;

    public Honor() {
    }

    @Override
    public String toString() {
        return "Honor{" +
                "id=" + id +
                ", date=" + date +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
