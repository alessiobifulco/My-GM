package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Sign {
    private int signId;
    private String signDate;
    private int playerId;
    private int contractId;

    public Sign(int signId, String signDate, int playerId, int contractId) {
        this.signId = signId;
        this.signDate = signDate;
        this.playerId = playerId;
        this.contractId = contractId;
    }

    public int getSignId() {
        return signId;
    }

    public String getSignDate() {
        return signDate;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getContractId() {
        return contractId;
    }

    public static final class DAO {
        public static Sign create(ResultSet resSet) {
            try {
                return new Sign(
                        resSet.getInt("id_signing"), // Usa id_signing invece di id_firma
                        resSet.getString("sign_date"), // Usa sign_date invece di data_firma
                        resSet.getInt("player_id"), // Usa player_id
                        resSet.getInt("contract_id")); // Usa contract_id
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String signDate, int playerId, int contractId) {
            try (var statement = DAOUtils.prepare(connection, Queries.CREATE_SIGN, signDate, playerId, contractId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Sign> findByPlayer(Connection connection, int playerId) {
            List<Sign> signs = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.READ_SIGN_BY_PLAYER, playerId);
                    var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    signs.add(Sign.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return signs;
        }

        public static void updateSignDate(Connection connection, String signDate, int playerId, int contractId) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_SIGN_DATE, signDate, playerId,
                    contractId)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Sign> findAll(Connection connection) {
            List<Sign> signs = new LinkedList<>();
            try (var statement = connection.prepareStatement(Queries.READ_ALL_SIGN);
                    var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    signs.add(create(resultSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return signs;
        }
    }

}
