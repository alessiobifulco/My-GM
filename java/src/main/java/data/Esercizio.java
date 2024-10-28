package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Esercizio {
    private int idEsercizio;
    private String nome;
    private String descrizione;

    public Esercizio(int idEsercizio, String nome, String descrizione) {
        this.idEsercizio = idEsercizio;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public int getIdEsercizio() {
        return idEsercizio;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public static final class DAO {
        private static Esercizio create(ResultSet resSet) {
            try {
                return new Esercizio(
                    resSet.getInt("id_esercizio"),
                    resSet.getString("nome"),
                    resSet.getString("descrizione")
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String nome, String descrizione) {
            try (var statement = DAOUtils.prepare(connection, Queries.INSERT_ESERCIZIO, nome, descrizione)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Esercizio> findAll(Connection connection) {
            List<Esercizio> esercizi = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.SELECT_ALL_ESERCIZI);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    esercizi.add(Esercizio.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return esercizi;
        }

        public static void update(Connection connection, String nome, String descrizione, int idEsercizio) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_ESERCIZIO, nome, descrizione, idEsercizio)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static void delete(Connection connection, int idEsercizio) {
            try (var statement = DAOUtils.prepare(connection, Queries.DELETE_ESERCIZIO, idEsercizio)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
