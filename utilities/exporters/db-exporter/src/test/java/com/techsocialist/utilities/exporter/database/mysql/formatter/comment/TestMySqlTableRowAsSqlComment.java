package com.techsocialist.utilities.exporter.database.mysql.formatter.comment;

import com.techsocialist.utilities.exporter.database.Formatter;
import com.techsocialist.utilities.exporter.database.TableCell;
import com.techsocialist.utilities.exporter.database.TableRow;
import junit.framework.TestCase;

public class TestMySqlTableRowAsSqlComment extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testTableRowAsSqlCommentInst(){
		MySqlTableRowAsSqlComment inst = new MySqlTableRowAsSqlComment();
		assertTrue(inst instanceof TableRow);
		assertTrue(inst instanceof Formatter);
	}
	
	public void testCellCount(){
		TableRow inst = new MySqlTableRowAsSqlComment();
		int count = inst.getCellCount();
		assertTrue(0 == count);
	}

	public void testAddCell(){
		TableRow inst = new MySqlTableRowAsSqlComment();
		TableCell cell = new MySqlTableCellAsSqlComment("test");
		inst.addCell(cell);
		assertTrue(1 == inst.getCellCount());
	}
	
	public void testAsFormattedString1(){
		TableRow inst = new MySqlTableRowAsSqlComment();
		TableCell cell = new MySqlTableCellAsSqlComment("test");
		inst.addCell(cell);
		String fmtStr = ((Formatter)inst).asFormattedString();
		assertEquals("|test                     |", fmtStr);
	}
	
	public void testAsFormattedString2(){
		TableRow inst = new MySqlTableRowAsSqlComment();
		TableCell cell1 = new MySqlTableCellAsSqlComment("test");
		TableCell cell2 = new MySqlTableCellAsSqlComment("test2");
		inst.addCell(cell1);
		inst.addCell(cell2);
		String fmtStr = ((Formatter)inst).asFormattedString();
		assertEquals("|test                     |test2                    |", fmtStr);
	}
	
	public void testGetLength(){
		TableRow inst = new MySqlTableRowAsSqlComment();
		TableCell cell = new MySqlTableCellAsSqlComment();
		inst.addCell(cell);
		assertTrue(27 == inst.getLength());
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
