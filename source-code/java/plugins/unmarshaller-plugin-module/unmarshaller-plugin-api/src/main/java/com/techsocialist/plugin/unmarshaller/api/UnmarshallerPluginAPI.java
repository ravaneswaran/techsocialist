package com.techsocialist.plugin.unmarshaller.api;

public interface UnmarshallerPluginAPI {

    public Object toInstance(Class<?> clazz, String xmlString) throws Exception;

}
