package com.techsocialist.plugin.unmarshaller.api;

public interface UnmarshallerPluginAPI {

    public Object unmarshall(String source, Class<?> clazz) throws Exception;

}
