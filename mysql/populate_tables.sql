
-- Popolamento tabella GM
INSERT INTO gm (nome, cognome, email, password, id_squadra) VALUES 
('John', 'Doe', 'johndoe@example.com', 'password123', 1),
('Jane', 'Smith', 'janesmith@example.com', 'password456', 2);

-- Popolamento tabella Squadra
INSERT INTO squadra (nome, città, numero_giocatori, id_gm, id_staff) VALUES 
('Lakers', 'Los Angeles', 15, 1, 1),
('Warriors', 'San Francisco', 14, 2, 2);

-- Popolamento tabella Staff
INSERT INTO staff (nome, ruolo, email) VALUES 
('Steve', 'Allenatore', 'steve@lakers.com'),
('Mike', 'Allenatore', 'mike@warriors.com');

-- Popolamento tabella Giocatore
INSERT INTO giocatore (nome, cognome, età, posizione, esperienza, valutazione, freeagent, id_squadra) VALUES 
('LeBron', 'James', 36, 'Ala', 18, 95, FALSE, 1),
('Stephen', 'Curry', 33, 'Playmaker', 12, 98, FALSE, 2);

-- Popolamento tabella Contratto
INSERT INTO contratto (durata, stipendio, clausola, stato, data_contratto) VALUES 
(3, 50000000, 'Nessuna clausola speciale', 'Attivo', '2022-07-01'),
(2, 35000000, 'Opzione di uscita al secondo anno', 'Attivo', '2023-07-01');

-- Popolamento tabella Firma
INSERT INTO firma (data_firma, id_giocatore, id_contratto) VALUES 
('2022-07-01', 1, 1),
('2023-07-01', 2, 2);

-- Popolamento tabella Sottoscrizione
INSERT INTO sottoscrizione (id_contratto, data_sottoscrizione) VALUES 
(1, '2022-07-01'),
(2, '2023-07-01');

-- Popolamento tabella Scambio
INSERT INTO scambio (id_giocatore_a, id_giocatore_b, id_squadra_a, id_squadra_b, data, dettagli, stato) VALUES 
(1, 2, 1, 2, '2024-02-01', 'Scambio tra LeBron James e Stephen Curry', 'Completato');

-- Popolamento tabella Allenamento
INSERT INTO allenamento (nome, data, tipo, id_squadra) VALUES 
('Allenamento Pre-Stagione', '2024-09-01', 'Gruppo', 1),
('Allenamento di Tiro', '2024-09-02', 'Individuale', 2);

-- Popolamento tabella Esercizio
INSERT INTO esercizio (nome, descrizione, difficoltà) VALUES 
('Tiro da Tre Punti', 'Esercizio per migliorare il tiro da tre punti', 'Media'),
('Dribbling', 'Esercizio per migliorare il controllo di palla', 'Alta');
