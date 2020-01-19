package com.techsocialist.plugin.unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.techsocialist.plugin.unmarshaller.impl.AbstractUnmarshallerPlugin;

public class GoogleUnmarshallerPlugin extends AbstractUnmarshallerPlugin {

    @Override
    public Object unmarshall(String source, Class<?> clazz) throws Exception {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(source, clazz);
    }
}
