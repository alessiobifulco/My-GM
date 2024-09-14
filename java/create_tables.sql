DROP DATABASE IF EXISTS NBA_System;
CREATE DATABASE IF NOT EXISTS NBA_System;
USE NBA_System;

-- Tabella GM (General Manager)
CREATE TABLE GM (
    ID_GM INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Cognome VARCHAR(50),
    Email VARCHAR(100),
    Telefono VARCHAR(20)
);

-- Tabella Squadra
CREATE TABLE Squadra (
    ID_Squadra INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Città VARCHAR(50),
    Numero_giocatori INT,
    ID_GM INT NOT NULL,  -- Chiave esterna per il General Manager
    FOREIGN KEY (ID_GM) REFERENCES GM(ID_GM)
);

-- Tabella Giocatore
CREATE TABLE Giocatore (
    ID_Giocatore INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Cognome VARCHAR(50),
    Posizione VARCHAR(50),
    Esperienza INT,
    Free_Agent BOOLEAN DEFAULT TRUE,  -- Valore predefinito per free agent
    Categoria ENUM('SuperStar', 'AllStar', 'RolePlayer', 'BenchPlayer')  -- Enum per le categorie
);

-- Tabella Staff
CREATE TABLE Staff (
    ID_Staff INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Cognome VARCHAR(50),
    Ruolo ENUM('Allenatore', 'Osservatore', 'Preparatore', 'Direttore Finanziario'),  -- ENUM per ruoli predefiniti
    Salario DECIMAL(10,2), 
    ID_Squadra INT NOT NULL,
    ID_GM INT NOT NULL,
	FOREIGN KEY (ID_Squadra) REFERENCES Squadra(ID_Squadra),
    FOREIGN KEY (ID_GM) REFERENCES GM(ID_GM)
);

-- Tabella Firma
CREATE TABLE Firma (
    ID_Firma INT PRIMARY KEY AUTO_INCREMENT,
    Data DATE,
    ID_Giocatore INT NOT NULL,       
    ID_GM INT NOT NULL,
    FOREIGN KEY (ID_Giocatore) REFERENCES Giocatore(ID_Giocatore),
    FOREIGN KEY (ID_GM) REFERENCES GM(ID_GM)
);

-- Tabella Sottoscrizione
CREATE TABLE Sottoscrizione (
    ID_Sottoscrizione INT PRIMARY KEY AUTO_INCREMENT,
    Durata INT,
    Data DATE,
    ID_Firma INT NOT NULL,  -- Chiave esterna per la Firma
    FOREIGN KEY (ID_Firma) REFERENCES Firma(ID_Firma)
);

-- Tabella Contratto
CREATE TABLE Contratto (
    ID_Contratto INT PRIMARY KEY AUTO_INCREMENT,
    Data_Inizio DATE,
    Data_Fine DATE,
    Vincoli VARCHAR(100),
    Salario DECIMAL(10,2),
    ID_Sottoscrizione INT NOT NULL,
    FOREIGN KEY (ID_Sottoscrizione) REFERENCES Sottoscrizione(ID_Sottoscrizione)
);

-- Tabella Scambio
CREATE TABLE Scambio (
    ID_Scambio INT PRIMARY KEY AUTO_INCREMENT,
    Stato VARCHAR(50),
    Data DATE,
    ID_Squadra_A INT NOT NULL,  -- Chiave esterna per la prima Squadra coinvolta nello scambio
    ID_Squadra_B INT NOT NULL,  -- Chiave esterna per la seconda Squadra coinvolta nello scambio
    ID_Giocatore_A INT NOT NULL,  -- Chiave esterna per il primo Giocatore coinvolto nello scambio
    ID_Giocatore_B INT NOT NULL,  -- Chiave esterna per il secondo Giocatore coinvolto nello scambio
    FOREIGN KEY (ID_Squadra_A) REFERENCES Squadra(ID_Squadra),
    FOREIGN KEY (ID_Squadra_B) REFERENCES Squadra(ID_Squadra),
    FOREIGN KEY (ID_Giocatore_A) REFERENCES Giocatore(ID_Giocatore),
    FOREIGN KEY (ID_Giocatore_B) REFERENCES Giocatore(ID_Giocatore)
);

-- Tabella Allenamento
CREATE TABLE Allenamento (
    ID_Allenamento INT PRIMARY KEY AUTO_INCREMENT,
    Data DATE,
    Durata INT,
    Tipo VARCHAR(50),
    Singolo BOOLEAN DEFAULT FALSE,  -- TRUE per singolo, FALSE per di gruppo
    ID_Staff INT NOT NULL,  -- Chiave esterna per il membro dello Staff
    ID_Giocatore INT,  -- Chiave esterna per il Giocatore partecipante
    FOREIGN KEY (ID_Staff) REFERENCES Staff(ID_Staff),
    FOREIGN KEY (ID_Giocatore) REFERENCES Giocatore(ID_Giocatore)
);

-- Tabella Esercizio
CREATE TABLE Esercizio (
    ID_Esercizio INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Descrizione VARCHAR(255),
    Durata INT,  -- Durata in minuti
    ID_Allenamento INT NOT NULL,  -- Chiave esterna per l'Allenamento
    FOREIGN KEY (ID_Allenamento) REFERENCES Allenamento(ID_Allenamento)
);