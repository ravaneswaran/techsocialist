package com.techsocialist.plugin.marshaller;

import com.google.gson.Gson;
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin;

public class GoogleMarshallerPlugin implements IMarshallerPlugin {

    @Override
    public String marshall(Object object) throws Exception {

        Gson gson = new Gson();
        return gson.toJson(object);

    }
}
