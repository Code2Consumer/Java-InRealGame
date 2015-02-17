-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 17 Février 2015 à 14:49
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `symfony`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE IF NOT EXISTS `candidature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Guild_Id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `guild_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `message` longtext COLLATE utf8_unicode_ci NOT NULL,
  `message_titre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `situation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Contenu de la table `candidature`
--

INSERT INTO `candidature` (`id`, `Guild_Id`, `user_id`, `guild_name`, `user_name`, `date`, `message`, `message_titre`, `situation`) VALUES
(1, 4, 1, 'Teste', 'Teros', '2014-11-09 20:28:35', 'izi', 'lol', 'En attente');

-- --------------------------------------------------------

--
-- Structure de la table `guild`
--

CREATE TABLE IF NOT EXISTS `guild` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Guild_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CoGM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GM_id` int(11) NOT NULL,
  `MMO_Principale` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Serveur` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `guild`
--

INSERT INTO `guild` (`id`, `Guild_name`, `GM`, `CoGM`, `GM_id`, `MMO_Principale`, `Serveur`) VALUES
(1, 'NONDELAGUILD', 'NOMDUGM', 'NOMDUCOGM', 1, 'MMOPRINCIPALE', 'SERVEUR'),
(2, 'lolilol', 'Teros', 'encoremoi', 1, 'lol', 'kik'),
(3, 'lolilol', 'Teros', 'encoremoi', 1, 'lol', 'kik'),
(4, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(5, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(6, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(7, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(8, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(9, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(10, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(11, 'Teste', 'Teros', 'encoremoi', 1, 'lol', 'Test'),
(12, 'testaujourd''hui', 'Teros', 'sdf', 1, 'sdf', 'sdf'),
(13, 'testaujourd''hui2', 'Teros', '<zry', 1, 'qdr', 'dfth'),
(14, 'z''-u', 'Teros', '''"eu', 1, 'q-tu', 'qezhy'),
(15, 'z''-u', 'Teros', '''"eu', 1, 'q-tu', 'qezhy');

-- --------------------------------------------------------

--
-- Structure de la table `guildmembres`
--

CREATE TABLE IF NOT EXISTS `guildmembres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Guildid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Contenu de la table `guildmembres`
--

INSERT INTO `guildmembres` (`id`, `Guildid`, `userid`, `username`) VALUES
(2, 1, 1, 'Teros'),
(3, 4, 1, 'Teros'),
(4, 2, 1, 'Teros'),
(14, 12, 1, 'Teros');

-- --------------------------------------------------------

--
-- Structure de la table `guildpost`
--

CREATE TABLE IF NOT EXISTS `guildpost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `GuildId` int(11) NOT NULL,
  `UserId` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `UserName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Date` datetime NOT NULL,
  `Message` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Contenu de la table `guildpost`
--

INSERT INTO `guildpost` (`id`, `GuildId`, `UserId`, `UserName`, `Date`, `Message`) VALUES
(1, 1, '1', 'Teros', '2014-11-09 02:02:36', 'try'),
(2, 1, '1', 'Teros', '2014-11-09 02:05:24', 'yk'),
(3, 1, '1', 'Teros', '2014-11-09 02:06:08', 'essa'),
(4, 1, '1', 'Teros', '2014-11-09 02:08:06', 'lol'),
(5, 1, '1', 'Teros', '2014-11-11 21:03:15', '1'),
(6, 1, '1', 'Teros', '2014-11-11 21:03:20', '2'),
(7, 1, '1', 'Teros', '2014-11-11 21:03:23', '3'),
(8, 1, '1', 'Teros', '2014-12-14 18:15:52', '4');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_env` int(11) NOT NULL,
  `name_env` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_dest` int(11) NOT NULL,
  `name_dest` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `titre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` longtext COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `vue` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id`, `id_env`, `name_env`, `id_dest`, `name_dest`, `titre`, `message`, `date`, `vue`) VALUES
(1, 1, 'Teros', 1, 'Teros', 'lol', 'lol', '2015-01-27 11:48:31', 0),
(2, 1, 'Teros', 1, 'Teros', 'lol', 'lol', '2015-01-27 11:49:50', 0),
(3, 1, 'Teros', 4, 'Teross', 'Blabla', 'lolhahahaha', '2015-01-27 11:51:27', 0),
(4, 1, 'Teros', 1, 'Teros', 'titre', 'message', '2015-01-27 13:26:20', 0),
(5, 1, 'Teros', 4, 'Teross', 'testance', 'lolilol', '2015-02-03 11:58:28', 0),
(6, 1, 'Teros', 1, 'Teros', 'Ceci est un Test', 'Hello boy !', '2015-02-07 13:03:08', 0),
(7, 1, 'Teros', 1, 'Teros', 'Bien ou quoi N?', 'lol', '2015-02-09 10:53:39', 0);

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE IF NOT EXISTS `participant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=14 ;

--
-- Contenu de la table `participant`
--

INSERT INTO `participant` (`id`, `event_id`, `user_id`, `user_name`, `role`) VALUES
(3, 8, 1, 'Teros', 'Heal'),
(11, 6, 1, 'Teros', 'Tank'),
(12, 5, 1, 'Teros', 'DPS'),
(13, 11, 1, 'Teros', 'Tank');

-- --------------------------------------------------------

--
-- Structure de la table `planing`
--

CREATE TABLE IF NOT EXISTS `planing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guild_id` int(11) NOT NULL,
  `auteur_id` int(11) NOT NULL,
  `auteur_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `titre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `infos` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Contenu de la table `planing`
--

INSERT INTO `planing` (`id`, `guild_id`, `auteur_id`, `auteur_name`, `date`, `titre`, `infos`) VALUES
(4, 1, 1, 'Teros', '2014-11-08 11:59:00', 'Rien du tout', 'azerz'),
(5, 1, 1, 'Teros', '2014-11-19 16:29:00', 'test2', 'hfkj'),
(6, 1, 1, 'Teros', '2014-11-07 09:14:00', 'fj', 'ghl'),
(7, 1, 1, 'Teros', '2014-11-10 12:31:00', 'fj', 'yjrtftuif'),
(8, 1, 1, 'Teros', '2014-11-05 22:39:00', 'fgh', 'fgh'),
(9, 1, 1, 'Teros', '2014-11-07 00:07:00', 'sdg', 'sg'),
(10, 1, 1, 'Teros', '2014-11-07 00:08:00', 'qsf', 'qf'),
(11, 4, 1, 'Teros', '2014-11-09 11:56:00', 'Je testa', 'Hello world !!');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) NOT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_1D1C63B392FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_1D1C63B3A0D96FBF` (`email_canonical`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`) VALUES
(1, 'Teros', 'teros', 'aboukhriss.zakaria@hotmail.com', 'aboukhriss.zakaria@hotmail.com', 1, 'eg5dcapmiko4oscg44ksk0440oksk4w', 'u+g0VlRATG6VVEUB/wbCCPAR61xPR1JdsNwBmzWqHx98ofX8qsxgAEAifvG0YSi6wLKqFH/UI+VvUYe0i3+PTQ==', '2015-02-07 13:02:37', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(4, 'Teross', 'teross', 'abboukhriss.zakaria@hotmail.com', 'abboukhriss.zakaria@hotmail.com', 1, 'eg5dcapmiko4oscg44ksk0440oksk4w', 'u+g0VlRATG6VVEUB/wbCCPAR61xPR1JdsNwBmzWqHx98ofX8qsxgAEAifvG0YSi6wLKqFH/UI+VvUYe0i3+PTQ==', '2014-12-25 19:37:52', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(5, '!username!', '', '!email!', '', 0, '', '!password! ', NULL, 0, 0, NULL, NULL, NULL, '', 0, NULL),
(14, 'user', 'usernamedelebrazil', 'emaildoulebrazil', 'emailededoulebrazil', 0, '', 'mdp', NULL, 0, 0, NULL, NULL, NULL, '', 0, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
