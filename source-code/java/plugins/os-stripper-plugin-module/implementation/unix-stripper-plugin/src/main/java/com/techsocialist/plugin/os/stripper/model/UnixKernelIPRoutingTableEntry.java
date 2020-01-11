package com.techsocialist.plugin.os.stripper.model;

import com.techsocialist.plugin.os.stripper.model.api.IKernelIPRoutingTableEntry;

public class UnixKernelIPRoutingTableEntry implements IKernelIPRoutingTableEntry {

    private String destination;

    private String gateway;

    private String genMask;

    private String flags;

    private String mss;

    private String window;

    private String irtt;

    private String iFace;

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @Override
    public String getGateway() {
        return this.gateway;
    }

    @Override
    public void setGenMask(String genMask) {
        this.genMask = genMask;
    }

    @Override
    public String getGenMask() {
        return this.genMask;
    }

    @Override
    public void setFlags(String flags) {
        this.flags = flags;
    }

    @Override
    public String getFlags() {
        return this.flags;
    }

    @Override
    public void setMSS(String mss) {
        this.mss = mss;
    }

    @Override
    public String getMSS() {
        return this.mss;
    }

    @Override
    public void setWindow(String window) {
        this.window = window;
    }

    @Override
    public String getWindow() {
        return this.window;
    }

    @Override
    public void setIRTT(String irtt) {
        this.irtt = irtt;
    }

    @Override
    public String getIRTT() {
        return this.irtt;
    }

    @Override
    public void setIFace(String iFace) {
        this.iFace = iFace;
    }

    @Override
    public String getIFace() {
        return this.iFace;
    }
}
