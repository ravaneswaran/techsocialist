package com.techsocialist.utilities.exporters.database.mysql.formatter.comment;

import com.techsocialist.utilities.exporters.database.api.Formatter;
import com.techsocialist.utilities.exporters.database.api.TableCatalog;
import com.techsocialist.utilities.exporters.database.api.TableRow;

import java.util.ArrayList;
import java.util.List;

public class MySqlTableAsSqlComment implements TableCatalog, Formatter {

	private List<TableRow> rows = new ArrayList<TableRow>();

	public String asFormattedString() {
		StringBuffer buffer = new StringBuffer();
		for (TableRow row : this.rows) {
			buffer.append(((Formatter) row).asFormattedString()).append("\n");
		}
		return buffer.toString();
	}

	public int getRowCount() {
		return rows.size();
	}

	public void addRow(TableRow tableRow) {
		this.rows.add(tableRow);
	}

	public String getHeader() {
		TableRow header = new MySqlTableRowAsSqlComment();

		header.addCell(new MySqlTableCellAsSqlComment("Field"));
		header.addCell(new MySqlTableCellAsSqlComment("Type"));
		header.addCell(new MySqlTableCellAsSqlComment("Null"));
		header.addCell(new MySqlTableCellAsSqlComment("Key"));
		header.addCell(new MySqlTableCellAsSqlComment("Default"));
		header.addCell(new MySqlTableCellAsSqlComment("Extra"));
		
		int len = header.getLength();
		StringBuffer marker = new StringBuffer();
		marker.append("+");
		for (int i = 2; i < len; i++) {
			marker.append("-");
		}
		marker.append("+").append("\n");
		
		StringBuffer headerBuffer = new StringBuffer();
		
		headerBuffer.append(marker).append("|");
		for (int i = 2; i < len; i++) {
			headerBuffer.append(" ");
		}
		headerBuffer.append("|").append("\n");
		headerBuffer.append(marker).append(((Formatter) header).asFormattedString()).append("\n").append(marker);
		
		return headerBuffer.toString();
	}

	public String getFooter() {
		TableRow footer = new MySqlTableRowAsSqlComment();

		footer.addCell(new MySqlTableCellAsSqlComment(""));
		footer.addCell(new MySqlTableCellAsSqlComment(""));
		footer.addCell(new MySqlTableCellAsSqlComment(""));
		footer.addCell(new MySqlTableCellAsSqlComment(""));
		footer.addCell(new MySqlTableCellAsSqlComment(""));
		footer.addCell(new MySqlTableCellAsSqlComment(""));
		
		int len = footer.getLength();
		StringBuffer marker = new StringBuffer();
		marker.append("+");
		for (int i = 2; i < len; i++) {
			marker.append("-");
		}
		marker.append("+").append("\n");
		
		StringBuffer footerBuffer = new StringBuffer();
		
		footerBuffer.append(marker).append("|");
		for (int i = 2; i < len; i++) {
			footerBuffer.append(" ");
		}
		footerBuffer.append("|").append("\n");
		footerBuffer.append(marker);
		return footerBuffer.toString();
	}
}
