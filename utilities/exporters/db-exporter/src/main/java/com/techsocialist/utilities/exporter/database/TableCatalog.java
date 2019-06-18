package com.techsocialist.utilities.exporter.database;

public interface TableCatalog {

	public int getRowCount();

	public void addRow(TableRow tableRow);

	public String getHeader();

	public String getFooter();

}
