-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 20 juin 2025 à 07:36
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `demo-sdv`
--
CREATE DATABASE IF NOT EXISTS `demo-sdv` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `demo-sdv`;

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `liste_id` int NOT NULL,
  `nom` varchar(100) NOT NULL,
  `quantite` varchar(50) DEFAULT NULL,
  `categorie` varchar(50) DEFAULT NULL,
  `notes` text,
  `est_achete` tinyint(1) DEFAULT '0',
  `date_ajout` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `liste_id` (`liste_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`id`, `liste_id`, `nom`, `quantite`, `categorie`, `notes`, `est_achete`, `date_ajout`) VALUES
(1, 1, 'Pommes', '1kg', 'Fruits', 'Acheter bio si possible', 0, '2025-06-16 10:33:55'),
(2, 1, 'Lait', '2L', 'Produits laitiers', '', 1, '2025-06-16 10:33:55');

-- --------------------------------------------------------

--
-- Structure de la table `historique_achats`
--

DROP TABLE IF EXISTS `historique_achats`;
CREATE TABLE IF NOT EXISTS `historique_achats` (
  `id` int NOT NULL AUTO_INCREMENT,
  `article_id` int NOT NULL,
  `utilisateur_id` int DEFAULT NULL,
  `date_achat` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `utilisateur_id` (`utilisateur_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `historique_achats`
--

INSERT INTO `historique_achats` (`id`, `article_id`, `utilisateur_id`, `date_achat`) VALUES
(1, 1, 1, '2025-06-16 10:34:04'),
(2, 2, 2, '2025-06-16 10:34:04'),
(3, 1, 1, NULL),
(4, 2, 2, NULL),
(5, 1, 1, NULL),
(6, 2, 2, NULL),
(7, 1, 1, NULL),
(8, 2, 2, NULL),
(9, 1, 1, NULL),
(10, 2, 2, NULL),
(11, 1, 1, NULL),
(12, 2, 2, NULL),
(13, 1, 1, NULL),
(14, 2, 2, NULL),
(15, 1, 1, NULL),
(16, 2, 2, NULL),
(17, 1, 1, NULL),
(18, 2, 2, NULL),
(19, 1, 1, NULL),
(20, 2, 2, NULL),
(21, 1, 1, NULL),
(22, 2, 2, NULL),
(23, 1, 1, NULL),
(24, 2, 2, NULL),
(25, 1, 1, NULL),
(26, 2, 2, NULL),
(27, 1, 1, NULL),
(28, 2, 2, NULL),
(29, 1, 1, NULL),
(30, 2, 2, NULL),
(31, 1, 1, NULL),
(32, 2, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `date_creation` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `prenom`, `email`, `mot_de_passe`, `avatar_url`, `date_creation`) VALUES
(1, 'Durand', 'Claire', 'claire.durand@example.com', 'motdepasse123', NULL, '2025-06-16 10:33:39'),
(2, 'Martin', 'Lucas', 'lucas.martin@example.com', 'securepass456', 'https://example.com/avatar/lucas.png', '2025-06-16 10:33:39');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_liste`
--

DROP TABLE IF EXISTS `utilisateur_liste`;
CREATE TABLE IF NOT EXISTS `utilisateur_liste` (
  `utilisateur_id` int NOT NULL,
  `liste_id` int NOT NULL,
  PRIMARY KEY (`utilisateur_id`,`liste_id`),
  KEY `liste_id` (`liste_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur_liste`
--

INSERT INTO `utilisateur_liste` (`utilisateur_id`, `liste_id`) VALUES
(1, 1),
(2, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
