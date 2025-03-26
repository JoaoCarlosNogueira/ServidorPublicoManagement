
INSERT INTO pessoa (pes_nome, pes_data_nascimento, pes_sexo, pes_mae, pes_pai) VALUES
('João Silva', '1985-06-15', 'Masculino', 'Maria Silva', 'Carlos Silva'),
('Ana Souza', '1990-08-22', 'Feminino', 'Fernanda Souza', 'Roberto Souza');

INSERT INTO foto_pessoa (pes_id, fp_data, fp_bucket, fp_hash) VALUES
(1, '2025-03-16', 'fotos_pessoas', 'hash123abc'),
(2, '2025-03-16', 'fotos_pessoas', 'hash456def');

INSERT INTO cidade (cid_nome, cid_uf) VALUES
('São Paulo', 'SP'),
('Rio de Janeiro', 'RJ');

INSERT INTO endereco (end_tipo_logradouro, end_logradouro, end_numero, end_bairro, cid_id) VALUES
('Rua', 'Avenida Paulista', 1000, 'Centro', 1),
('Rua', 'Copacabana', 200, 'Zona Sul', 2);

INSERT INTO pessoa_endereco (pes_id, end_id) VALUES
(1, 1),
(2, 2);

INSERT INTO servidor_temporario (pes_id, st_data_admissao, st_data_demissao) VALUES
(1, '2023-01-01', '2023-12-31'),
(2, '2024-02-01', NULL);

INSERT INTO servidor_efetivo (pes_id, se_matricula) VALUES
(1, 'MAT123456'),
(2, 'MAT789012');

INSERT INTO unidade (unid_nome, unid_sigla) VALUES
('Unidade Central', 'UC'),
('Unidade Regional', 'UR');

INSERT INTO lotacao (pes_id, unid_id, lot_data_lotacao, lot_data_remocao, lot_portaria) VALUES
(1, 1, '2023-03-01', NULL, 'PORT123'),
(2, 2, '2024-01-15', NULL, 'PORT456');

INSERT INTO unidade_endereco (unid_id, end_id) VALUES
(1, 1),
(2, 2);
