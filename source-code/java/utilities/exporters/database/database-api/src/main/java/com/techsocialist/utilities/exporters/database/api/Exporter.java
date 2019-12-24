package com.techsocialist.utilities.exporters.database.api;

import java.sql.SQLException;

public interface Exporter {

	public void export() throws SQLException, ClassNotFoundException;

}
