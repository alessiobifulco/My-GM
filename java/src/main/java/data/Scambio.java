package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Scambio {
    private int idScambio;
    private int idGiocatoreA;
    private int idGiocatoreB;
    private String dataScambio;
    private String dettagli;
    private String stato;

    public Scambio(int idScambio, int idGiocatoreA, int idGiocatoreB, String dataScambio, String dettagli, String stato) {
        this.idScambio = idScambio;
        this.idGiocatoreA = idGiocatoreA;
        this.idGiocatoreB = idGiocatoreB;
        this.dataScambio = dataScambio;
        this.dettagli = dettagli;
        this.stato = stato;
    }

    public int getIdScambio() {
        return idScambio;
    }

    public int getIdGiocatoreA() {
        return idGiocatoreA;
    }

    public int getIdGiocatoreB() {
        return idGiocatoreB;
    }

    public String getDataScambio() {
        return dataScambio;
    }

    public String getDettagli() {
        return dettagli;
    }

    public String getStato() {
        return stato;
    }

    public static final class DAO {
        private static Scambio create(ResultSet resSet) {
            try {
                return new Scambio(
                    resSet.getInt("id_scambio"),
                    resSet.getInt("id_giocatore_a"),
                    resSet.getInt("id_giocatore_b"),
                    resSet.getString("data_scambio"),
                    resSet.getString("dettagli"),
                    resSet.getString("stato")
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, int idGiocatoreA, int idGiocatoreB, String dataScambio, String dettagli, String stato) {
            try (var statement = DAOUtils.prepare(connection, Queries.INSERT_SCAMBIO, idGiocatoreA, idGiocatoreB, dataScambio, dettagli, stato)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Scambio> findBetweenSquadre(Connection connection, int idSquadraA, int idSquadraB) {
            List<Scambio> scambi = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.SELECT_SCAMBI_BETWEEN_SQUADRE, idSquadraA, idSquadraB);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    scambi.add(Scambio.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return scambi;
        }

        public static void updateStato(Connection connection, String stato, int idScambio) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_STATO_SCAMBIO, stato, idScambio)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
