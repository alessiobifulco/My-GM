-- Creazione del database NBA_System se non esiste già
CREATE DATABASE IF NOT EXISTS NBA_System;

-- Selezione del database NBA_System
USE NBA_System;

-- Creazione della tabella general_managers (gm)
CREATE TABLE IF NOT EXISTS GM (
    id_gm INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    team_id INT UNIQUE
);

-- Creazione della tabella staff_members (staff)
CREATE TABLE IF NOT EXISTS staff (
    id_staff INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Creazione della tabella teams
CREATE TABLE IF NOT EXISTS team (
    id_team INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    number_of_players INT DEFAULT 0,
    gm_id INT,
    staff_id INT,
    FOREIGN KEY (gm_id) REFERENCES GM(id_gm),
    FOREIGN KEY (staff_id) REFERENCES staff(id_staff)
);

-- Creazione della tabella players
CREATE TABLE IF NOT EXISTS player (
    id_player INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    role VARCHAR(50),
    experience INT,
    rating INT,
    is_free_agent BOOLEAN DEFAULT TRUE,
    team_id INT,
    category VARCHAR(50),
    FOREIGN KEY (team_id) REFERENCES team(id_team)
);

-- Creazione della tabella contracts
CREATE TABLE IF NOT EXISTS contracts (
    id_contract INT AUTO_INCREMENT PRIMARY KEY,
    duration INT NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    clause TEXT,
    status VARCHAR(50),
    contract_date DATE
);

-- Creazione della tabella sign (precedentemente signing)
CREATE TABLE IF NOT EXISTS sign (
    id_signing INT AUTO_INCREMENT PRIMARY KEY,
    sign_date DATE,
    player_id INT,
    contract_id INT,
    FOREIGN KEY (player_id) REFERENCES player(id_player),
    FOREIGN KEY (contract_id) REFERENCES contracts(id_contract)
);

-- Creazione della tabella subscriptions
CREATE TABLE IF NOT EXISTS subscription (
    id_subscription INT AUTO_INCREMENT PRIMARY KEY,
    contract_id INT,
    subscription_date DATE,
    FOREIGN KEY (contract_id) REFERENCES contracts(id_contract)
);

-- Creazione della tabella trades
CREATE TABLE IF NOT EXISTS trade (
    id_trade INT AUTO_INCREMENT PRIMARY KEY,
    player_a_id INT,
    player_b_id INT,
    team_a_id INT,
    team_b_id INT,
    trade_date DATE,
    details TEXT,
    status VARCHAR(50),
    FOREIGN KEY (player_a_id) REFERENCES player(id_player),
    FOREIGN KEY (player_b_id) REFERENCES player(id_player),
    FOREIGN KEY (team_a_id) REFERENCES team(id_team),
    FOREIGN KEY (team_b_id) REFERENCES team(id_team)
);

-- Creazione della tabella training
CREATE TABLE IF NOT EXISTS training (
    id_training INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    date DATE,
    type VARCHAR(50),
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(id_team)
);

-- Creazione della tabella exercise
CREATE TABLE IF NOT EXISTS exercise (
    id_exercise INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    difficulty VARCHAR(50)
);
