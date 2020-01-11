package com.techsocialist.plugin.os.stripper.model;

import com.techsocialist.plugin.os.stripper.model.api.ISystemProperty;

public class UnixSystemProperty implements ISystemProperty {

    private String key;

    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
