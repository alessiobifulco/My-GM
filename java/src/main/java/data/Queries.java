package data;

public class Queries {
    // GM Queries
    public static final String CREATE_GM = "INSERT INTO gm (name, surname, email, password, team_id) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_GM = "DELETE FROM gm WHERE id_gm = ?";
    public static final String READ_ALL_GMS = "SELECT * FROM gm";
    public static final String READ_GM_BY_ID = "SELECT * FROM gm WHERE id_gm = ?";
    public static final String UPDATE_GM_TEAM = "UPDATE gm SET team_id = ? WHERE id_gm = ?";
    public static final String VERIFY_GM_CREDENTIALS = "SELECT COUNT(*) AS count FROM gm WHERE email = ? AND password = ?";

    // Staff Queries
    public static final String CREATE_STAFF = "INSERT INTO staff (name, role, email) VALUES (?, ?, ?)";
    public static final String DELETE_STAFF = "DELETE FROM staff WHERE id_staff = ?";
    public static final String READ_ALL_STAFF = "SELECT * FROM staff";
    public static final String READ_STAFF_BY_ID = "SELECT * FROM staff WHERE id_staff = ?";
    public static final String UPDATE_STAFF_ROLE = "UPDATE staff SET role = ? WHERE id_staff = ?";

    // Team Queries
    public static final String CREATE_TEAM = "INSERT INTO team (name, city, number_of_players, gm_id, staff_id) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_TEAM = "DELETE FROM team WHERE id_team = ?";
    public static final String READ_ALL_TEAMS = "SELECT * FROM team";
    public static final String READ_TEAM_BY_ID = "SELECT * FROM team WHERE id_team = ?";
    public static final String UPDATE_TEAM = "UPDATE team SET name = ?, city = ?, number_of_players = ?, gm_id = ?, staff_id = ? WHERE id_team = ?";

    // Player Queries
    public static final String CREATE_PLAYER = "INSERT INTO player (name, surname, age, role, experience, rating, is_free_agent, team_id, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_PLAYER = "DELETE FROM player WHERE id_player = ?";
    public static final String READ_ALL_PLAYERS = "SELECT * FROM player";
    public static final String READ_PLAYER_BY_ID = "SELECT * FROM player WHERE id_player = ?";
    public static final String READ_PLAYERS_BY_TEAM = "SELECT * FROM player WHERE team_id = ?";
    public static final String READ_FREE_AGENTS = "SELECT * FROM player WHERE is_free_agent = TRUE";
    public static final String READ_FREE_AGENTS_BY_ROLE = "SELECT * FROM player WHERE is_free_agent = TRUE AND role = ?";
    public static final String UPDATE_PLAYER_RATING = "UPDATE player SET rating = ? WHERE id_player = ?";
    public static final String UPDATE_PLAYER_TEAM = "UPDATE player SET team_id = ? WHERE id_player = ?";

    // Contract Queries
    public static final String CREATE_CONTRACT = "INSERT INTO contracts (duration, salary, clause, status, contract_date) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_CONTRACT = "DELETE FROM contracts WHERE id_contract = ?";
    public static final String READ_ALL_CONTRACTS = "SELECT * FROM contracts";
    public static final String READ_CONTRACT_BY_ID = "SELECT * FROM contracts WHERE id_contract = ?";
    public static final String UPDATE_CONTRACT = "UPDATE contracts SET duration = ?, salary = ?, clause = ?, status = ?, contract_date = ? WHERE id_contract = ?";

    // Signing Queries
    public static final String CREATE_SIGN = "INSERT INTO sign (sign_date, player_id, contract_id) VALUES (?, ?, ?)";
    public static final String DELETE_SIGN = "DELETE FROM sign WHERE player_id = ? AND contract_id = ?";
    public static final String READ_ALL_SIGN = "SELECT * FROM sign";
    public static final String READ_SIGN_BY_PLAYER = "SELECT id_signing, sign_date, player_id, contract_id FROM sign WHERE player_id = ?";
    public static final String UPDATE_SIGN_DATE = "UPDATE sign SET sign_date = ? WHERE player_id = ? AND contract_id = ?";

    // Trade Queries
    public static final String CREATE_TRADE = "INSERT INTO trade (player_a_id, player_b_id, team_a_id, team_b_id, trade_date, details, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_TRADE = "DELETE FROM trade WHERE id_trade = ?";
    public static final String READ_ALL_TRADES = "SELECT * FROM trade";
    public static final String READ_TRADES_BETWEEN_TEAMS = "SELECT * FROM trade WHERE (player_a_id IN (SELECT id_player FROM player WHERE team_id = ?) AND player_b_id IN (SELECT id_player FROM player WHERE team_id = ?))";
    public static final String UPDATE_TRADE_STATUS = "UPDATE trade SET status = ? WHERE id_trade = ?";

    // Subscription Queries
    public static final String CREATE_SUBSCRIPTION = "INSERT INTO subscription (contract_id, subscription_date) VALUES (?, ?)";
    public static final String DELETE_SUBSCRIPTION = "DELETE FROM subscription WHERE id_subscription = ?";
    public static final String READ_ALL_SUBSCRIPTIONS = "SELECT * FROM subscription";
    public static final String UPDATE_SUBSCRIPTION = "UPDATE subscription SET contract_id = ?, subscription_date = ? WHERE id_subscription = ?";

    // Training Queries
    public static final String CREATE_TRAINING = "INSERT INTO training (name, date, type, team_id) VALUES (?, ?, ?, ?)";
    public static final String DELETE_TRAINING = "DELETE FROM training WHERE id_training = ?";
    public static final String READ_TRAININGS_BY_TEAM = "SELECT * FROM training WHERE team_id = ?";
    public static final String UPDATE_TRAINING_TYPE = "UPDATE training SET type = ? WHERE id_training = ?";

    // Exercise Queries
    public static final String CREATE_EXERCISE = "INSERT INTO exercise (name, description) VALUES (?, ?)";
    public static final String DELETE_EXERCISE = "DELETE FROM exercise WHERE id_exercise = ?";
    public static final String READ_ALL_EXERCISES = "SELECT * FROM exercise";
    public static final String UPDATE_EXERCISE = "UPDATE exercise SET name = ?, description = ? WHERE id_exercise = ?";
}
