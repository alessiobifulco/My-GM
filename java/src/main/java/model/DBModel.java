package model;

import data.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import core.Model;

public class DBModel implements Model {

    private final Connection connection;

    public DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    public void signPlayer(String signingDate, int playerId, int contractId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_SIGN)) {
            statement.setString(1, signingDate);
            statement.setInt(2, playerId);
            statement.setInt(3, contractId);
            statement.executeUpdate();
        }
    }

    public List<Sign> getSigningsForPlayer(int playerId) throws SQLException {
        List<Sign> signings = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_SIGNS_FOR_PLAYER)) {
            statement.setInt(1, playerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    signings.add(new Sign(resultSet.getInt("id_signing"), resultSet.getString("signing_date"), playerId,
                            resultSet.getInt("contract_id")));
                }
            }
        }
        return signings;
    }

    public void updateSigningDate(String signingDate, int playerId, int contractId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_SIGN_DATE)) {
            statement.setString(1, signingDate);
            statement.setInt(2, playerId);
            statement.setInt(3, contractId);
            statement.executeUpdate();
        }
    }

    public void tradePlayers(int playerAId, int playerBId, int teamAId, int teamBId, String tradeDate,
                             String details, String status) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_TRADE)) {
            statement.setInt(1, playerAId);
            statement.setInt(2, playerBId);
            statement.setInt(3, teamAId);
            statement.setInt(4, teamBId);
            statement.setString(5, tradeDate);
            statement.setString(6, details);
            statement.setString(7, status);
            statement.executeUpdate();
        }
    }

    public List<Trade> getTradesBetweenTeams(int teamAId, int teamBId) throws SQLException {
        List<Trade> trades = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_TRADES_BETWEEN_TEAMS)) {
            statement.setInt(1, teamAId);
            statement.setInt(2, teamBId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    trades.add(new Trade(resultSet.getInt("id_trade"), resultSet.getInt("id_player_a"),
                            resultSet.getInt("id_player_b"), resultSet.getString("trade_date"),
                            resultSet.getString("details"), resultSet.getString("status")));
                }
            }
        }
        return trades;
    }

    public void updateTradeStatus(String status, int tradeId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_TRADE_STATUS)) {
            statement.setString(1, status);
            statement.setInt(2, tradeId);
            statement.executeUpdate();
        }
    }

    public void insertTraining(String name, String date, String type, int teamId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_TRAINING)) {
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setString(3, type);
            statement.setInt(4, teamId);
            statement.executeUpdate();
        }
    }

    public List<Training> getTrainingsByTeam(int teamId) throws SQLException {
        List<Training> trainings = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_TRAININGS_BY_TEAM)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    trainings.add(new Training(resultSet.getInt("id_training"), resultSet.getString("name"),
                            resultSet.getString("date"), resultSet.getString("type"), teamId));
                }
            }
        }
        return trainings;
    }

    public void updateTrainingType(String type, int trainingId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_TRAINING_TYPE)) {
            statement.setString(1, type);
            statement.setInt(2, trainingId);
            statement.executeUpdate();
        }
    }

    public List<Player> getFreeAgents() throws SQLException {
        List<Player> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENTS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String categoryStr = resultSet.getString("category");
                Category category = Category.valueOf(categoryStr.toUpperCase());

                freeAgents.add(new Player(
                        resultSet.getInt("id_player"),
                        resultSet.getString("name"),
                        categoryStr,
                        resultSet.getDouble("rating"),
                        true,
                        category
                ));
            }
        }
        return freeAgents;
    }

    public void associateFreeAgent(int playerId, int teamId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_FREE_AGENT)) {
            statement.setInt(1, teamId);
            statement.setInt(2, playerId);
            statement.executeUpdate();
        }
    }

    public List<Player> getFreeAgentsByRole(String role) throws SQLException {
        List<Player> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENTS_BY_ROLE)) {
            statement.setString(1, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String categoryStr = resultSet.getString("category");
                    Category category = Category.valueOf(categoryStr.toUpperCase());

                    freeAgents.add(new Player(
                            resultSet.getInt("id_player"),
                            resultSet.getString("name"),
                            role,
                            resultSet.getDouble("rating"),
                            true,
                            category
                    ));
                }
            }
        }
        return freeAgents;
    }

    public List<Player> getPlayersByTeam(int teamId) throws SQLException {
        List<Player> players = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_PLAYERS_BY_TEAM)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String categoryStr = resultSet.getString("category");
                    Category category = Category.valueOf(categoryStr.toUpperCase());

                    players.add(new Player(
                            resultSet.getInt("id_player"),
                            resultSet.getString("name"),
                            categoryStr,
                            resultSet.getDouble("rating"),
                            false,
                            category
                    ));
                }
            }
        }
        return players;
    }

    public Team getTeam(int teamId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_TEAM_BY_ID)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Team(
                            teamId,
                            resultSet.getString("name"),
                            resultSet.getString("city"),
                            resultSet.getInt("number_of_players"),
                            resultSet.getInt("id_gm"),
                            resultSet.getInt("id_staff"));
                }
            }
        }
        return null;
    }

    public void insertExercise(String name, String description) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_EXERCISE)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.executeUpdate();
        }
    }

    public List<Exercise> getAllExercises() throws SQLException {
        List<Exercise> exercises = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_EXERCISES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                exercises.add(new Exercise(resultSet.getInt("id_exercise"), resultSet.getString("name"),
                        resultSet.getString("description")));
            }
        }
        return exercises;
    }

    public void updateExercise(int exerciseId, String name, String description) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_EXERCISE)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, exerciseId);
            statement.executeUpdate();
        }
    }

    public void deleteExercise(int exerciseId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE_EXERCISE)) {
            statement.setInt(1, exerciseId);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean verifyGmCredentials(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM gm WHERE email = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("count") > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error verifying GM credentials", e);
        }

        return false;
    }
}
