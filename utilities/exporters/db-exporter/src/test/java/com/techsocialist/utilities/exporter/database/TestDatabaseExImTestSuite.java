package com.techsocialist.utilities.exporter.database;

import com.techsocialist.utilities.exporter.database.mysql.*;
import com.techsocialist.utilities.exporter.database.mysql.datatype.mapper.*;
import com.techsocialist.utilities.exporter.database.mysql.exporter.direct.TestMSSql2005;
import com.techsocialist.utilities.exporter.database.mysql.exporter.direct.TestMSSql2008;
import com.techsocialist.utilities.exporter.database.mysql.exporter.direct.TestMySql;
import com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql.*;
import com.techsocialist.utilities.exporter.database.mysql.factory.database.TestMySqlDatabaseFactory;
import com.techsocialist.utilities.exporter.database.mysql.factory.exporter.TestFileExporterFactory;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.TestMySqlTableCatalogAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.TestMySqlTableCellAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.TestMySqlTableRowAsSqlComment;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestDatabaseExImTestSuite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(TestMySqlToMSSql2005DataTypeMapper.class);
		suite.addTestSuite(TestMySqlToMSSql2008DataTypeMapper.class);
        suite.addTestSuite(TestMySqlToSQLiteDataTypeMapper.class);
		suite.addTestSuite(TestMySqlToOracleDataTypeMapper.class);
        suite.addTestSuite(TestMySqlToPostgreSqlDataTypeMapper.class);
        suite.addTestSuite(TestMySqlToIngresDataTypeMapper.class);
		
		suite.addTestSuite(TestMySqlTableCatalogAsSqlComment.class);
        suite.addTestSuite(TestMySqlTableCellAsSqlComment.class);
        suite.addTestSuite(TestMySqlTableRowAsSqlComment.class);
		
		suite.addTestSuite(TestMySqlDatabase.class);
		suite.addTestSuite(TestMySqlDatabaseAsMSSql2005Database.class);
		suite.addTestSuite(TestMySqlDatabaseAsMSSql2008Database.class);
        suite.addTestSuite(TestMySqlDatabaseAsSQLiteDatabase.class);
		suite.addTestSuite(TestMySqlDatabaseAsOracleDatabase.class);
        suite.addTestSuite(TestMySqlDatabaseAsPostgreSqlDatabase.class);
        suite.addTestSuite(TestMySqlDatabaseAsIngresDatabase.class);

		suite.addTestSuite(TestMySqlFunction.class);
		suite.addTestSuite(TestMySqlKeyColumnUsage.class);
		suite.addTestSuite(TestMySqlProcedure.class);
		suite.addTestSuite(TestMySqlTable.class);
		suite.addTestSuite(TestMySqlTrigger.class);
		
		suite.addTestSuite(TestMySql.class);
		suite.addTestSuite(TestMSSql2005.class);
		suite.addTestSuite(TestMSSql2008.class);
		
		suite.addTestSuite(TestAsMySqlFile.class);
		suite.addTestSuite(TestAsMSSql2005SqlFile.class);
		suite.addTestSuite(TestAsMSSql2008SqlFile.class);
        suite.addTestSuite(TestAsOracleSqlFile.class);
        suite.addTestSuite(TestAsSQLiteSqlFile.class);
        suite.addTestSuite(TestAsPostgreSqlFile.class);
        suite.addTestSuite(TestAsIngresSqlFile.class);

        suite.addTestSuite(TestFileExporterFactory.class);
        suite.addTestSuite(TestMySqlDatabaseFactory.class);
		
		//suite.addTestSuite(TestDirectMySqlToMySqlExporter.class);
		
		return suite;
	}

	public static void main(String arg[]) {
		TestDatabaseExImTestSuite.suite();
	}

}
