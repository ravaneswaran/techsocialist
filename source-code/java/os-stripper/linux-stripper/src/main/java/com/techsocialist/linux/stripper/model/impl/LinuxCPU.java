package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.linux.ILinuxCPU;

public class LinuxCPU implements ILinuxCPU {

    private String detail;

    @Override
    public void setCPUDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String getCPUDetail() {
        return this.detail;
    }
}
