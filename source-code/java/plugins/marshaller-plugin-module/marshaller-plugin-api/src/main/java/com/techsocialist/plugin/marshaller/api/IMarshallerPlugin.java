package com.techsocialist.plugin.marshaller.api;

public interface IMarshallerPlugin {

    public String marshall(Class<?> clazz) throws Exception;
}
