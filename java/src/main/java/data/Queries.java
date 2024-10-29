package data;

public class Queries {
    // Exercise Queries
    public static final String INSERT_EXERCISE = "INSERT INTO exercises (name, description) VALUES (?, ?)";
    public static final String SELECT_ALL_EXERCISES = "SELECT * FROM exercises";
    public static final String UPDATE_EXERCISE = "UPDATE exercises SET name = ?, description = ? WHERE id_exercise = ?";
    public static final String DELETE_EXERCISE = "DELETE FROM exercises WHERE id_exercise = ?";

    // Contract Queries
    public static final String INSERT_CONTRACT = "INSERT INTO contracts (duration, salary, clause, status, contract_date) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_CONTRACTS = "SELECT * FROM contracts";
    public static final String UPDATE_CONTRACT = "UPDATE contracts SET duration = ?, salary = ?, clause = ?, status = ?, contract_date = ? WHERE id_contract = ?";
    public static final String DELETE_CONTRACT = "DELETE FROM contracts WHERE id_contract = ?";

    // Signing Queries
    public static final String INSERT_SIGN = "INSERT INTO signings (sign_date, player_id, contract_id) VALUES (?, ?, ?)";
    public static final String SELECT_SIGNS_FOR_PLAYER = "SELECT * FROM signings WHERE player_id = ?";
    public static final String UPDATE_SIGN_DATE = "UPDATE signings SET sign_date = ? WHERE player_id = ? AND contract_id = ?";
    public static final String DELETE_SIGNING = "DELETE FROM signings WHERE player_id = ? AND contract_id = ?";

    // Trade Queries
    public static final String INSERT_TRADE = "INSERT INTO trades (player_a_id, player_b_id, trade_date, details, status) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_TRADES_BETWEEN_TEAMS = "SELECT * FROM trades WHERE (player_a_id IN (SELECT id FROM players WHERE team_id = ?) AND player_b_id IN (SELECT id FROM players WHERE team_id = ?))";
    public static final String UPDATE_TRADE_STATUS = "UPDATE trades SET status = ? WHERE id_trade = ?";

    // Subscription Queries
    public static final String INSERT_SUBSCRIPTION = "INSERT INTO subscriptions (contract_id, subscription_date) VALUES (?, ?)";
    public static final String SELECT_ALL_SUBSCRIPTIONS = "SELECT * FROM subscriptions";
    public static final String UPDATE_SUBSCRIPTION = "UPDATE subscriptions SET contract_id = ?, subscription_date = ? WHERE id_subscription = ?";
    public static final String DELETE_SUBSCRIPTION = "DELETE FROM subscriptions WHERE id_subscription = ?";

    // Player Queries
    public static final String SELECT_PLAYER_BY_ID = "SELECT * FROM players WHERE id_player = ?";
    public static final String SELECT_PLAYERS_BY_TEAM = "SELECT * FROM players WHERE team_id = ?";
    public static final String UPDATE_PLAYER_RATING = "UPDATE players SET rating = ? WHERE id_player = ?";
    public static final String SELECT_FREE_AGENTS = "SELECT * FROM players WHERE is_free_agent = TRUE";

    // Free Agent Queries
    public static final String UPDATE_FREE_AGENT = "UPDATE players SET team_id = ? WHERE id_player = ?"; // Aggiorna l'associazione di un free agent a un team

    // Team Queries
    public static final String INSERT_TEAM = "INSERT INTO teams (name, city, number_of_players, id_gm, id_staff) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_TEAMS = "SELECT * FROM teams";
    public static final String UPDATE_TEAM = "UPDATE teams SET name = ?, city = ?, number_of_players = ?, id_gm = ?, id_staff = ? WHERE id_team = ?";
    public static final String DELETE_TEAM = "DELETE FROM teams WHERE id_team = ?";
    public static final String SELECT_TEAM_BY_ID = "SELECT * FROM teams WHERE id_team = ?"; // Ottiene un team specifico

    // Training Queries
    public static final String INSERT_TRAINING = "INSERT INTO trainings (name, date, type, team_id) VALUES (?, ?, ?, ?)";
    public static final String SELECT_TRAININGS_BY_TEAM = "SELECT * FROM trainings WHERE team_id = ?";
    public static final String UPDATE_TRAINING_TYPE = "UPDATE trainings SET type = ? WHERE training_id = ?";
    public static final String DELETE_TRAINING = "DELETE FROM trainings WHERE training_id = ?";

    public static final String SELECT_FREE_AGENTS_BY_ROLE = "SELECT * FROM players WHERE is_free_agent = TRUE AND role = ?"; // Ottiene free agents per ruolo

    
}
