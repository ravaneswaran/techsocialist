package com.techsocialist.utilities.unmarshaller.jaxb;

import com.techsocialist.utilities.marshaller.jaxb.JAXBMarshaller;
import junit.framework.TestCase;
import org.junit.Assert;

import javax.xml.bind.JAXBException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class TestJAXBUnMarshaller extends TestCase {

	public void testDuisUnMarshaller() throws JAXBException {
		TestEntity testEntity = new TestEntity();
		String xmlString = JAXBMarshaller.marshall(testEntity);
		Object object = JAXBUnMarshaller.unMarshall(TestEntity.class,
				xmlString);
		System.out.println(object);
		Assert.assertNotNull(object);
		Assert.assertTrue(object instanceof TestEntity);
	}

}
