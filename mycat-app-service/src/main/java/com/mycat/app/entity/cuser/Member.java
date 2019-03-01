package com.mycat.app.entity.cuser;

import java.util.Date;

/**
 * @FileName: Member
 * @Author: <a href="dongann@aliyun.com">dongchang'an</a>.
 * @CreateTime: 2019/1/7 下午11:26
 * @Version: v1.0
 * @description:
 */
public class Member {
    private long memberId;
    private String account;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private Date createdAt;
    private Date lastUpdate;

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? "" : account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? "" : nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? "" : mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? "" : email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt == null ? new Date() : createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}