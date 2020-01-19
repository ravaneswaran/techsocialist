package com.techsocialist.plugin.unmarshaller;

import com.techsocialist.plugin.unmarshaller.impl.AbstractUnmarshallerPlugin;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JAXBUnmarshallerPlugin extends AbstractUnmarshallerPlugin {

    @Override
    public Object unmarshall(String source, Class<?> clazz) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new ByteArrayInputStream(
                source.getBytes(StandardCharsets.UTF_8));
        return jaxbUnmarshaller.unmarshal(inputStream);
    }
}
