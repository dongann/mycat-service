package com.mycat.app.entity.cuser;

/**
 * @FileName: MemberAccount
 * @Author: <a href="dongann@aliyun.com">dongchang'an</a>.
 * @CreateTime: 2019/1/7 下午11:26
 * @Version: v1.0
 * @description:
 */
public class MemberAccount {
    private long memberId;
    private String account;
    private int accountHash;

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
        this.account = account;
    }

    public int getAccountHash() {
        return accountHash;
    }

    public void setAccountHash(int accountHash) {
        this.accountHash = accountHash;
    }
}