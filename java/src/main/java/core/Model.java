package core;

import data.*;
import model.DBModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Model {

    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    void signPlayer(String signingDate, int playerId, int contractId) throws SQLException;

    List<Sign> getSigningsForPlayer(int playerId) throws SQLException;

    void updateSigningDate(String signingDate, int playerId, int contractId) throws SQLException;

    void tradePlayers(int playerAId, int playerBId, int teamAId, int teamBId,
                      String tradeDate, String details, String status) throws SQLException;

    List<Trade> getTradesBetweenTeams(int teamAId, int teamBId) throws SQLException;

    void updateTradeStatus(String status, int tradeId) throws SQLException;

    void insertTraining(String name, String date, String type, int teamId) throws SQLException;

    List<Training> getTrainingsByTeam(int teamId) throws SQLException;

    void updateTrainingType(String type, int trainingId) throws SQLException;

    List<Player> getFreeAgents() throws SQLException;

    void associateFreeAgent(int playerId, int teamId) throws SQLException;

    List<Player> getFreeAgentsByRole(String role) throws SQLException;

    List<Player> getPlayersByTeam(int teamId) throws SQLException;

    Team getTeam(int teamId) throws SQLException;

    void insertExercise(String name, String description) throws SQLException;

    List<Exercise> getAllExercises() throws SQLException;

    void updateExercise(int exerciseId, String name, String description) throws SQLException;

    void deleteExercise(int exerciseId) throws SQLException;

    boolean verifyGmCredentials(String email, String password) throws SQLException;
}
