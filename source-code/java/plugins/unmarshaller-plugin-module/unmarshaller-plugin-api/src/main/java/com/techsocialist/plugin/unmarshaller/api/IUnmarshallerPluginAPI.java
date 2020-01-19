package com.techsocialist.plugin.unmarshaller.api;

public interface IUnmarshallerPluginAPI {

    public Object unmarshall(String source, Class<?> clazz) throws Exception;

}
