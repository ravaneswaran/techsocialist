package com.techsocialist.plugin.unmarshaller.api;

public interface IUnmarshallerPlugin {

    public Object unmarshall(String source, Class<?> clazz) throws Exception;

}
