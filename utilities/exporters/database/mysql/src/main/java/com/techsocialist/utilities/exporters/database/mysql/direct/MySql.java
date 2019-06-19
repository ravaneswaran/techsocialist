package com.techsocialist.utilities.exporters.database.mysql.direct;

import com.techsocialist.utilities.exporters.database.api.AbstractExIm;
import com.techsocialist.utilities.exporters.database.api.ExIm;

public class MySql extends AbstractExIm implements ExIm {

    public MySql() {

    }

    public MySql(String host, String databaseName,
                 String username, String password) {
        super(host, databaseName, username, password);
    }

}
