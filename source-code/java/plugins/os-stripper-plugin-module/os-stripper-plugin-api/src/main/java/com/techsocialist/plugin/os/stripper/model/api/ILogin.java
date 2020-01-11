package com.techsocialist.plugin.os.stripper.model.api;

public interface ILogin {

    public String getUserId();

    public void setUserId(String userId);

    public String getUserName();

    public void setUserName(String userName);

    public String getPROC();

    public void setPROC(String proc);

    public String getPWDLock();

    public void setPWDLock(String pwdLock);

    public String getPWDDeny();

    public void setPWDDeny(String pwdDeny);

    public String getLastLogin();

    public void setLastLogin(String lastLogin);

    public String getGECOS();

    public void setGECOS(String gecos);
}
