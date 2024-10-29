package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Exercise {
    private int exerciseId;
    private String name;
    private String description;

    public Exercise(int exerciseId, String name, String description) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.description = description;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static final class DAO {
        private static Exercise create(ResultSet resSet) {
            try {
                return new Exercise(
                    resSet.getInt("id_esercizio"),
                    resSet.getString("nome"),
                    resSet.getString("descrizione")
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String name, String description) {
            try (var statement = DAOUtils.prepare(connection, Queries.INSERT_EXERCISE, name, description)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Exercise> findAll(Connection connection) {
            List<Exercise> exercises = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.SELECT_ALL_EXERCISES);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    exercises.add(Exercise.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return exercises;
        }

        public static void update(Connection connection, String name, String description, int exerciseId) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_EXERCISE, name, description, exerciseId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static void delete(Connection connection, int exerciseId) {
            try (var statement = DAOUtils.prepare(connection, Queries.DELETE_EXERCISE, exerciseId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
