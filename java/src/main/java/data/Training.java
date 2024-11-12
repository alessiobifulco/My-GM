package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Training {
    private int trainingId;
    private String name;
    private String date;
    private String type;
    private int teamId;

    public Training(int trainingId, String name, String date, String type, int teamId) {
        this.trainingId = trainingId;
        this.name = name;
        this.date = date;
        this.type = type;
        this.teamId = teamId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getTeamId() {
        return teamId;
    }

    public static final class DAO {
        private static Training create(ResultSet resSet) {
            try {
                return new Training(
                    resSet.getInt("training_id"),  // Training ID
                    resSet.getString("name"),       // Training name
                    resSet.getString("date"),       // Training date
                    resSet.getString("type"),       // Training type
                    resSet.getInt("team_id")        // Team ID
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String name, String date, String type, int teamId) {
            try (var statement = DAOUtils.prepare(connection, Queries.CREATE_TRAINING, name, date, type, teamId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Training> findByTeam(Connection connection, int teamId) {
            List<Training> trainings = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.READ_TRAININGS_BY_TEAM, teamId);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    trainings.add(Training.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return trainings;
        }

        public static void updateType(Connection connection, String type, int trainingId) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_TRAINING_TYPE, type, trainingId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
