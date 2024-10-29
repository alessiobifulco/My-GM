package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private String role;
    private double rating;
    private boolean isFreeAgent;
    private Category category;

    public Player(int id, String name, String role, double rating, boolean isFreeAgent, Category category) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.rating = rating;
        this.isFreeAgent = isFreeAgent;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getRating() { return rating; }
    public boolean isFreeAgent() { return isFreeAgent; }
    public Category getCategory() { return category; }

    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }
    public void setRating(double rating) { this.rating = rating; }
    public void setFreeAgent(boolean freeAgent) { isFreeAgent = freeAgent; }
    public void setCategory(Category category) { this.category = category; }

    public static Player getPlayer(Connection connection, int playerId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_PLAYER_BY_ID)) {
            statement.setInt(1, playerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Category category = Category.valueOf(resultSet.getString("category").toUpperCase());
                    return new Player(
                        playerId,
                        resultSet.getString("name"),
                        resultSet.getString("role"),
                        resultSet.getDouble("rating"),
                        resultSet.getBoolean("freeagent"),
                        category
                    );
                }
            }
        }
        return null;
    }

    public static List<Player> getPlayersByTeam(Connection connection, int teamId) throws SQLException {
        List<Player> players = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_PLAYERS_BY_TEAM)) {
            statement.setInt(1, teamId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Category category = Category.valueOf(resultSet.getString("category").toUpperCase());
                    players.add(new Player(
                        resultSet.getInt("id_player"),
                        resultSet.getString("name"),
                        resultSet.getString("role"),
                        resultSet.getDouble("rating"),
                        resultSet.getBoolean("freeagent"),
                        category
                    ));
                }
            }
        }
        return players;
    }

    public static void updatePlayerRating(Connection connection, int playerId, double newRating) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_PLAYER_RATING)) {
            statement.setDouble(1, newRating);
            statement.setInt(2, playerId);
            statement.executeUpdate();
        }
    }

    public static List<Player> getFreeAgents(Connection connection) throws SQLException {
        List<Player> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENTS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Category category = Category.valueOf(resultSet.getString("category").toUpperCase());
                freeAgents.add(new Player(
                    resultSet.getInt("id_player"),
                    resultSet.getString("name"),
                    resultSet.getString("role"),
                    resultSet.getDouble("rating"),
                    true,
                    category
                ));
            }
        }
        return freeAgents;
    }
}
