-- Script para criar o banco de dados da pizzaria
-- Execute este script no MySQL Workbench ou via linha de comando

-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS pizzaria;
USE pizzaria;

-- Tabela usuario
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(500),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela categoria
CREATE TABLE IF NOT EXISTS categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    descricao TEXT
);

-- Tabela produto
CREATE TABLE IF NOT EXISTS produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE SET NULL
);

-- Tabela pedido
CREATE TABLE IF NOT EXISTS pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDENTE', 'PREPARANDO', 'PRONTO', 'ENTREGUE', 'CANCELADO') DEFAULT 'PENDENTE',
    valor_total DECIMAL(10,2) DEFAULT 0.00,
    endereco_entrega VARCHAR(500),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Tabela pedido_item
DROP TABLE IF EXISTS pedido_item;
CREATE TABLE pedido_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
);

-- Inserir dados de exemplo
-- Usuários
INSERT INTO usuario (nome, email, senha, telefone, endereco) VALUES
('João Silva', 'joao@email.com', '123456', '(31) 99999-9999', 'Rua A, 123'),
('Maria Santos', 'maria@email.com', '123456', '(31) 88888-8888', 'Rua B, 456');

-- Categorias
INSERT INTO categoria (nome, descricao) VALUES
('Pizzas Salgadas', 'Pizzas tradicionais com sabores salgados'),
('Pizzas Doces', 'Pizzas com sabores doces'),
('Bebidas', 'Refrigerantes e sucos');

-- Produtos
INSERT INTO produto (nome, descricao, preco, categoria_id) VALUES
('Pizza Margherita', 'Mussarela, tomate e manjericão', 35.00, 1),
('Pizza Calabresa', 'Calabresa, cebola e mussarela', 40.00, 1),
('Pizza Chocolate', 'Chocolate ao leite com granulado', 30.00, 2),
('Coca-Cola 2L', 'Refrigerante Coca-Cola 2 litros', 8.00, 3),
('Suco de Laranja', 'Suco natural de laranja 300ml', 5.00, 3);