-- Creazione del database NBA_System se non esiste già
CREATE DATABASE IF NOT EXISTS NBA_System;

-- Selezione del database NBA_System
USE NBA_System;

-- Creazione della tabella gm
CREATE TABLE IF NOT EXISTS gm (
    id_gm INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    id_squadra INT UNIQUE
);

-- Creazione della tabella staff
CREATE TABLE IF NOT EXISTS staff (
    id_staff INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ruolo VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Creazione della tabella squadra
CREATE TABLE IF NOT EXISTS squadra (
    id_squadra INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    città VARCHAR(100) NOT NULL,
    numero_giocatori INT DEFAULT 0,
    id_gm INT,
    id_staff INT,
    FOREIGN KEY (id_gm) REFERENCES gm(id_gm),
    FOREIGN KEY (id_staff) REFERENCES staff(id_staff)
);

-- Creazione della tabella giocatore
CREATE TABLE IF NOT EXISTS giocatore (
    id_giocatore INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    età INT NOT NULL,
    posizione VARCHAR(50),
    esperienza INT,
    valutazione INT,
    freeagent BOOLEAN DEFAULT TRUE,
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadra(id_squadra)
);

-- Creazione della tabella contratto
CREATE TABLE IF NOT EXISTS contratto (
    id_contratto INT AUTO_INCREMENT PRIMARY KEY,
    durata INT NOT NULL,
    stipendio DECIMAL(10, 2) NOT NULL,
    clausola TEXT,
    stato VARCHAR(50),
    data_contratto DATE
);

-- Creazione della tabella firma
CREATE TABLE IF NOT EXISTS firma (
    id_firma INT AUTO_INCREMENT PRIMARY KEY,
    data_firma DATE,
    id_giocatore INT,
    id_contratto INT,
    FOREIGN KEY (id_giocatore) REFERENCES giocatore(id_giocatore),
    FOREIGN KEY (id_contratto) REFERENCES contratto(id_contratto)
);

-- Creazione della tabella sottoscrizione
CREATE TABLE IF NOT EXISTS sottoscrizione (
    id_sottoscrizione INT AUTO_INCREMENT PRIMARY KEY,
    id_contratto INT,
    data_sottoscrizione DATE,
    FOREIGN KEY (id_contratto) REFERENCES contratto(id_contratto)
);

-- Creazione della tabella scambio
CREATE TABLE IF NOT EXISTS scambio (
    id_scambio INT AUTO_INCREMENT PRIMARY KEY,
    id_giocatore_a INT,
    id_giocatore_b INT,
    id_squadra_a INT,
    id_squadra_b INT,
    data DATE,
    dettagli TEXT,
    stato VARCHAR(50),
    FOREIGN KEY (id_giocatore_a) REFERENCES giocatore(id_giocatore),
    FOREIGN KEY (id_giocatore_b) REFERENCES giocatore(id_giocatore),
    FOREIGN KEY (id_squadra_a) REFERENCES squadra(id_squadra),
    FOREIGN KEY (id_squadra_b) REFERENCES squadra(id_squadra)
);

-- Creazione della tabella allenamento
CREATE TABLE IF NOT EXISTS allenamento (
    id_allenamento INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    data DATE,
    tipo VARCHAR(50),
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadra(id_squadra)
);

-- Creazione della tabella esercizio
CREATE TABLE IF NOT EXISTS esercizio (
    id_esercizio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descrizione TEXT,
    difficoltà VARCHAR(50)
);
