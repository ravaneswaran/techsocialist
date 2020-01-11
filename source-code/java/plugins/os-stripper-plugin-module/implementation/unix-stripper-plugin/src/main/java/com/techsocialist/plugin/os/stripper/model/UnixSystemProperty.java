package com.techsocialist.plugin.os.stripper.model;

import com.techsocialist.plugin.os.stripper.model.api.ISystemProperty;

public class UnixSystemProperty implements ISystemProperty {

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
