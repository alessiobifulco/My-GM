package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Allenamento {
    private int idAllenamento;
    private String nome;
    private String data;
    private String tipo;
    private int idSquadra;

    public Allenamento(int idAllenamento, String nome, String data, String tipo, int idSquadra) {
        this.idAllenamento = idAllenamento;
        this.nome = nome;
        this.data = data;
        this.tipo = tipo;
        this.idSquadra = idSquadra;
    }

    public int getIdAllenamento() {
        return idAllenamento;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdSquadra() {
        return idSquadra;
    }

    public static final class DAO {
        private static Allenamento create(ResultSet resSet) {
            try {
                return new Allenamento(
                    resSet.getInt("id_allenamento"),
                    resSet.getString("nome"),
                    resSet.getString("data"),
                    resSet.getString("tipo"),
                    resSet.getInt("id_squadra")
                );
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        public static void insert(Connection connection, String nome, String data, String tipo, int idSquadra) {
            try (var statement = DAOUtils.prepare(connection, Queries.INSERT_ALLENAMENTO, nome, data, tipo, idSquadra)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }

        public static List<Allenamento> findBySquadra(Connection connection, int idSquadra) {
            List<Allenamento> allenamenti = new LinkedList<>();
            try (var statement = DAOUtils.prepare(connection, Queries.SELECT_ALLENAMENTI_PER_SQUADRA, idSquadra);
                 var resSet = statement.executeQuery()) {
                while (resSet.next()) {
                    allenamenti.add(Allenamento.DAO.create(resSet));
                }
            } catch (Exception e) {
                throw new DAOException(e);
            }
            return allenamenti;
        }

        public static void updateTipo(Connection connection, String tipo, int idAllenamento) {
            try (var statement = DAOUtils.prepare(connection, Queries.UPDATE_TIPO_ALLENAMENTO, tipo, idAllenamento)) {
                statement.executeUpdate();
            } catch (Exception e) {
                throw new DAOException(e);
            }
        }
    }
}
