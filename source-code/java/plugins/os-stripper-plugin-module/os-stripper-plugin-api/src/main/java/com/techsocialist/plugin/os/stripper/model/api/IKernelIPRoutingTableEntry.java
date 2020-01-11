package com.techsocialist.plugin.os.stripper.model.api;

public interface IKernelIPRoutingTableEntry {

    public String getDestination();

    public void setDestination(String destination);

    public String getGateway();

    public void setGateway(String gateway);

    public String getGenMask();

    public void setGenMask(String genMask);

    public String getFlags();

    public void setFlags(String flags);

    public String getMSS();

    public void setMSS(String mss);

    public String getWindow();

    public void setWindow(String window);

    public String getIRTT();

    public void setIRTT(String irtt);

    public String getIFace();

    public void setIFace(String iFace);
}
