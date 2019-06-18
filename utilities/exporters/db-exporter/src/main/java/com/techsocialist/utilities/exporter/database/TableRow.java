package com.techsocialist.utilities.exporter.database;

public interface TableRow {

	public int getCellCount();

	public void addCell(TableCell cell);

	public int getLength();

}
