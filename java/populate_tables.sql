USE NBA_System;

-- Tabella GM (General Manager)
INSERT INTO GM (Nome, Cognome, Email, Telefono) VALUES
('Pat', 'Riley', 'pat.riley@example.com', '1234567890'),
('Danny', 'Ainge', 'danny.ainge@example.com', '1234567891'),
('Masai', 'Ujiri', 'masai.ujiri@example.com', '1234567892'),
('Jerry', 'West', 'jerry.west@example.com', '1234567893');

-- Tabella Squadra
INSERT INTO Squadra (Nome, Città, Numero_giocatori, ID_GM) VALUES
('Miami Heat', 'Miami', 5, 1),
('Boston Celtics', 'Boston', 5, 2),
('Toronto Raptors', 'Toronto', 5, 3),
('Golden State Warriors', 'San Francisco', 5, 4);

-- Tabella Giocatore
INSERT INTO Giocatore (Nome, Cognome, Posizione, Esperienza, Free_Agent, Categoria) VALUES
-- Giocatori con squadra (Miami Heat)
('Jimmy', 'Butler', 'Ala', 10, FALSE, 'SuperStar'),
('Bam', 'Adebayo', 'Centro', 6, FALSE, 'AllStar'),
('Kyle', 'Lowry', 'Playmaker', 11, FALSE, 'RolePlayer'),
('Tyler', 'Herro', 'Guardia', 4, FALSE, 'RolePlayer'),
('Duncan', 'Robinson', 'Ala', 5, FALSE, 'BenchPlayer'),

-- Giocatori con squadra (Boston Celtics)
('Jayson', 'Tatum', 'Ala', 7, FALSE, 'SuperStar'),
('Jaylen', 'Brown', 'Guardia', 6, FALSE, 'AllStar'),
('Marcus', 'Smart', 'Playmaker', 9, FALSE, 'RolePlayer'),
('Al', 'Horfod', 'Centro', 15, FALSE, 'BenchPlayer'),
('Robert', 'Williams', 'Centro', 4, FALSE, 'RolePlayer'),

-- Giocatori con squadra (Toronto Raptors)
('Fred', 'VanVleet', 'Playmaker', 8, FALSE, 'AllStar'),
('Pascal', 'Siakam', 'Ala', 7, FALSE, 'SuperStar'),
('OG', 'Anunoby', 'Ala', 5, FALSE, 'RolePlayer'),
('Gary', 'Trent Jr.', 'Guardia', 4, FALSE, 'RolePlayer'),
('Chris', 'Boucher', 'Centro', 6, FALSE, 'BenchPlayer'),

-- Giocatori con squadra (Golden State Warriors)
('Stephen', 'Curry', 'Playmaker', 15, FALSE, 'SuperStar'),
('Klay', 'Thompson', 'Guardia', 12, FALSE, 'AllStar'),
('Draymond', 'Green', 'Ala', 11, FALSE, 'RolePlayer'),
('Andrew', 'Wiggins', 'Ala', 7, FALSE, 'RolePlayer'),
('Kevon', 'Looney', 'Centro', 6, FALSE, 'BenchPlayer'),

-- Giocatori senza squadra
('LeBron', 'James', 'Ala', 21, TRUE, 'SuperStar'),
('Kevin', 'Durant', 'Ala', 16, TRUE, 'SuperStar'),
('Giannis', 'Antetokounmpo', 'Ala', 11, TRUE, 'SuperStar'),
('Kawhi', 'Leonard', 'Ala', 12, TRUE, 'SuperStar'),
('Luka', 'Doncic', 'Playmaker', 5, TRUE, 'AllStar'),
('James', 'Harden', 'Playmaker', 14, TRUE, 'SuperStar'),
('Anthony', 'Davis', 'Centro', 11, TRUE, 'AllStar'),
('Damian', 'Lillard', 'Playmaker', 12, TRUE, 'AllStar'),
('Zion', 'Williamson', 'Ala', 3, TRUE, 'RolePlayer'),
('Jamal', 'Murray', 'Playmaker', 6, TRUE, 'RolePlayer');

-- Tabella Staff
INSERT INTO Staff (Nome, Cognome, Ruolo, Salario, ID_Squadra, ID_GM) VALUES
('Erik', 'Spoelstra', 'Allenatore', 50000.00, 1, 1),
('Brad', 'Stevens', 'Preparatore', 40000.00, 2, 2),
('Nick', 'Nurse', 'Allenatore', 50000.00, 3, 3),
('Steve', 'Kerr', 'Allenatore', 50000.00, 4, 4);

-- Tabella Firma
INSERT INTO Firma (Data, ID_Giocatore, ID_GM) VALUES
('2023-06-01', 1, 1),
('2023-06-15', 2, 2),
('2023-07-01', 3, 3),
('2023-07-15', 4, 4),
('2023-08-01', 5, 1),
('2023-08-15', 6, 2),
('2023-09-01', 7, 3),
('2023-09-15', 8, 4),
('2023-10-01', 9, 1),
('2023-10-15', 10, 2);

-- Tabella Sottoscrizione
INSERT INTO Sottoscrizione (Durata, Data, ID_Firma) VALUES
(12, '2023-06-02', 1),
(24, '2023-06-16', 2),
(6, '2023-07-02', 3),
(12, '2023-07-16', 4),
(24, '2023-08-02', 5),
(12, '2023-08-16', 6),
(18, '2023-09-02', 7),
(24, '2023-09-16', 8),
(12, '2023-10-02', 9),
(24, '2023-10-16', 10);

-- Tabella Contratto
INSERT INTO Contratto (Data_Inizio, Data_Fine, Vincoli, Salario, ID_Sottoscrizione) VALUES
('2023-06-03', '2024-06-03', 'Clausola di Riacquisto', 60000.00, 1),
('2023-06-17', '2025-06-17', 'Nessuna Clausola', 70000.00, 2),
('2023-07-03', '2024-01-03', 'Clausola di Opzione', 50000.00, 3),
('2023-07-17', '2024-07-17', 'Clausola di Riacquisto', 55000.00, 4),
('2023-08-03', '2025-08-03', 'Clausola di Prestito', 65000.00, 5),
('2023-08-17', '2024-08-17', 'Nessuna Clausola', 60000.00, 6),
('2023-09-03', '2025-09-03', 'Clausola di Opzione', 70000.00, 7),
('2023-09-17', '2024-09-17', 'Clausola di Riacquisto', 65000.00, 8),
('2023-10-03', '2025-10-03', 'Clausola di Prestito', 60000.00, 9),
('2023-10-17', '2025-10-17', 'Nessuna Clausola', 70000.00, 10);

-- Tabella Scambio
INSERT INTO Scambio (Stato, Data, ID_Squadra_A, ID_Squadra_B, ID_Giocatore_A, ID_Giocatore_B) VALUES
('Completato', '2023-08-01', 1, 2, 1, 6),
('Completato', '2023-08-15', 2, 3, 2, 7),
('Completato', '2023-09-01', 3, 4, 3, 8),
('Completato', '2023-09-15', 4, 1, 4, 9),
('Completato', '2023-10-01', 1, 3, 5, 10);

-- Tabella Allenamento
INSERT INTO Allenamento (Data, Durata, Tipo, Singolo, ID_Staff, ID_Giocatore) VALUES
('2023-07-01', 90, 'Tecnico', FALSE, 1, NULL),
('2023-07-05', 120, 'Fisico', TRUE, 2, 1),
('2023-08-01', 60, 'Tecnico', FALSE, 3, NULL),
('2023-08-15', 75, 'Fisico', TRUE, 4, 3);

-- Tabella Esercizio
INSERT INTO Esercizio (Nome, Descrizione, Durata, ID_Allenamento) VALUES
('Dribbling Intensivo', 'Allenamento intensivo per migliorare il controllo del pallone', 30, 1),
('Tiri da Tre', 'Sessione di tiri da lunga distanza', 30, 1),
('Scatti e Resistenza', 'Allenamento per migliorare la velocità e la resistenza', 45, 2),
('Allenamento Muscolare', 'Sessione di potenziamento muscolare', 45, 2),
('Esercizi di Passaggi', 'Allenamento per migliorare i passaggi', 30, 3),
('Sfondamenti e Difesa', 'Sessione di allenamento difensivo', 30, 3),
('Tecnica di Tiro', 'Allenamento specifico sulla tecnica di tiro', 30, 4),
('Strategia di Gioco', 'Sessione di esercizi per migliorare la strategia di gioco', 30, 4),
('Recupero Post-Partita', 'Esercizi per il recupero dopo le partite', 30, 4),
('Preparazione Fisica Completa', 'Allenamento completo per preparare il corpo', 45, 4);
