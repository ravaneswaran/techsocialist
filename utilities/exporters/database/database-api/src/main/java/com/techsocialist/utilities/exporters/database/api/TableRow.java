package com.techsocialist.utilities.exporters.database.api;

public interface TableRow {

	public int getCellCount();

	public void addCell(TableCell cell);

	public int getLength();

}
