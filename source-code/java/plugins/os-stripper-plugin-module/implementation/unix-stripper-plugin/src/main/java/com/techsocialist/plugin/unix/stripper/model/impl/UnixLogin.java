package com.techsocialist.plugin.unix.stripper.model.impl;

import com.techsocialist.plugin.os.stripper.model.api.ILogin;

public class UnixLogin implements ILogin {

    private String userId;
    private String userName;
    private String proc;
    private String pwdLock;
    private String pwdDeny;
    private String lastLogin;
    private String gecos;

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setPROC(String proc) {
        this.proc = proc;
    }

    @Override
    public String getPROC() {
        return this.proc;
    }

    @Override
    public void setPWDLock(String pwdLock) {
        this.pwdLock = pwdLock;
    }

    @Override
    public String getPWDLock() {
        return this.pwdLock;
    }

    @Override
    public void setPWDDeny(String pwdDeny) {
        this.pwdDeny = pwdDeny;
    }

    @Override
    public String getPWDDeny() {
        return this.pwdDeny;
    }

    @Override
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public void setGECOS(String gecos) {
        this.gecos = gecos;
    }

    @Override
    public String getGECOS() {
        return this.gecos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
