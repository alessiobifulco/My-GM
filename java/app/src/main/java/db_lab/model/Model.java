package model;

import java.sql.Connection;

public interface Model {

    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    void updateOdM();
}
