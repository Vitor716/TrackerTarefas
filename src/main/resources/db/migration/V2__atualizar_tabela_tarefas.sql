ALTER TABLE tarefas
ADD COLUMN data_inicio DATE,
ADD COLUMN data_termino DATE,
ADD COLUMN ativo BOOLEAN DEFAULT TRUE;

ALTER TABLE tarefas
DROP COLUMN data_conclusao;