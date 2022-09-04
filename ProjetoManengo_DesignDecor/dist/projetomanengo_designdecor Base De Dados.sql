-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Set-2020 às 16:31
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetomanengo_designdecor`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sexo` varchar(15) NOT NULL,
  `funcao` varchar(40) NOT NULL,
  `contacto` varchar(15) DEFAULT NULL,
  `identificacao` varchar(14) NOT NULL,
  `faltas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `sexo`, `funcao`, `contacto`, `identificacao`, `faltas`) VALUES
(1, 'Aurélio Macie Júnior', 'Masculino', 'Operario', '+258-845101634', '123456789124c', 4),
(5, 'Amateu Teu', 'Feminino', 'Atendente', '+258-875101632', '111111118811V', 3),
(7, 'Antoninho Marcos', 'Masculino', 'Assistente', '+258-123421243', '121324235432C', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `qtd` int(11) NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `qtd`, `valor`) VALUES
(5, 'Madeira Macica', 102, 23000),
(6, 'Chapa Quadrada', 342, 557.59),
(8, 'Pedras', 176, 242),
(9, 'Armario composto', 200, 120000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `senha`, `tipo`) VALUES
(1, 'Macie', '123', 'Administrador'),
(3, 'Aurelio jose Macie junior', '12345', 'Administrador'),
(4, 'Mateu Alberto Paito', '12345', 'Gestor De Venda'),
(6, 'Mariana Macie', '111', 'Gestor De Venda'),
(7, 'Atendane Zitha', '222', 'Administrador'),
(8, 'Limpa Logo Essa Cena', '111', 'Gestor De Venda'),
(10, 'Junior Macie', '1111', 'Administrador'),
(11, 'Safira Saquina', '1111111', 'Gestor De Venda'),
(12, 'Antoninho Maengane', '222', 'Administrador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `cliente` varchar(50) NOT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `produto` varchar(60) NOT NULL,
  `qtd` int(11) NOT NULL,
  `precoun` float NOT NULL,
  `vapagar` float NOT NULL,
  `pagamento` float NOT NULL,
  `data` varchar(50) NOT NULL,
  `hora` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id`, `usuario`, `cliente`, `contacto`, `endereco`, `produto`, `qtd`, `precoun`, `vapagar`, `pagamento`, `data`, `hora`) VALUES
(11, 'Aurelio jose Macie junior', 'estestgdfgfdgfdgfdg', 'estestgdfgfdgfdgfdg', 'r6563dgfcvbvjygh', 'Madeira', 23, 23, 529, 530, '8 de Setembro de 2020', '10:26'),
(12, 'Aurelio jose Macie junior', 'cxvcx dfdrd etertrt', 'cxvcx dfdrd etertrt', 'vcg fb. vgfhfgh, gh', 'Chapa', 24, 55.5, 1332, 1330, '8 de Setembro de 2020', '10:36'),
(13, 'Antoninho Maengane', 'Antonio Marcos', 'Antonio Marcos', 'Matendene, rua 15', 'Armario composto', 78, 120000, 9360000, 9360000, '9 de Setembro de 2020', '02:41'),
(14, 'Antoninho Maengane', 'sfsdsvsdfdfds', 'sfsdsvsdfdfds', 'dsfdfesdfsdfsdf', 'Chapa Quadrada', 4, 557.59, 2230.36, 2200, '9 de Setembro de 2020', '02:53');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `contacto` (`contacto`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `contacto` (`contacto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
