
CREATE TABLE gm (
    id_gm INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    id_squadra INT UNIQUE
);

CREATE TABLE squadra (
    id_squadra INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    città VARCHAR(100) NOT NULL,
    numero_giocatori INT DEFAULT 0,
    id_gm INT,
    id_staff INT,
    FOREIGN KEY (id_gm) REFERENCES gm(id_gm),
    FOREIGN KEY (id_staff) REFERENCES staff(id_staff)
);

CREATE TABLE staff (
    id_staff INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ruolo VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE giocatore (
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

CREATE TABLE contratto (
    id_contratto INT AUTO_INCREMENT PRIMARY KEY,
    durata INT NOT NULL,
    stipendio DECIMAL(10, 2) NOT NULL,
    clausola TEXT,
    stato VARCHAR(50),
    data_contratto DATE
);

CREATE TABLE firma (
    id_firma INT AUTO_INCREMENT PRIMARY KEY,
    data_firma DATE,
    id_giocatore INT,
    id_contratto INT,
    FOREIGN KEY (id_giocatore) REFERENCES giocatore(id_giocatore),
    FOREIGN KEY (id_contratto) REFERENCES contratto(id_contratto)
);

CREATE TABLE sottoscrizione (
    id_sottoscrizione INT AUTO_INCREMENT PRIMARY KEY,
    id_contratto INT,
    data_sottoscrizione DATE,
    FOREIGN KEY (id_contratto) REFERENCES contratto(id_contratto)
);

CREATE TABLE scambio (
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

CREATE TABLE allenamento (
    id_allenamento INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    data DATE,
    tipo VARCHAR(50),
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadra(id_squadra)
);

CREATE TABLE esercizio (
    id_esercizio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    descrizione TEXT,
    difficoltà VARCHAR(50)
);
