package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Objects;

import data.DAOException;
import data.*;

public class DBModel implements Model {

    private final Connection connection;

    public DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    @Override
    public void updateOdM() {
        // Esempio: visualizzazione dei GM nel sistema
        try (
            var statement = DAOUtils.prepare(connection, "SELECT * FROM GM");
            var resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                System.out.println("GM: " + resultSet.getString("Nome") + " " + resultSet.getString("Cognome"));
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
}
