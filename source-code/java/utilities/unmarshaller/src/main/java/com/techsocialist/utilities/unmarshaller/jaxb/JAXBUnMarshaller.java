package com.techsocialist.utilities.unmarshaller.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class JAXBUnMarshaller<T> {

	private static JAXBUnMarshaller unMarshaller;

	private JAXBUnMarshaller() {
	}

	private T toInstance(Class<?> clazz, String xmlString)
			throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream inputStream = new ByteArrayInputStream(
				xmlString.getBytes(StandardCharsets.UTF_8));
		return (T)jaxbUnmarshaller.unmarshal(inputStream);
	}

	/**
	 * @param clazz
	 * @param xmlString
	 * @return
	 * @throws JAXBException
	 */
	public static Object unMarshall(Class<?> clazz, String xmlString)
			throws JAXBException {
		return JAXBUnMarshaller.unMarshaller.toInstance(clazz,
				xmlString);
	}

	static {
		JAXBUnMarshaller.unMarshaller = new JAXBUnMarshaller();
	}

}
