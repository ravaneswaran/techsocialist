package com.techsocialist.utilities.exporter.database.mysql.formatter.comment;

import com.congruent.db.formatter.Formatter;
import com.congruent.db.formatter.TableCell;
import junit.framework.TestCase;

public class TestMySqlTableCellAsSqlComment extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testTableCellSqlCommentInst() {
		MySqlTableCellAsSqlComment impl = new MySqlTableCellAsSqlComment();
		assertTrue(impl instanceof TableCell);
		assertTrue(impl instanceof Formatter);
	}

	public void testTableCellDefaultWidth() {
		int defaultWidth = TableCell.DEFAULT_WIDTH;
		assertTrue(25 == defaultWidth);
	}

	public void testDefaultCellValue() {
		TableCell impl = new MySqlTableCellAsSqlComment();
		assertTrue(25 == ((Formatter) impl).asFormattedString().length());
		assertTrue(("                         ").equals(((Formatter) impl)
				.asFormattedString()));
	}

	public void testGetCellValue() {
		String value = "";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val = impl.getValue();
		assertTrue(value.equals(val));
	}

	public void testGetCellWidth() {
		String value = "";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val = ((Formatter) impl).asFormattedString();
		assertTrue(TableCell.DEFAULT_WIDTH == val.length());
	}

	public void testGetSetCellWidth() {
		String value = "                              ";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		int width = 30;
		impl.setWidth(width);
		String val = impl.getValue();
		assertTrue((value).equals(val));
	}

	public void testCellValue1() {
		String value = null;
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val = ((Formatter) impl).asFormattedString();
		assertTrue(("                         ").equals(val));
	}

	public void testCellValue2() {
		String value = "qwertyuiopasdfghjklzxcvbnmkloiuiiopytredrfggt";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val = ((Formatter) impl).asFormattedString();
		assertTrue((value).equals(val));
	}

	public void testCellValue3() {
		String value = "";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val = ((Formatter) impl).asFormattedString();
		assertTrue(("                         ").equals(val));
	}

	public void testCellValue4() {
		String value = "qwertyui";
		TableCell impl = new MySqlTableCellAsSqlComment(value);
		String val =((Formatter) impl).asFormattedString();
		assertTrue((value + "                 ").equals(val));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
