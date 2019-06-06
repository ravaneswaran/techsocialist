package com.techsocialist.utilities.marshaller.jaxb;

import junit.framework.TestCase;

import javax.xml.bind.JAXBException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class TestJAXBMarshaller extends TestCase {

	public void testJAXBMarshall() throws JAXBException {
		TestEntity obj = new TestEntity();
		String xml = JAXBMarshaller.marshall(obj);
		assertNotNull(xml);
	}
}