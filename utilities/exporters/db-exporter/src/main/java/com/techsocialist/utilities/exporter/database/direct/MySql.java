package com.techsocialist.utilities.exporter.database.direct;

import com.techsocialist.utilities.exporter.database.AbstractExIm;
import com.techsocialist.utilities.exporter.database.ExIm;

public class MySql extends AbstractExIm implements ExIm {

    public MySql() {

    }

    public MySql(String host, String databaseName,
                 String username, String password) {
        super(host, databaseName, username, password);
    }

}
