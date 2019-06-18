package com.techsocialist.utilities.exporter.database.mysql.direct.mysql;

import com.techsocialist.utilities.exporter.database.mysql.direct.AbstractDirectExporter;

import java.sql.SQLException;

public class DirectMySqlToMySqlExporter extends AbstractDirectExporter {

	public void export() throws SQLException, ClassNotFoundException {
		/*Database source = MySqlDatabaseFactory.getInstance(Database.MYSQL);
        source.open("jdbc:mysql://" + this.source.getHost(), "3306",
                this.source. getDatabaseName(),this.source.getUsername(),
                this.source.getPassword());

        String sql = null;
        if (source.isOpen()) {
            sql = source.exportAsSql(true)*//*.replace(";", "")*//*;
        }

        if (sql != null) {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =  DriverManager.getConnection("jdbc:mysql://" + this.target.getHost()
                    + "/" + this.target.getDatabaseName(),
                    this.target.getUsername(), this.target.getPassword());
            if(connection != null){
                Statement statement = connection.createStatement();
                if(statement != null){
                    int status = statement.executeUpdate(sql);
                }
            }
        }*/
	}
}
