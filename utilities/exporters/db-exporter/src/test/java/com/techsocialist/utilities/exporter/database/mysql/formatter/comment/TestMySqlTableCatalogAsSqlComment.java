package com.techsocialist.utilities.exporter.database.mysql.formatter.comment;

import com.techsocialist.utilities.exporter.database.Formatter;
import com.techsocialist.utilities.exporter.database.TableCatalog;
import com.techsocialist.utilities.exporter.database.TableRow;
import junit.framework.TestCase;

public class TestMySqlTableCatalogAsSqlComment extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testTableAsSqlInstance(){
		MySqlTableAsSqlComment inst = new MySqlTableAsSqlComment();
		assertTrue(inst instanceof TableCatalog);
		assertTrue(inst instanceof Formatter);
	}
	
	public void testGetRowCount(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		int count = inst.getRowCount();
		assertTrue(0 == count);
	}
	
	public void testAddRow(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		TableRow tableRow = new MySqlTableRowAsSqlComment();
		tableRow.addCell(new MySqlTableCellAsSqlComment("test"));
		tableRow.addCell(new MySqlTableCellAsSqlComment("test2"));
		inst.addRow(tableRow);
		assertTrue(1 == inst.getRowCount());
	}
	
	public void testAsFormattedString(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		TableRow tableRow = new MySqlTableRowAsSqlComment();
		tableRow.addCell(new MySqlTableCellAsSqlComment("test"));
		tableRow.addCell(new MySqlTableCellAsSqlComment("test2"));
		inst.addRow(tableRow);
		String str = ((Formatter)inst).asFormattedString();
		assertNotNull(str);
		assertEquals("|test                     |test2                    |\n", str);
	}
	
	public void testAsFormattedString2(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		
		TableRow tableRow1 = new MySqlTableRowAsSqlComment();
		tableRow1.addCell(new MySqlTableCellAsSqlComment("test"));
		tableRow1.addCell(new MySqlTableCellAsSqlComment("test2"));
		
		TableRow tableRow2 = new MySqlTableRowAsSqlComment();
		tableRow2.addCell(new MySqlTableCellAsSqlComment("test_case"));
		tableRow2.addCell(new MySqlTableCellAsSqlComment("test_case_1"));
		
		inst.addRow(tableRow1);
		inst.addRow(tableRow2);
		
		String str = ((Formatter)inst).asFormattedString();
		assertEquals("|test                     |test2                    |\n|test_case                |test_case_1              |\n", str);
	}
	
	public void testGetHeader(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		String str = inst.getHeader();
		assertNotNull(str);
	}
	
	public void testGetFooter(){
		TableCatalog inst = new MySqlTableAsSqlComment();
		String str = inst.getFooter();
		assertNotNull(str);
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
