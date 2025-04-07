-- V2: Migrations para adicionar a coluna RANK_NINJA na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank_ninja VARCHAR(255);