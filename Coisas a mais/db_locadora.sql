-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 02/02/2019 às 06:39
-- Versão do servidor: 10.1.35-MariaDB
-- Versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_locadora`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_aluguel`
--

CREATE TABLE `tb_aluguel` (
  `idaluguel` int(11) NOT NULL,
  `hora_aluguel` varchar(45) NOT NULL,
  `data_aluguel` varchar(45) NOT NULL,
  `data_devolucao` varchar(45) NOT NULL,
  `tb_dvd_iddvd` int(11) NOT NULL,
  `tb_funcionario_idfuncionario` int(11) NOT NULL,
  `tb_cliente_idcliente` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_aluguel`
--

INSERT INTO `tb_aluguel` (`idaluguel`, `hora_aluguel`, `data_aluguel`, `data_devolucao`, `tb_dvd_iddvd`, `tb_funcionario_idfuncionario`, `tb_cliente_idcliente`, `status`) VALUES
(1, '00:01', '03/12/2018', '17/12/2018', 5, 1, 1, 'Devolvido'),
(3, '10:02', '03/12/2018', '24/12/2018', 6, 1, 1, 'Devolvido'),
(4, '10:08', '03/12/2018', '27/12/2018', 7, 3, 1, 'Devolvido'),
(5, '10:18', '06/12/2018', '19/12/2018', 5, 1, 2, 'Devolvido'),
(6, '10:35', '06/12/2018', '26/12/2018', 6, 1, 2, 'Devolvido'),
(7, '11:23', '06/12/2018', '28/12/2018', 7, 1, 1, 'Devolvido'),
(8, '17:12', '07/12/2018', '25/12/2018', 8, 1, 1, 'Devolvido'),
(9, '17:13', '07/12/2018', '26/12/2018', 9, 3, 1, 'Devolvido'),
(10, '17:21', '07/12/2018', '26/12/2018', 8, 1, 1, 'Devolvido'),
(11, '07:25', '10/12/2018', '27/12/2018', 7, 3, 2, 'Devolvido'),
(12, '09:21', '10/12/2018', '30/12/2018', 6, 1, 3, 'Devolvido');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_categoria`
--

CREATE TABLE `tb_categoria` (
  `idcategoria` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_categoria`
--

INSERT INTO `tb_categoria` (`idcategoria`, `nome`) VALUES
(1, 'Ação'),
(2, 'Drama'),
(3, 'Terror'),
(4, 'Romance'),
(5, 'Infantil');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_classificacao`
--

CREATE TABLE `tb_classificacao` (
  `idclassificacao` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_classificacao`
--

INSERT INTO `tb_classificacao` (`idclassificacao`, `nome`, `preco`) VALUES
(2, 'Excelente', 7.5),
(3, 'Bom', 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_nasc` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`idcliente`, `nome`, `data_nasc`, `rg`, `cpf`, `email`, `telefone`, `bairro`, `rua`, `numero`, `cep`) VALUES
(1, 'Maria Eduarda Carvalho Rocha', '18/04/2003', '1231223412-5', '341.241.234-12', 'eduarda@gmail.com', '(85)94002-8922', 'Centro', 'Menezes Pimentel', '543', '62670-000'),
(2, 'Artur Morais Mesquita', '08/10/2002', '2131421453-1', '341.234.123-41', 'arturcnsd@gmail.com', '(85)99123-1232', 'Piroca', 'Centro', '12', '62670-000'),
(3, 'Heden Silva', '12/03/1978', '2131312313-1', '131.312.312-31', 'hedensilva@gmail.com', '(85)94002-8922', 'Bom Jardim', 'das Flores', '23', '62670-000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_dvd`
--

CREATE TABLE `tb_dvd` (
  `iddvd` int(11) NOT NULL,
  `preco_compra` double NOT NULL,
  `data_compra` varchar(45) NOT NULL,
  `situacao` varchar(45) NOT NULL,
  `tb_filme_idfilme` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_dvd`
--

INSERT INTO `tb_dvd` (`iddvd`, `preco_compra`, `data_compra`, `situacao`, `tb_filme_idfilme`) VALUES
(5, 45.99, '22/10/2018', 'Disponível', 4),
(6, 23.49, '29/07/2018', 'Disponível', 5),
(7, 35.99, '14/10/2018', 'Disponível', 6),
(8, 30, '11/12/2018', 'Disponível', 7),
(9, 40, '16/07/2018', 'Disponível', 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_filme`
--

CREATE TABLE `tb_filme` (
  `idfilme` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `ano` int(11) NOT NULL,
  `duracao` varchar(20) NOT NULL,
  `capa` varchar(80) NOT NULL,
  `tb_categoria_idcategoria` int(11) NOT NULL,
  `tb_classificacao_idclassificacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_filme`
--

INSERT INTO `tb_filme` (`idfilme`, `titulo`, `ano`, `duracao`, `capa`, `tb_categoria_idcategoria`, `tb_classificacao_idclassificacao`) VALUES
(4, 'Get Out', 2017, '02:30', 'getout.jpeg', 3, 2),
(5, 'Pantera Negra', 2018, '02:30', 'pantera.jpeg', 1, 2),
(6, 'Jogador Numero Um', 2018, '02:30', 'jogadorn1.jpeg', 1, 2),
(7, 'Intocáveis', 2009, '02:30', 'intocaveis.jpg', 2, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_funcionario`
--

CREATE TABLE `tb_funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tb_funcionario`
--

INSERT INTO `tb_funcionario` (`idfuncionario`, `nome`, `login`, `senha`) VALUES
(1, 'Matheus Rocha', 'admin', 'admin'),
(3, 'Elaine Sales', 'elaine', 'gatashow');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  ADD PRIMARY KEY (`idaluguel`),
  ADD KEY `fk_tb_aluguel_tb_dvd1_idx` (`tb_dvd_iddvd`),
  ADD KEY `fk_tb_aluguel_tb_funcionario1_idx` (`tb_funcionario_idfuncionario`),
  ADD KEY `fk_tb_aluguel_tb_cliente1_idx` (`tb_cliente_idcliente`);

--
-- Índices de tabela `tb_categoria`
--
ALTER TABLE `tb_categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Índices de tabela `tb_classificacao`
--
ALTER TABLE `tb_classificacao`
  ADD PRIMARY KEY (`idclassificacao`);

--
-- Índices de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices de tabela `tb_dvd`
--
ALTER TABLE `tb_dvd`
  ADD PRIMARY KEY (`iddvd`),
  ADD KEY `fk_tb_dvd_tb_filme1_idx` (`tb_filme_idfilme`);

--
-- Índices de tabela `tb_filme`
--
ALTER TABLE `tb_filme`
  ADD PRIMARY KEY (`idfilme`),
  ADD KEY `fk_tb_filme_tb_categoria_idx` (`tb_categoria_idcategoria`),
  ADD KEY `fk_tb_filme_tb_classificacao1_idx` (`tb_classificacao_idclassificacao`);

--
-- Índices de tabela `tb_funcionario`
--
ALTER TABLE `tb_funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  MODIFY `idaluguel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `tb_categoria`
--
ALTER TABLE `tb_categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tb_classificacao`
--
ALTER TABLE `tb_classificacao`
  MODIFY `idclassificacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_dvd`
--
ALTER TABLE `tb_dvd`
  MODIFY `iddvd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `tb_filme`
--
ALTER TABLE `tb_filme`
  MODIFY `idfilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tb_funcionario`
--
ALTER TABLE `tb_funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `tb_aluguel`
--
ALTER TABLE `tb_aluguel`
  ADD CONSTRAINT `fk_tb_aluguel_tb_cliente1` FOREIGN KEY (`tb_cliente_idcliente`) REFERENCES `tb_cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_aluguel_tb_dvd1` FOREIGN KEY (`tb_dvd_iddvd`) REFERENCES `tb_dvd` (`iddvd`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_aluguel_tb_funcionario1` FOREIGN KEY (`tb_funcionario_idfuncionario`) REFERENCES `tb_funcionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `tb_dvd`
--
ALTER TABLE `tb_dvd`
  ADD CONSTRAINT `fk_tb_dvd_tb_filme1` FOREIGN KEY (`tb_filme_idfilme`) REFERENCES `tb_filme` (`idfilme`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `tb_filme`
--
ALTER TABLE `tb_filme`
  ADD CONSTRAINT `fk_tb_filme_tb_categoria` FOREIGN KEY (`tb_categoria_idcategoria`) REFERENCES `tb_categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_filme_tb_classificacao1` FOREIGN KEY (`tb_classificacao_idclassificacao`) REFERENCES `tb_classificacao` (`idclassificacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
