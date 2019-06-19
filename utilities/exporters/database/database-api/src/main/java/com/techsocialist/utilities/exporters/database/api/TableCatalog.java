package com.techsocialist.utilities.exporters.database.api;

public interface TableCatalog {

	public int getRowCount();

	public void addRow(TableRow tableRow);

	public String getHeader();

	public String getFooter();

}
