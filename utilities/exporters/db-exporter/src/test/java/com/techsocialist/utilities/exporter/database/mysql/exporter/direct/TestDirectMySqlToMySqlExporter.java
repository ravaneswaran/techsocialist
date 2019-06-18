package com.techsocialist.utilities.exporter.database.mysql.exporter.direct;

import com.congruent.db.ExIm;
import com.congruent.db.exporter.Exporter;
import com.congruent.db.exporter.direct.mysql.DirectMySqlToMySqlExporter;
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
        exporter.setSource(new MySql("localhost", "training", "root", "admin"));
        exporter.setTarget(new MySql("localhost", "training", "root", "admin"));
        exporter.export();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
