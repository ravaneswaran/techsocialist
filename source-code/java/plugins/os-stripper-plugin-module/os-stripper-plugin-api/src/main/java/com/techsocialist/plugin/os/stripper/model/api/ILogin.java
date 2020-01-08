package com.techsocialist.plugin.os.stripper.model.api;

public interface ILogin {

    public void setUserId(String userId);

    public String getUserId();

    public void setUserName(String userName);

    public String getUserName();

    public void setPROC(String proc);

    public String getPROC();

    public void setPWDLock(String pwdLock);

    public String getPWDLock();

    public void setPWDDeny(String pwdDeny);

    public String getPWDDeny();

    public void setLastLogin(String lastLogin);

    public String getLastLogin();

    public void setGECOS(String gecos);

    public String getGECOS();
}
