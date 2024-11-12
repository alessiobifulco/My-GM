package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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

    // Getter e Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getRating() {
        return rating;
    }

    public boolean isFreeAgent() {
        return isFreeAgent;
    }

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setFreeAgent(boolean freeAgent) {
        isFreeAgent = freeAgent;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Subclasse DAO per l'accesso al database
    public static final class DAO {

        // Metodo per creare un oggetto Player da un ResultSet
        public static Player create(ResultSet resSet) {
            try {
                Category category = Category.valueOf(resSet.getString("category").toUpperCase());
                return new Player(
                        resSet.getInt("id_player"),
                        resSet.getString("name"),
                        resSet.getString("role"),
                        resSet.getDouble("rating"),
                        resSet.getBoolean("freeagent"),
                        category);
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        // Metodo per inserire un nuovo giocatore
        public static void insert(Connection connection, String name, String role, double rating, boolean isFreeAgent, Category category) {
            try (PreparedStatement statement = DAOUtils.prepare(connection, Queries.CREATE_PLAYER, name, role, rating, isFreeAgent, category.name())) {
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        // Metodo per ottenere un giocatore tramite il suo ID
        public static Player getPlayerById(Connection connection, int playerId) {
            try (PreparedStatement statement = connection.prepareStatement(Queries.READ_PLAYER_BY_ID)) {
                statement.setInt(1, playerId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return create(resultSet);
                    }
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return null;
        }

        // Metodo per ottenere tutti i giocatori
        public static List<Player> findAll(Connection connection) {
            List<Player> players = new LinkedList<>();
            try (PreparedStatement statement = connection.prepareStatement(Queries.READ_ALL_PLAYERS);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    players.add(create(resultSet));
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return players;
        }

        // Metodo per ottenere tutti i giocatori di una squadra
        public static List<Player> getPlayersByTeam(Connection connection, int teamId) {
            List<Player> players = new LinkedList<>();
            try (PreparedStatement statement = connection.prepareStatement(Queries.READ_PLAYERS_BY_TEAM)) {
                statement.setInt(1, teamId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        players.add(create(resultSet));
                    }
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return players;
        }

        // Metodo per ottenere tutti i free agent
        public static List<Player> getFreeAgents(Connection connection) {
            List<Player> freeAgents = new LinkedList<>();
            try (PreparedStatement statement = connection.prepareStatement(Queries.READ_FREE_AGENTS);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    freeAgents.add(create(resultSet));
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            return freeAgents;
        }

        // Metodo per aggiornare il rating di un giocatore
        public static void updatePlayerRating(Connection connection, int playerId, double newRating) {
            try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_PLAYER_RATING)) {
                statement.setDouble(1, newRating);
                statement.setInt(2, playerId);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
