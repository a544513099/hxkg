package com.model.Industryplan;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-27 下午 12:44
 **/
@Entity
@Table(name = "leave_message")
public class LeaveMessage {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "date")
    private Date date = new Date();
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "postion")
    private String position;
    @Column(name = "content")
    private String content;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LeaveMessage() {

    }
}
