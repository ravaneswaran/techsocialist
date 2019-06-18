package com.techsocialist.utilities.exporter.database;

import java.sql.SQLException;

public interface Exporter {

	public void export() throws SQLException, ClassNotFoundException;

}
