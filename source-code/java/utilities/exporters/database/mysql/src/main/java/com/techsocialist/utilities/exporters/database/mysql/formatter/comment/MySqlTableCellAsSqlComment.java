package com.techsocialist.utilities.exporters.database.mysql.formatter.comment;

import com.techsocialist.utilities.exporters.database.api.Formatter;
import com.techsocialist.utilities.exporters.database.api.TableCell;

public class MySqlTableCellAsSqlComment implements TableCell, Formatter {

	public static int CORRECTED_WIDTH = 0;

	private String value = "";

	public MySqlTableCellAsSqlComment() {
		CORRECTED_WIDTH = DEFAULT_WIDTH;
	}

	public MySqlTableCellAsSqlComment(String value) {
		this();
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setWidth(int width) {
		CORRECTED_WIDTH = (CORRECTED_WIDTH < width) ? width : CORRECTED_WIDTH ;
	}

	public String asFormattedString() {
		String tempVal = (null != this.value) ? this.value : "";
		int appendLen = CORRECTED_WIDTH - tempVal.length();
		String strToAppend = "";
		for (int i = 1; i <= appendLen; i++) {
			strToAppend += " ";
		}
		return tempVal + strToAppend;
	}
}
