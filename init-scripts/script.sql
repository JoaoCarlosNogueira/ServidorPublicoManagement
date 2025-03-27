INSERT INTO pessoa (pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai) VALUES
('João Silva', '1985-06-15', 'Masculino', 'Maria Silva', 'Carlos Silva'),
('Ana Souza', '1990-08-22', 'Feminino', 'Fernanda Souza', 'Roberto Souza'),
('Carlos Silva', '1982-12-10', 'Masculino', 'Eliane Silva', 'Paulo Silva'),
('Mariana Souza', '1987-05-20', 'Feminino', 'Sandra Souza', 'José Souza'),
('Ricardo Pereira', '1992-07-05', 'Masculino', 'Cláudia Pereira', 'Antônio Pereira'),
('Fernanda Oliveira', '1995-02-14', 'Feminino', 'Elisa Oliveira', 'Rogério Oliveira'),
('Lucas Costa', '1988-11-30', 'Masculino', 'Tatiane Costa', 'Jorge Costa'),
('Patrícia Almeida', '1993-03-12', 'Feminino', 'Marta Almeida', 'Fernando Almeida'),
('Eduardo Santos', '1980-09-25', 'Masculino', 'Beatriz Santos', 'Ricardo Santos'),
('Renata Lima', '1996-04-03', 'Feminino', 'Luíza Lima', 'Carlos Lima');

INSERT INTO cidade (cid_nome, cid_uf) VALUES
('São Paulo', 'SP'),
('Rio de Janeiro', 'RJ'),
('Belo Horizonte', 'MG'),
('Porto Alegre', 'RS'),
('Salvador', 'BA'),
('Fortaleza', 'CE'),
('Curitiba', 'PR'),
('Recife', 'PE'),
('Manaus', 'AM'),
('Vitória', 'ES');

INSERT INTO endereco (end_tipo_logradouro, end_logradouro, end_numero, end_bairro, cid_id) VALUES
('Rua', 'Avenida Paulista', 1000, 'Centro', 1),
('Rua', 'Copacabana', 200, 'Zona Sul', 2),
('Rua', 'Avenida do Contorno', 500, 'Savassi', 3),
('Rua', 'Rua dos Três Irmãos', 800, 'Centro', 4),
('Rua', 'Avenida Rio Branco', 100, 'Centro', 5),
('Rua', 'Rua do Catete', 400, 'Catete', 6),
('Rua', 'Rua XV de Novembro', 700, 'Centro', 7),
('Rua', 'Avenida Engenheiro Luís Carlos Berrini', 1200, 'Berrini', 8),
('Rua', 'Rua Domingos Martins', 300, 'Barra', 9),
('Rua', 'Avenida Tancredo Neves', 1500, 'Tancredo Neves', 10);

INSERT INTO pessoa_endereco (pes_id, end_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO servidor_temporario (pes_id, st_data_admissao, st_data_demissao) VALUES
(1, '2023-01-01', '2023-12-31'),
(2, '2024-02-01', NULL),
(3, '2023-02-01', '2023-10-15'),
(4, '2023-06-01', '2023-12-01'),
(5, '2023-07-01', '2023-11-30'),
(6, '2023-08-01', NULL),
(7, '2023-03-01', '2023-09-30'),
(8, '2023-04-01', '2023-12-31'),
(9, '2023-09-01', NULL),
(10, '2023-05-01', '2023-12-31');

INSERT INTO servidor_efetivo (pes_id, se_matricula) VALUES
(1, 'MAT123456'),
(2, 'MAT789012'),
(3, 'MAT345678'),
(4, 'MAT901234'),
(5, 'MAT567890'),
(6, 'MAT234567'),
(7, 'MAT890123'),
(8, 'MAT456789'),
(9, 'MAT123890'),
(10, 'MAT678901');

INSERT INTO unidade (unid_nome, unid_sigla) VALUES
('Unidade Central', 'UC'),
('Unidade Regional', 'UR'),
('Unidade Norte', 'UN'),
('Unidade Sul', 'US'),
('Unidade Leste', 'UL'),
('Unidade Oeste', 'UO'),
('Unidade Zona Norte', 'ZN'),
('Unidade Zona Sul', 'ZS'),
('Unidade Metropolitana', 'UM'),
('Unidade Penha', 'UP');

INSERT INTO lotacao (pes_id, unid_id, lot_data_lotacao, lot_data_remocao, lot_portaria) VALUES
(1, 1, '2023-03-01', NULL, 'PORT001'),
(2, 2, '2023-04-01', NULL, 'PORT002'),
(3, 3, '2023-05-01', NULL, 'PORT003'),
(4, 4, '2023-06-01', NULL, 'PORT004'),
(5, 5, '2023-07-01', NULL, 'PORT005'),
(6, 6, '2023-08-01', NULL, 'PORT006'),
(7, 7, '2023-09-01', NULL, 'PORT007'),
(8, 8, '2023-10-01', NULL, 'PORT008'),
(9, 9, '2023-11-01', NULL, 'PORT009'),
(10, 10, '2023-12-01', NULL, 'PORT010');

INSERT INTO unidade_endereco (unid_id, end_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);
