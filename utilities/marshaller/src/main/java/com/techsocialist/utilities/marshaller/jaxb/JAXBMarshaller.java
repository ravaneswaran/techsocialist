package com.techsocialist.utilities.marshaller.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class JAXBMarshaller {
	
	private static JAXBMarshaller marshaller;

	private JAXBMarshaller() {
	}

	/**
	 * @param arg
	 * @return
	 * @throws JAXBException
	 */
	private String toXml(Object arg) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(arg.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(arg, writer);
		return writer.toString();
	}

	/**
	 * @param arg
	 * @return
	 * @throws JAXBException
	 */
	public static String marshall(Object arg) throws JAXBException {
		return JAXBMarshaller.marshaller.toXml(arg);
	}
	
	static {
		JAXBMarshaller.marshaller = new JAXBMarshaller();
	}
}
