package com.techsocialist.os.stripper.model.api.linux;

public interface ILinuxKernelIPRoutingTableEntry {

    public void setDestination(String destination);

    public String getDestination();

    public void setGateway(String gateway);

    public String getGateway();

    public void setGenMask(String genMask);

    public String getGenMask();

    public void setFlags(String flags);

    public String getFlags();

    public void setMSS(String mss);

    public String getMSS();

    public void setWindow(String window);

    public String getWindow();

    public void setIRTT(String irtt);

    public String getIRTT();

    public void setIFace(String iFace);

    public String getIFace();
}
