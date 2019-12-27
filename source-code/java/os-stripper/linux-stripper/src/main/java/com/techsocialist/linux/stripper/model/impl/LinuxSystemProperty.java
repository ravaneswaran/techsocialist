package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.ILinuxSystemProperty;

public class LinuxSystemProperty implements ILinuxSystemProperty {

    private String key;

    private String value;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
