CREATE TABLE tarefas (
     id BIGSERIAL PRIMARY KEY,
     titulo VARCHAR(100) NOT NULL,
     descricao VARCHAR(100),
     status VARCHAR(100) NOT NULL,
     data_conclusao DATE NOT NULL
);