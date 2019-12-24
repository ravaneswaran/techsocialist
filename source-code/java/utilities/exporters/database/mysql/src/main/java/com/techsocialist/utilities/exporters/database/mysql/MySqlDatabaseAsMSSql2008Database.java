package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.*;
import com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToMSSql2008DataTypeMapper;
import com.techsocialist.utilities.exporters.database.mysql.factory.MySqlDataTypeMapperFactory;
import com.techsocialist.utilities.exporters.database.mysql.formatter.comment.MySqlTableAsSqlComment;
import com.techsocialist.utilities.exporters.database.mysql.formatter.comment.MySqlTableCellAsSqlComment;
import com.techsocialist.utilities.exporters.database.mysql.formatter.comment.MySqlTableRowAsSqlComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MySqlDatabaseAsMSSql2008Database extends MySqlDatabaseAsMSSql2005Database{
	
	@Override
	public String getTableStructure(String table) throws SQLException {
		Statement statement = this.connection.createStatement();
		DataTypeMapper mapper = new MySqlToMSSql2008DataTypeMapper();
		ResultSet resultSet = statement.executeQuery("DESC " + table);
		TableCatalog tableCatalog = new MySqlTableAsSqlComment();
		while (resultSet.next()) {
			TableRow tableRow = new MySqlTableRowAsSqlComment();
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Field")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(mapper
					.getToDataType(resultSet.getString("Type"))));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Null")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Key")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Default")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Extra")));
			tableCatalog.addRow(tableRow);
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("/*\n").append(tableCatalog.getHeader())
				.append(((Formatter) tableCatalog).asFormattedString())
				.append(tableCatalog.getFooter()).append("*/").append("\n");

		return buffer.toString();
	}
	
	@Override
	public String getTableCreateStatement(String table) throws SQLException {
		StringBuffer buffer = new StringBuffer();

		List<KeyColumnUsage> columnUsages = getKeyColumnUsage(table);

        DataTypeMapper mapper = MySqlDataTypeMapperFactory.getInstance(Database.MYSQL_AS_MSSQL_2008);
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DESC " + table);
		if (null != resultSet) {
			buffer.append("CREATE TABLE ").append(table).append("(")
					.append("\n");
			while (resultSet.next()) {
				buffer.append("\t");
				String field = resultSet.getString("Field");
				String type = resultSet.getString("Type");
				String _null = resultSet.getString("Null");
				String key = resultSet.getString("Key");
				String _default = resultSet.getString("Default");
				String extra = resultSet.getString("Extra");
				_null = _null.equals("NO") ? "not null" : _null.equals("") ? ""
						: "null";

				buffer.append(field).append(" ")
						.append(mapper.getToDataType(type)).append(" ");
				buffer.append(_null).append(",").append("\n");
			}

			StringBuffer primaryKeyBuffer = new StringBuffer();
			StringBuffer foreignKeyBuffer = new StringBuffer();

			if (null != columnUsages) {
				for (KeyColumnUsage keyColumnUsage : columnUsages) {
					String constraintName = keyColumnUsage.getConstraintName();
					if (constraintName.equals("PRIMARY")
							|| constraintName.equals("primary")) {
						primaryKeyBuffer.append("\t").append("PRIMARY KEY")
								.append(" (")
								.append(keyColumnUsage.getColumnName())
								.append("),\n");
					} else {
						foreignKeyBuffer
								.append("\t")
								.append("CONSTRAINT")
								.append(" ")
								.append(keyColumnUsage.getConstraintName())
								.append(" ")
								.append("FOREIGN KEY")
								.append(" (")
								.append(keyColumnUsage.getColumnName())
								.append(") ")
								.append("REFERENCES")
								.append(" ")
								.append(keyColumnUsage.getReferencedTableName())
								.append(" (")
								.append(keyColumnUsage
										.getReferencedColumnName())
								.append("),\n");
					}
				}
			}
			buffer.append(primaryKeyBuffer.toString());
			buffer.append(foreignKeyBuffer.toString());

			buffer.append(")");

			String returnVal = buffer.toString().replace(",\n)", "\n)\nGO\n");

			return returnVal;

		}

		return null;
	}

}
