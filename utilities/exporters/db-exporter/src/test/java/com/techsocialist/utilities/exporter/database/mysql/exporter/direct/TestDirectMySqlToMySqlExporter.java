package com.techsocialist.utilities.exporter.database.mysql.exporter.direct;

import com.techsocialist.utilities.exporter.database.DirectExporter;
import com.techsocialist.utilities.exporter.database.ExIm;
import com.techsocialist.utilities.exporter.database.Exporter;
import com.techsocialist.utilities.exporter.database.direct.DirectMySqlToMySqlExporter;
import com.techsocialist.utilities.exporter.database.direct.MySql;
import junit.framework.TestCase;

import java.sql.SQLException;

public class TestDirectMySqlToMySqlExporter extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testDirectMySqlToMySqlExporterInst(){
		DirectMySqlToMySqlExporter exporter = new DirectMySqlToMySqlExporter();
		assertTrue(exporter instanceof Exporter);
		assertTrue(exporter instanceof DirectExporter);
	}
	
	public void testSetGetSource(){
		DirectExporter exporter = new DirectMySqlToMySqlExporter();
        ExIm source = new MySql();
        exporter.setSource(source);
        ExIm source2 = exporter.getSource();
        assertEquals(source, source2);
	}
	
	public void testSetGetTarget(){
		DirectExporter exporter = new DirectMySqlToMySqlExporter();
        ExIm target = new MySql();
		exporter.setTarget(target);
        ExIm target2 = exporter.getTarget();
		assertEquals(target, target2);
	}
	
	public void testExport() throws SQLException, ClassNotFoundException{
		DirectExporter exporter = new DirectMySqlToMySqlExporter();
        exporter.setSource(new MySql("localhost", "tech_socialist", "root", "admin"));
        exporter.setTarget(new MySql("localhost", "test", "root", "admin"));
        exporter.export();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
