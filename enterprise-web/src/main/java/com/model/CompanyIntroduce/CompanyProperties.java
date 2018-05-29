package com.model.CompanyIntroduce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-28 下午 11:33
 **/
@Entity
@Table(name = "CompanyProperties")
public class CompanyProperties {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public CompanyProperties() {
    }

    @Override
    public String toString() {
        return "CompanyProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
