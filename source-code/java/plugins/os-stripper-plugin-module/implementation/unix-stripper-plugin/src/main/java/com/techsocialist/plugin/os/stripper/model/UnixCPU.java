package com.techsocialist.plugin.os.stripper.model;

import com.techsocialist.plugin.os.stripper.model.api.ICPU;

public class UnixCPU implements ICPU {

    private String detail;

    @Override
    public String getCPUDetail() {
        return this.detail;
    }

    @Override
    public void setCPUDetail(String detail) {
        this.detail = detail;
    }
}
