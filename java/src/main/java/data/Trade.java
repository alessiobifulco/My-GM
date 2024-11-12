package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Trade {
    private int idTrade;
    private int idPlayerA;
    private int idPlayerB;
    private String tradeDate;
    private String details;
    private String status;

    public Trade(int idTrade, int idPlayerA, int idPlayerB, String tradeDate, String details, String status) {
        this.idTrade = idTrade;
        this.idPlayerA = idPlayerA;
        this.idPlayerB = idPlayerB;
        this.tradeDate = tradeDate;
        this.details = details;
        this.status = status;
    }

    public int getIdTrade() {
        return idTrade;
    }

    public int getIdPlayerA() {
        return idPlayerA;
    }

    public int getIdPlayerB() {
        return idPlayerB;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public static final class DAO {
        public static Trade create(ResultSet resSet) {
            try {
                return new Trade(
                        resSet.getInt("id_trade"),
                        resSet.getInt("player_a_id"), // Usa player_a_id invece di id_player_a
                        resSet.getInt("player_b_id"), // Usa player_b_id invece di id_player_b
                        resSet.getString("trade_date"),
                        resSet.getString("details"),
                        resSet.getString("status"));
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, int idPlayerA, int idPlayerB, String tradeDate, String details,
                String status) {
            try (var statement = DAOUtils.prepare(connection, Queries.CREATE_TRADE, idPlayerA, idPlayerB, tradeDate,
                    details, status)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Trade> findBetweenTeams(Connection connection, int idTeamA, int idTeamB) {
            List<Trade> trades = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.READ_TRADES_BETWEEN_TEAMS, idTeamA, idTeamB);
                    var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    trades.add(Trade.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return trades;
        }

        public static void updateStatus(Connection connection, String status, int idTrade) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_TRADE_STATUS, status, idTrade)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Trade> findAll(Connection connection) {
            List<Trade> trades = new LinkedList<>();
            try (var statement = connection.prepareStatement(Queries.READ_ALL_TRADES);
                    var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    trades.add(create(resultSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return trades;
        }
    }

}
