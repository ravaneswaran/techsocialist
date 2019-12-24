package com.techsocialist.utilities.exporters.database.mysql.formatter.comment;

import com.techsocialist.utilities.exporters.database.api.Formatter;
import com.techsocialist.utilities.exporters.database.api.TableCell;
import com.techsocialist.utilities.exporters.database.api.TableRow;

import java.util.ArrayList;
import java.util.List;

public class MySqlTableRowAsSqlComment implements TableRow, Formatter {

	private List<TableCell> cells = new ArrayList<TableCell>();

	public String asFormattedString() {
		StringBuffer buffer = new StringBuffer();
		int counter = 1;
		for (TableCell cell : this.cells) {
			if(counter == 1){
				buffer.append("|");
			}
			buffer.append(((Formatter) cell).asFormattedString()).append("|");
			counter++;
		}
		return buffer.toString();
	}

	public int getCellCount() {
		return this.cells.size();
	}

	public void addCell(TableCell cell) {
		this.cells.add(cell);
	}

	public int getLength() {
		int length = 0;
		for (TableCell cell : this.cells) {
			length += ((Formatter)cell).asFormattedString().length() + 1;
		}
		return length + 1;
	}
}
