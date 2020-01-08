package com.techsocialist.plugin.unix.stripper.model.impl;

import com.techsocialist.plugin.os.stripper.model.api.ICPU;

public class UnixCPU implements ICPU {

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
