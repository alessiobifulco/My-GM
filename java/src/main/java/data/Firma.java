package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Firma {
    private int idFirma;
    private String dataFirma;
    private int idGiocatore;
    private int idContratto;

    public Firma(int idFirma, String dataFirma, int idGiocatore, int idContratto) {
        this.idFirma = idFirma;
        this.dataFirma = dataFirma;
        this.idGiocatore = idGiocatore;
        this.idContratto = idContratto;
    }

    public int getIdFirma() {
        return idFirma;
    }

    public String getDataFirma() {
        return dataFirma;
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }

    public int getIdContratto() {
        return idContratto;
    }

    public static final class DAO {
        private static Firma create(ResultSet resSet) {
            try {
                return new Firma(
                    resSet.getInt("id_firma"),
                    resSet.getString("data_firma"),
                    resSet.getInt("id_giocatore"),
                    resSet.getInt("id_contratto")
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String dataFirma, int idGiocatore, int idContratto) {
            try (var statement = DAOUtils.prepare(connection, Queries.INSERT_FIRMA, dataFirma, idGiocatore, idContratto)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Firma> findByGiocatore(Connection connection, int idGiocatore) {
            List<Firma> firme = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.SELECT_FIRME_PER_GIOCATORE, idGiocatore);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    firme.add(Firma.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return firme;
        }

        public static void updateData(Connection connection, String dataFirma, int idGiocatore, int idContratto) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_DATA_FIRMA, dataFirma, idGiocatore, idContratto)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
