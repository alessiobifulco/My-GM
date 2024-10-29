
-- Popolamento tabella GM
INSERT INTO gm (nome, cognome, email, password, id_squadra) VALUES 
('John', 'Doe', 'johndoe@example.com', 'password123', 1),
('Jane', 'Smith', 'janesmith@example.com', 'password456', 2),
('Mike', 'Johnson', 'mikejohnson@example.com', 'password789', 3);

-- Popolamento tabella Staff
INSERT INTO staff (nome, ruolo, email) VALUES 
('Steve', 'Allenatore', 'steve@lakers.com'),
('Mike', 'Allenatore', 'mike@warriors.com'),
('Tom', 'Assistente', 'tom@lakers.com');

-- Popolamento tabella Squadra
INSERT INTO squadra (nome, città, numero_giocatori, id_gm, id_staff) VALUES 
('Lakers', 'Los Angeles', 15, 1, 1),
('Warriors', 'San Francisco', 14, 2, 2),
('Bulls', 'Chicago', 12, 3, 3);

-- Popolamento tabella Giocatore
INSERT INTO giocatore (nome, cognome, età, posizione, esperienza, valutazione, freeagent, id_squadra, categoria) VALUES 
('LeBron', 'James', 36, 'Ala', 18, 95, FALSE, 1, 'SUPERSTAR'),
('Stephen', 'Curry', 33, 'Playmaker', 12, 98, FALSE, 2, 'SUPERSTAR'),
('Kevin', 'Durant', 35, 'Ala Grande', 16, 96, FALSE, 3, 'ALLSTAR'),
('James', 'Harden', 34, 'Guardia', 14, 94, FALSE, 1, 'ALLSTAR'),
('Kawhi', 'Leonard', 32, 'Ala', 11, 93, FALSE, 2, 'ALLSTAR'),
('Damian', 'Lillard', 33, 'Playmaker', 10, 90, TRUE, NULL, 'ROLEPLAYER'),
('Zach', 'LaVine', 28, 'Guardia', 8, 85, TRUE, NULL, 'ROLEPLAYER'),
('Julius', 'Randle', 29, 'Ala Grande', 6, 88, TRUE, NULL, 'BENCHPLAYER'),
('Chris', 'Paul', 39, 'Playmaker', 18, 97, FALSE, 1, 'SUPERSTAR'),
('Draymond', 'Green', 34, 'Ala', 12, 90, FALSE, 2, 'ROLEPLAYER');

-- Popolamento tabella Contratto
INSERT INTO contratto (durata, stipendio, clausola, stato, data_contratto) VALUES 
(3, 50000000, 'Nessuna clausola speciale', 'Attivo', '2022-07-01'),
(2, 35000000, 'Opzione di uscita al secondo anno', 'Attivo', '2023-07-01'),
(4, 20000000, 'Clausola di rinnovo', 'Attivo', '2022-06-15');

-- Popolamento tabella Firma
INSERT INTO firma (data_firma, id_giocatore, id_contratto) VALUES 
('2022-07-01', 1, 1),
('2023-07-01', 2, 2),
('2022-06-15', 3, 3);

-- Popolamento tabella Sottoscrizione
INSERT INTO sottoscrizione (id_contratto, data_sottoscrizione) VALUES 
(1, '2022-07-01'),
(2, '2023-07-01'),
(3, '2022-06-15');

-- Popolamento tabella Scambio
INSERT INTO scambio (id_giocatore_a, id_giocatore_b, id_squadra_a, id_squadra_b, data, dettagli, stato) VALUES 
(1, 2, 1, 2, '2024-02-01', 'Scambio tra LeBron James e Stephen Curry', 'Completato'),
(3, 4, 3, 1, '2024-03-01', 'Scambio tra Kevin Durant e James Harden', 'In attesa');

-- Popolamento tabella Allenamento
INSERT INTO allenamento (nome, data, tipo, id_squadra) VALUES 
('Allenamento Pre-Stagione', '2024-09-01', 'Gruppo', 1),
('Allenamento di Tiro', '2024-09-02', 'Individuale', 2),
('Allenamento Difensivo', '2024-09-03', 'Gruppo', 3);

-- Popolamento tabella Esercizio
INSERT INTO esercizio (nome, descrizione, difficoltà) VALUES 
('Tiro da Tre Punti', 'Esercizio per migliorare il tiro da tre punti', 'Media'),
('Dribbling', 'Esercizio per migliorare il controllo di palla', 'Alta'),
('Passaggio', 'Esercizio per migliorare le abilità di passaggio', 'Bassa'),
('Palla a Due', 'Esercizio per le tecniche di palla a due', 'Media');