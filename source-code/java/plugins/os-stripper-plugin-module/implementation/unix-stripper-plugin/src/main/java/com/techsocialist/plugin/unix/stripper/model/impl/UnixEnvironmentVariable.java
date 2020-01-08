package com.techsocialist.plugin.unix.stripper.model.impl;

import com.techsocialist.plugin.os.stripper.model.api.IEnvironmentVariable;

public class UnixEnvironmentVariable implements IEnvironmentVariable {

    private String key;

    private String value;

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
