-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2016 at 12:36 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proseboard`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_account` int(11) UNSIGNED NOT NULL,
  `solde` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_account`, `solde`) VALUES
(1, 1650),
(2, 0),
(3, 200),
(4, 150),
(5, 300),
(6, 700),
(7, 200),
(8, 0),
(9, 0),
(10, 0),
(11, 0),
(12, 0),
(13, 0),
(14, 9400),
(16, 0),
(17, 0),
(18, 0),
(19, 0),
(20, 0),
(21, 0),
(22, 0),
(23, 22),
(24, 1272),
(25, 1000),
(26, 1000),
(27, 1000),
(28, 0),
(29, 500),
(30, 0),
(31, 0),
(32, 0),
(34, 0);

--
-- Triggers `account`
--
DELIMITER $$
CREATE TRIGGER `historique` BEFORE UPDATE ON `account` FOR EACH ROW BEGIN
	DECLARE temp DATETIME;
    SET temp=current_timestamp;
	INSERT INTO account_history (id_account, solde, date_history)
    VALUES (NEW.id_account, NEW.solde, temp);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `account_history`
--

CREATE TABLE `account_history` (
  `id_history` int(11) UNSIGNED NOT NULL,
  `id_account` int(11) DEFAULT NULL,
  `solde` int(11) DEFAULT NULL,
  `date_history` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_history`
--

INSERT INTO `account_history` (`id_history`, `id_account`, `solde`, `date_history`) VALUES
(20, 24, 1262, '2015-05-23 22:00:00'),
(21, 29, -674, '2015-05-23 22:00:00'),
(22, 24, 1272, '2015-05-24 10:55:42'),
(23, 29, -684, '2015-05-24 10:55:42'),
(24, 29, 500, '2015-05-24 11:08:56');

-- --------------------------------------------------------

--
-- Table structure for table `audit`
--

CREATE TABLE `audit` (
  `id_audit` int(11) UNSIGNED NOT NULL,
  `id_auditor` int(11) UNSIGNED NOT NULL,
  `id_team` int(11) UNSIGNED NOT NULL,
  `date` date NOT NULL,
  `report` text NOT NULL,
  `color1` int(10) UNSIGNED NOT NULL,
  `color2` int(10) UNSIGNED NOT NULL,
  `color3` int(10) UNSIGNED NOT NULL,
  `final_color` int(10) UNSIGNED NOT NULL,
  `comment` text NOT NULL,
  `percent` int(11) NOT NULL,
  `publicate` int(10) NOT NULL DEFAULT '0',
  `note` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audit`
--

INSERT INTO `audit` (`id_audit`, `id_auditor`, `id_team`, `date`, `report`, `color1`, `color2`, `color3`, `final_color`, `comment`, `percent`, `publicate`, `note`) VALUES
(1, 5, 2, '2014-02-01', 'A revoir', 3, 3, 3, 3, 'Nul', 0, 1, 7),
(2, 5, 2, '2014-04-05', 'OK', 2, 2, 2, 2, 'RAS', 0, 1, 12),
(3, 5, 2, '2014-06-01', 'Bien', 1, 1, 1, 1, 'Parfait', 0, 1, 17),
(4, 46, 3, '2014-02-01', 'Moyen', 3, 2, 2, 2, 'RAS', 0, 1, 11),
(5, 46, 3, '2014-04-05', 'OK', 2, 2, 2, 2, 'RAS', 0, 1, 13),
(6, 46, 3, '2014-06-01', 'Bien', 2, 1, 1, 1, 'RAS', 0, 1, 14.5),
(7, 5, 4, '2014-02-01', 'Moyen', 3, 2, 1, 2, 'RAS', 0, 1, 11),
(8, 5, 4, '2014-04-05', 'OK', 2, 1, 2, 2, 'RAS', 0, 1, 14.5),
(9, 5, 4, '2014-06-01', 'Bien', 1, 2, 2, 2, 'RAS', 0, 1, 15),
(10, 46, 6, '2015-02-01', 'OK', 3, 2, 2, 2, 'RAS', 0, 3, 10),
(11, 46, 6, '2015-04-05', 'Bien', 1, 1, 2, 1, 'RAS', 0, 2, 15),
(12, 5, 7, '2015-02-01', 'OK', 2, 2, 2, 2, 'RAS', 0, 3, 13.5),
(13, 5, 7, '2015-04-05', 'Bien', 2, 2, 1, 2, 'Bien!', 0, 3, 14),
(14, 5, 6, '2015-04-27', 'NUL', 3, 3, 3, 3, 'PAS BIEN', 0, 4, 0.3),
(15, 5, 7, '2015-04-27', 'NUL', 3, 3, 3, 3, 'VRAIMENT NUL', 0, 4, 0),
(16, 5, 7, '2015-04-27', 'NUL', 3, 3, 3, 3, 'NUL', 0, 2, 0.5),
(17, 5, 1, '2015-05-07', '', 2, 2, 2, 2, '', 0, 0, 10);

-- --------------------------------------------------------

--
-- Table structure for table `available_user`
--

CREATE TABLE `available_user` (
  `id_user` int(11) UNSIGNED NOT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `available_user`
--

INSERT INTO `available_user` (`id_user`, `date_start`, `date_end`) VALUES
(26, '2015-05-14 08:00:00', '2015-05-14 17:00:00'),
(26, '2015-05-20 08:00:00', '2015-05-20 12:00:00'),
(26, '2015-05-27 14:30:00', '2015-05-27 17:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id_bill` int(10) NOT NULL,
  `id_user_transmitter` int(10) UNSIGNED NOT NULL,
  `id_user_receiver` int(10) UNSIGNED NOT NULL,
  `subject` varchar(50) NOT NULL,
  `amount` float UNSIGNED NOT NULL,
  `comments` varchar(400) NOT NULL,
  `date` date NOT NULL,
  `state` smallint(6) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id_bill`, `id_user_transmitter`, `id_user_receiver`, `subject`, `amount`, `comments`, `date`, `state`) VALUES
(1, 17, 39, 'Capteur TC130', 75, 'Un capteur de qualitÃ©', '2015-05-17', 0),
(5, 45, 30, 'Avancement 2', 100, 'Seconde partie du projet', '2015-05-19', 0),
(6, 45, 30, 'Avancement 2', 200, 'Seconde partie bis', '2015-05-19', 0);

-- --------------------------------------------------------

--
-- Table structure for table `consulting`
--

CREATE TABLE `consulting` (
  `id_consult` int(11) UNSIGNED NOT NULL,
  `id_consultant` int(11) UNSIGNED NOT NULL,
  `id_team` int(11) UNSIGNED NOT NULL,
  `hourCost` float DEFAULT '0',
  `report` text,
  `isCharged` tinyint(1) NOT NULL DEFAULT '0',
  `id_event` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consulting`
--

INSERT INTO `consulting` (`id_consult`, `id_consultant`, `id_team`, `hourCost`, `report`, `isCharged`, `id_event`) VALUES
(2, 23, 1, 100, NULL, 1, 18),
(5, 27, 7, 90, 'Rapport test', 0, 84),
(6, 27, 7, 80, NULL, 0, 85),
(7, 27, 7, 85, NULL, 0, 86),
(8, 26, 7, 80, NULL, 0, 87),
(9, 27, 7, 83, NULL, 0, 89);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id_event` int(10) UNSIGNED NOT NULL,
  `visible` tinyint(4) NOT NULL DEFAULT '1',
  `event_name` varchar(50) DEFAULT NULL,
  `event_description` text,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `validation` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `id_creator` int(11) UNSIGNED NOT NULL,
  `type` enum('consulting','training','audit','default') CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL DEFAULT 'default',
  `id_session` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id_event`, `visible`, `event_name`, `event_description`, `start_date`, `end_date`, `validation`, `id_creator`, `type`, `id_session`) VALUES
(18, 1, 'consulting Tue Apr 28 15:00:00 CEST 2015', 'Consulting UML', '2015-04-28 15:00:00', '2015-04-28 15:30:00', 2, 15, 'consulting', 2),
(19, 1, 'training Wed Apr 29 09:00:00 CEST 2015', 'Cours de Java', '2015-04-29 09:00:00', '2015-04-29 11:00:00', 2, 15, 'training', 2),
(21, 1, 'consulting Wed Apr 29 13:54:00 CEST 2015', 'fdff', '2015-04-29 13:54:00', '2015-04-29 13:59:00', 2, 15, 'consulting', 2),
(22, 1, 'Demo', 'demo', '2015-04-27 14:30:00', '2015-04-27 15:00:00', 0, 39, 'default', NULL),
(23, 1, 'consulting Mon Apr 27 14:42:00 CEST 2015', 'test', '2015-04-27 14:42:00', '2015-04-27 14:50:00', 1, 15, 'consulting', 2),
(26, 1, 'training Wed May 06 00:00:00 CEST 2015', 'UML cours sophie rousseau revoir la MOO urgent ', '2015-05-06 00:00:00', '2015-05-06 00:05:00', 0, 17, 'training', 2),
(27, 1, 'training Wed May 06 18:00:00 CEST 2015', 'Cours de java avec sophie rousseau svp', '2015-05-06 18:00:00', '2015-05-06 18:01:00', 0, 17, 'training', 2),
(28, 1, 'training Wed May 06 18:05:00 CEST 2015', 'Cours d''uml avec sophie rousseau svp ', '2015-05-06 18:05:00', '2015-05-06 18:10:00', 0, 17, 'training', 2),
(51, 1, 'Audit', 'Jean', '2015-05-08 11:00:00', '2015-05-08 11:45:00', 0, 5, 'audit', 2),
(55, 1, 'Consultation', 'Approfondissement', '2015-05-08 17:03:00', '2015-05-08 17:30:00', 2, 45, 'consulting', 2),
(56, 1, 'Session d''entraînement', '', '2015-05-14 17:06:00', '2015-05-14 17:36:00', 2, 45, 'training', 2),
(57, 1, 'Audit', 'Jean', '2015-05-11 17:15:00', '2015-05-11 17:45:00', 0, 5, 'audit', 2),
(58, 1, 'Session d''entraînement', 'Java tests ', '2015-05-13 11:22:00', '2015-05-13 12:22:00', 2, 45, 'training', 2),
(70, 1, 'Audit', 'Jean', '2015-05-11 09:00:00', '2015-05-11 09:45:00', 0, 5, 'audit', 2),
(71, 1, 'Audit', 'Jean', '2015-05-12 08:08:00', '2015-05-12 08:50:00', 0, 5, 'audit', 2),
(72, 1, 'Consultation', 'Aide', '2015-05-14 09:15:00', '2015-05-14 09:45:00', 1, 45, 'consulting', 2),
(75, 1, 'Consultation', 'TEST', '2015-05-21 09:27:00', '2015-05-21 09:57:00', 1, 45, 'consulting', 2),
(80, 1, 'Session d''entraînement', 'TEST', '2015-05-13 09:49:00', '2015-05-13 09:51:00', 2, 45, 'training', 2),
(84, 1, 'Consultation', 'TEST2', '2015-05-12 09:54:00', '2015-05-12 09:59:00', 0, 45, 'consulting', 2),
(85, 1, 'Consultation', 'TEST +++', '2015-05-13 10:27:00', '2015-05-13 11:00:00', 0, 45, 'consulting', 2),
(86, 1, 'Consultation', 'TESTTTTTTT', '2015-05-14 10:31:00', '2015-05-14 10:50:00', 0, 45, 'consulting', 2),
(87, 1, 'Consultation', 'TEST CONSULTING', '2015-05-16 14:00:00', '2015-05-16 15:00:00', 1, 45, 'consulting', 2),
(88, 1, 'Audit', 'Sophie', '2015-05-11 14:29:00', '2015-05-11 15:00:00', 0, 26, 'audit', 2),
(89, 1, 'Consultation', 'GROS TEST', '2015-05-06 15:32:00', '2015-05-06 15:33:00', 1, 45, 'consulting', 2),
(90, 1, 'Session d''entraînement', 'ddddddddddddddd', '2015-05-25 11:00:00', '2015-05-25 12:00:00', 2, 17, 'training', 2),
(91, 1, 'Session d''entraînement', 'fdnfjdnbjdbjdvfbjd', '2015-05-26 11:00:00', '2015-05-26 12:00:00', 2, 17, 'training', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `event_user`
--

CREATE TABLE `event_user` (
  `id_event` int(10) UNSIGNED NOT NULL,
  `id_user` int(10) UNSIGNED NOT NULL,
  `isAbsent` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_user`
--

INSERT INTO `event_user` (`id_event`, `id_user`, `isAbsent`) VALUES
(18, 23, 0),
(18, 16, 0),
(18, 17, 0),
(18, 15, 0),
(19, 23, 0),
(19, 16, 0),
(19, 17, 0),
(19, 15, 0),
(21, 23, 0),
(21, 16, 0),
(21, 17, 0),
(21, 15, 0),
(22, 39, 0),
(23, 23, 0),
(23, 16, 0),
(23, 17, 0),
(23, 15, 0),
(26, 26, 0),
(26, 16, 0),
(26, 17, 0),
(26, 15, 0),
(27, 26, 0),
(27, 16, 0),
(27, 17, 0),
(27, 15, 0),
(28, 26, 0),
(28, 16, 0),
(28, 17, 0),
(28, 15, 0),
(51, 5, 0),
(51, 41, 0),
(51, 43, 0),
(55, 26, 0),
(55, 44, 0),
(55, 45, 0),
(56, 26, 0),
(56, 44, 0),
(56, 45, 0),
(57, 5, 0),
(57, 44, 0),
(57, 45, 0),
(58, 28, 0),
(58, 44, 0),
(58, 45, 0),
(70, 5, 0),
(70, 44, 0),
(70, 45, 0),
(71, 5, 0),
(71, 41, 0),
(71, 43, 0),
(72, 27, 0),
(72, 44, 0),
(72, 45, 0),
(75, 27, 0),
(75, 44, 0),
(75, 45, 0),
(80, 26, 0),
(80, 44, 0),
(80, 45, 0),
(84, 27, 0),
(84, 44, 0),
(84, 45, 0),
(85, 27, 0),
(85, 44, 0),
(85, 45, 0),
(86, 27, 0),
(86, 44, 0),
(86, 45, 0),
(87, 26, 0),
(87, 44, 0),
(87, 45, 0),
(88, 26, 0),
(88, 41, 0),
(88, 43, 0),
(89, 27, 0),
(89, 44, 0),
(89, 45, 0),
(90, 26, 0),
(90, 16, 0),
(90, 17, 0),
(90, 15, 0),
(91, 28, 0),
(91, 16, 0),
(91, 17, 0),
(91, 15, 0);

-- --------------------------------------------------------

--
-- Table structure for table `expertise_area`
--

CREATE TABLE `expertise_area` (
  `id_exp` int(11) UNSIGNED NOT NULL,
  `name_exp` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expertise_area`
--

INSERT INTO `expertise_area` (`id_exp`, `name_exp`) VALUES
(1, 'Java'),
(2, 'UML'),
(5, 'GLE'),
(6, 'SQL'),
(7, 'Web services'),
(8, 'BDD'),
(9, 'Vincent');

-- --------------------------------------------------------

--
-- Table structure for table `expertise_user`
--

CREATE TABLE `expertise_user` (
  `id_user` int(11) UNSIGNED NOT NULL,
  `id_expertise` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expertise_user`
--

INSERT INTO `expertise_user` (`id_user`, `id_expertise`) VALUES
(28, 1),
(29, 2),
(27, 1),
(26, 1),
(27, 5),
(27, 6),
(27, 7),
(27, 8),
(27, 9);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id_message` int(11) UNSIGNED NOT NULL,
  `id_emetter` int(11) UNSIGNED NOT NULL,
  `id_receiver` int(11) UNSIGNED NOT NULL,
  `mail_emetter` varchar(30) NOT NULL,
  `mail_receiver` varchar(30) NOT NULL,
  `date` datetime NOT NULL,
  `contain` text NOT NULL,
  `read` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `trash_emetter` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `trash_receiver` int(11) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id_message`, `id_emetter`, `id_receiver`, `mail_emetter`, `mail_receiver`, `date`, `contain`, `read`, `trash_emetter`, `trash_receiver`) VALUES
(2, 1, 1, 'admin@proseboard.fr', 'admin@proseboard.fr', '2015-04-09 11:03:29', 'Test', 1, 0, 0),
(3, 1, 1, 'admin@proseboard.fr', 'admin@proseboard.fr', '2015-04-09 17:42:52', 'test', 1, 0, 0),
(5, 38, 45, 'prose1@proseboard.fr', 'prose8@proseboard.fr', '2015-04-27 09:18:54', 'COUCOU', 1, 0, 1),
(6, 45, 38, 'prose8@proseboard.fr', 'prose1@proseboard.fr', '2015-04-27 13:53:03', 'COUCOU toi aussi <br>', 1, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id_notification` int(11) UNSIGNED NOT NULL,
  `id_user` int(11) UNSIGNED NOT NULL,
  `id_object` int(11) UNSIGNED DEFAULT NULL,
  `type` enum('consulting_application','audit_application','training_application') COLLATE utf8_general_mysql500_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `saw` tinyint(3) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id_notification`, `id_user`, `id_object`, `type`, `created_at`, `saw`) VALUES
(1, 45, 58, 'training_application', '2015-05-22 05:17:23', 1),
(2, 26, 90, 'training_application', '2015-05-22 05:19:55', 1),
(3, 17, 90, 'training_application', '2015-05-22 05:20:06', 1),
(4, 28, 91, 'training_application', '2015-05-22 05:24:27', 1),
(5, 17, 91, 'training_application', '2015-05-22 05:24:58', 1),
(6, 17, 6, 'training_application', '2015-05-22 05:26:31', 1);

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`id`, `name`) VALUES
(28, 'accept_consultationOrTraining'),
(15, 'book_consultationOrTraining'),
(16, 'charge_team_consulting'),
(17, 'charge_team_training'),
(31, 'compare_audits'),
(3, 'create_audit'),
(20, 'create_consulting_report'),
(7, 'create_session'),
(9, 'create_team'),
(27, 'create_training'),
(41, 'create_training_report'),
(6, 'create_user'),
(11, 'delete_team'),
(22, 'edit_account'),
(4, 'edit_all_audits'),
(10, 'edit_team'),
(21, 'manage_consulting_report'),
(12, 'manage_users'),
(39, 'my_account'),
(30, 'pay_members'),
(18, 'pay_team'),
(34, 'planifier_audit'),
(14, 'publicate_audit'),
(37, 'publish_available'),
(35, 'publish_competences'),
(33, 'publish_training'),
(5, 'see_all_audits'),
(32, 'see_audits_client'),
(19, 'see_my_audits'),
(25, 'see_my_auditsTL'),
(36, 'see_request_team'),
(8, 'see_team_audits'),
(29, 'see_team_infos'),
(26, 'see_team_planning'),
(40, 'see_training'),
(44, 'see_training_report'),
(2, 'send_message_staff'),
(1, 'send_message_student'),
(42, 'template'),
(43, 'timeslot'),
(23, 'validate_consultationOrTraining'),
(38, 'view_absent'),
(13, 'view_account');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `nb_team` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `is_open` tinyint(1) NOT NULL DEFAULT '0',
  `id_template` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`id`, `name`, `nb_team`, `start_date`, `end_date`, `is_open`, `id_template`) VALUES
(1, 'Session 2014', 3, '2014-01-01', '2014-06-01', 0, NULL),
(2, 'Session 2015', 3, '2015-01-01', '2016-06-01', 1, NULL),
(3, 'Session Prose 2016', 0, '2016-03-01', '2016-06-01', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id_status` int(11) UNSIGNED NOT NULL,
  `status_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `status_name`) VALUES
(1, 'admin'),
(2, 'auditor'),
(8, 'client'),
(3, 'consultant'),
(4, 'student'),
(7, 'teacher'),
(5, 'team_leader'),
(6, 'team_member');

-- --------------------------------------------------------

--
-- Table structure for table `status_permission`
--

CREATE TABLE `status_permission` (
  `id_status` int(11) UNSIGNED NOT NULL,
  `id_permission` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_permission`
--

INSERT INTO `status_permission` (`id_status`, `id_permission`) VALUES
(1, 6),
(1, 12),
(2, 3),
(1, 7),
(2, 13),
(5, 15),
(2, 5),
(2, 8),
(2, 14),
(3, 16),
(8, 18),
(7, 17),
(6, 19),
(3, 20),
(3, 21),
(5, 22),
(6, 15),
(6, 15),
(5, 23),
(5, 25),
(5, 26),
(6, 26),
(3, 28),
(7, 28),
(7, 27),
(8, 29),
(5, 30),
(2, 31),
(8, 32),
(7, 33),
(2, 34),
(3, 35),
(7, 35),
(3, 36),
(7, 36),
(3, 37),
(7, 37),
(7, 38),
(5, 39),
(6, 39),
(6, 40),
(7, 41),
(1, 42),
(1, 43),
(7, 44),
(7, 44);

-- --------------------------------------------------------

--
-- Table structure for table `status_user`
--

CREATE TABLE `status_user` (
  `id_user` int(11) UNSIGNED NOT NULL,
  `id_status` int(11) UNSIGNED NOT NULL,
  `id_session` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_user`
--

INSERT INTO `status_user` (`id_user`, `id_status`, `id_session`) VALUES
(1, 1, NULL),
(5, 2, NULL),
(15, 6, 2),
(16, 6, 2),
(17, 5, 2),
(18, 1, NULL),
(23, 3, NULL),
(24, 4, NULL),
(25, 2, NULL),
(26, 3, NULL),
(27, 3, NULL),
(28, 7, NULL),
(29, 3, NULL),
(26, 2, NULL),
(26, 7, NULL),
(26, 1, NULL),
(30, 8, NULL),
(31, 1, NULL),
(31, 7, NULL),
(37, 4, NULL),
(38, 5, 1),
(39, 5, 1),
(40, 6, 1),
(41, 5, 2),
(42, 6, 1),
(43, 6, 2),
(44, 6, 2),
(45, 5, 2),
(46, 2, NULL),
(49, 3, NULL),
(49, 7, NULL),
(38, 6, 1),
(39, 6, 1),
(41, 6, 2),
(41, 5, 1),
(41, 6, 1),
(45, 6, 2),
(45, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id_team` int(11) UNSIGNED NOT NULL,
  `id_team_leader` int(11) UNSIGNED NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `project_name` varchar(50) DEFAULT NULL,
  `id_session` int(11) UNSIGNED NOT NULL,
  `id_account` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `id_client` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`id_team`, `id_team_leader`, `team_name`, `project_name`, `id_session`, `id_account`, `id_client`) VALUES
(1, 17, 'Equipe A', 'Helicoptere', 2, 30, 30),
(2, 38, 'Equipe A', 'Avion', 1, 25, 30),
(3, 39, 'Equipe B', 'Essuie-glaces', 1, 26, 30),
(4, 41, 'Equipe C', 'Phares', 1, 27, 30),
(6, 41, 'Equipe B', 'Robot Nao', 2, 32, 30),
(7, 45, 'Equipe C', 'Suiveur de ligne', 2, 29, 30),
(8, 5, 'Equipe D', 'surprise', 2, 5, 30),
(9, 17, 'Equipe E', 'ahah', 1, 10, 30);

-- --------------------------------------------------------

--
-- Table structure for table `team_user`
--

CREATE TABLE `team_user` (
  `id_user` int(11) UNSIGNED NOT NULL,
  `id_team` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `team_user`
--

INSERT INTO `team_user` (`id_user`, `id_team`) VALUES
(16, 1),
(17, 1),
(15, 1),
(45, 2),
(40, 3),
(42, 4),
(43, 6),
(44, 7),
(38, 2),
(39, 3),
(41, 4),
(41, 6),
(45, 7);

-- --------------------------------------------------------

--
-- Table structure for table `template`
--

CREATE TABLE `template` (
  `template_id` int(10) UNSIGNED NOT NULL,
  `template_name` varchar(50) CHARACTER SET latin1 NOT NULL DEFAULT '0',
  `updated_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

--
-- Dumping data for table `template`
--

INSERT INTO `template` (`template_id`, `template_name`, `updated_at`) VALUES
(1, 'Programme Ramda', '2015-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `template_timeslot`
--

CREATE TABLE `template_timeslot` (
  `template_timeslot_id` int(10) UNSIGNED NOT NULL,
  `timeslot_name` varchar(50) CHARACTER SET latin1 NOT NULL,
  `quantity` tinyint(3) UNSIGNED NOT NULL,
  `template_id` int(10) UNSIGNED NOT NULL,
  `teacher_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Table structure for table `timeslot`
--

CREATE TABLE `timeslot` (
  `id_timeslot` int(10) UNSIGNED NOT NULL,
  `date` date NOT NULL DEFAULT '0000-00-00',
  `start` time DEFAULT '00:00:00',
  `stop` time DEFAULT '00:00:00',
  `id_session` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `id_training` int(11) UNSIGNED NOT NULL,
  `id_event` int(10) UNSIGNED NOT NULL,
  `id_educator` int(11) UNSIGNED NOT NULL,
  `subject` varchar(150) CHARACTER SET utf8 NOT NULL,
  `isCharged` tinyint(1) DEFAULT '0',
  `ressources` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `hourCost` float DEFAULT '0',
  `report` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `training`
--

INSERT INTO `training` (`id_training`, `id_event`, `id_educator`, `subject`, `isCharged`, `ressources`, `hourCost`, `report`) VALUES
(1, 26, 26, 'UML cours sophie rousseau revoir la MOO urgent ', 0, NULL, 98.5, NULL),
(2, 27, 26, 'Cours de java avec sophie rousseau svp', 0, NULL, 72.45, NULL),
(3, 28, 26, 'Cours d''uml avec sophie rousseau svp ', 0, NULL, 67.99, NULL),
(4, 80, 26, 'TEST', 0, NULL, 100, NULL),
(5, 90, 26, 'ddddddddddddddd', 0, NULL, 72.37, NULL),
(6, 91, 28, 'fdnfjdnbjdbjdvfbjd', 0, 'Un poney', 250, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `training_user`
--

CREATE TABLE `training_user` (
  `id_training` int(11) UNSIGNED NOT NULL,
  `id_user` int(11) UNSIGNED NOT NULL,
  `isAbsent` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `training_user`
--

INSERT INTO `training_user` (`id_training`, `id_user`, `isAbsent`) VALUES
(1, 17, 0),
(1, 17, 0),
(1, 17, 0),
(1, 17, 0),
(1, 15, 1),
(2, 15, 1),
(3, 15, 0),
(4, 15, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) UNSIGNED NOT NULL,
  `id_account` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `mail_address` varchar(30) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `id_redmine` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `id_account`, `mail_address`, `password`, `name`, `first_name`, `id_redmine`) VALUES
(1, 1, 'admin@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Melet', 'Maxime', NULL),
(5, 2, 'jean.alesi@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Alesi', 'Jean', NULL),
(15, 3, 'etudiant.un@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Un', 'Etudiant', NULL),
(16, 4, 'etudiant.deux@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Deux', 'Etudiant', NULL),
(17, 5, 'etudiant.trois@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Trois', 'Etudiant', NULL),
(18, 6, 'p.dupont@gggg.com', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Dupont', 'Paul', NULL),
(23, 7, 'martin.dupont@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Dupont', 'Martin', NULL),
(24, 8, 'bob.bob@hotmail.fr', '$2a$08$UgHacu7UWzwdJAkBOaHz0utnCZ7UP47.H2f9MmiHto.mCepfXxUJS', 'bob', '123', NULL),
(25, 9, 'audit@prosebord.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'audit', 'test', NULL),
(26, 10, 'sophie.rousseau@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Rousseau', 'Sophie', NULL),
(27, 11, 'jean.jacques@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Jean', 'Jacques', NULL),
(28, 12, 'jean.jean@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Jean', 'Jean', NULL),
(29, 13, 'paul.paul@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Paul', 'Paul', NULL),
(30, 14, 'client@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Client', 'Client', NULL),
(31, 34, 'essai@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Essai', 'Essai', NULL),
(37, 16, 'test.redmine@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Redmine', 'Test', 31),
(38, 17, 'prose1@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Boisumeau', 'Maxime', 34),
(39, 18, 'prose2@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Berthelot', 'Alexis', 35),
(40, 19, 'prose3@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Croccel', 'Emmanuel', 36),
(41, 20, 'prose4@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Dupoy', 'Simon', 37),
(42, 21, 'prose5@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Hetet', 'Vincent', 38),
(43, 22, 'prose6@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Melet', 'Maxime', 39),
(44, 23, 'prose7@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Mevellec', 'Maxime', 40),
(45, 24, 'prose8@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Fresnais', 'Ghislain', 41),
(46, 28, 'jm@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Alesi', 'Jean-Marc', 42),
(49, 31, 'demo.increment@proseboard.fr', '$2a$08$co7nmDRZeuf3snZGs9XZLe4mlzaUvO2n3JTBARIkWdMbrprlb454W', 'Increment', 'Demo', 46);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`);

--
-- Indexes for table `account_history`
--
ALTER TABLE `account_history`
  ADD PRIMARY KEY (`id_history`);

--
-- Indexes for table `audit`
--
ALTER TABLE `audit`
  ADD PRIMARY KEY (`id_audit`),
  ADD KEY `FK_audit_user` (`id_auditor`),
  ADD KEY `FK_audit_team` (`id_team`);

--
-- Indexes for table `available_user`
--
ALTER TABLE `available_user`
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id_bill`),
  ADD KEY `FK_bill_1` (`id_user_transmitter`),
  ADD KEY `FK_bill_2` (`id_user_receiver`);

--
-- Indexes for table `consulting`
--
ALTER TABLE `consulting`
  ADD PRIMARY KEY (`id_consult`),
  ADD KEY `FK_consulting_user` (`id_consultant`),
  ADD KEY `FK_consulting_team` (`id_team`),
  ADD KEY `id_event` (`id_event`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `id_creator` (`id_creator`),
  ADD KEY `visible` (`visible`),
  ADD KEY `FK_event_session` (`id_session`);

--
-- Indexes for table `event_user`
--
ALTER TABLE `event_user`
  ADD KEY `id_event` (`id_event`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `expertise_area`
--
ALTER TABLE `expertise_area`
  ADD PRIMARY KEY (`id_exp`);

--
-- Indexes for table `expertise_user`
--
ALTER TABLE `expertise_user`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_expertise` (`id_expertise`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `FK_message_user` (`id_emetter`),
  ADD KEY `FK_message_user_2` (`id_receiver`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id_notification`),
  ADD KEY `FK_notification_user` (`id_user`),
  ADD KEY `type` (`type`),
  ADD KEY `saw` (`saw`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_session_template` (`id_template`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`),
  ADD KEY `status_name` (`status_name`);

--
-- Indexes for table `status_permission`
--
ALTER TABLE `status_permission`
  ADD KEY `FK_status_permission_status` (`id_status`),
  ADD KEY `FK_status_permission_permission` (`id_permission`);

--
-- Indexes for table `status_user`
--
ALTER TABLE `status_user`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_status` (`id_status`),
  ADD KEY `FK_status_user_session` (`id_session`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id_team`),
  ADD KEY `FK_team_user` (`id_team_leader`),
  ADD KEY `FK_team_session` (`id_session`),
  ADD KEY `FK_team_user_2` (`id_client`),
  ADD KEY `FK_team_account` (`id_account`);

--
-- Indexes for table `team_user`
--
ALTER TABLE `team_user`
  ADD KEY `FK_team_user_user` (`id_user`),
  ADD KEY `FK_team_user_team` (`id_team`);

--
-- Indexes for table `template`
--
ALTER TABLE `template`
  ADD PRIMARY KEY (`template_id`);

--
-- Indexes for table `template_timeslot`
--
ALTER TABLE `template_timeslot`
  ADD PRIMARY KEY (`template_timeslot_id`),
  ADD KEY `FK_template_timeslot_template` (`template_id`),
  ADD KEY `FK_template_timeslot_user` (`teacher_id`);

--
-- Indexes for table `timeslot`
--
ALTER TABLE `timeslot`
  ADD PRIMARY KEY (`id_timeslot`),
  ADD KEY `FK_timeslot_session` (`id_session`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`id_training`),
  ADD KEY `FK_training_user` (`id_educator`),
  ADD KEY `id_event` (`id_event`);

--
-- Indexes for table `training_user`
--
ALTER TABLE `training_user`
  ADD KEY `FK_training_user_training` (`id_training`),
  ADD KEY `FK_training_user_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `mail_address` (`mail_address`),
  ADD KEY `FK_user_account` (`id_account`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `account_history`
--
ALTER TABLE `account_history`
  MODIFY `id_history` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `audit`
--
ALTER TABLE `audit`
  MODIFY `id_audit` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id_bill` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `consulting`
--
ALTER TABLE `consulting`
  MODIFY `id_consult` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id_event` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;
--
-- AUTO_INCREMENT for table `expertise_area`
--
ALTER TABLE `expertise_area`
  MODIFY `id_exp` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id_message` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id_notification` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id_team` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `template`
--
ALTER TABLE `template`
  MODIFY `template_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `template_timeslot`
--
ALTER TABLE `template_timeslot`
  MODIFY `template_timeslot_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `timeslot`
--
ALTER TABLE `timeslot`
  MODIFY `id_timeslot` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `id_training` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `audit`
--
ALTER TABLE `audit`
  ADD CONSTRAINT `FK_audit_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id_team`),
  ADD CONSTRAINT `FK_audit_user` FOREIGN KEY (`id_auditor`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `available_user`
--
ALTER TABLE `available_user`
  ADD CONSTRAINT `available_user_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FK_bill_1` FOREIGN KEY (`id_user_transmitter`) REFERENCES `user` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_bill_2` FOREIGN KEY (`id_user_receiver`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `consulting`
--
ALTER TABLE `consulting`
  ADD CONSTRAINT `FK_consulting_event` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`),
  ADD CONSTRAINT `FK_consulting_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id_team`),
  ADD CONSTRAINT `FK_consulting_user` FOREIGN KEY (`id_consultant`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_event_creator` FOREIGN KEY (`id_creator`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_event_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`);

--
-- Constraints for table `event_user`
--
ALTER TABLE `event_user`
  ADD CONSTRAINT `FK_event_user_event` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`),
  ADD CONSTRAINT `FK_event_user_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `expertise_user`
--
ALTER TABLE `expertise_user`
  ADD CONSTRAINT `FK_expertise_user_expertise` FOREIGN KEY (`id_expertise`) REFERENCES `expertise_area` (`id_exp`),
  ADD CONSTRAINT `FK_expertise_user_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_message_user` FOREIGN KEY (`id_emetter`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_message_user_2` FOREIGN KEY (`id_receiver`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FK_notification_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `FK_session_template` FOREIGN KEY (`id_template`) REFERENCES `template` (`template_id`);

--
-- Constraints for table `status_permission`
--
ALTER TABLE `status_permission`
  ADD CONSTRAINT `FK_status_permission_permission` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `FK_status_permission_status` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`);

--
-- Constraints for table `status_user`
--
ALTER TABLE `status_user`
  ADD CONSTRAINT `FK_status_user_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`),
  ADD CONSTRAINT `FK_status_user_status` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  ADD CONSTRAINT `FK_status_user_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `FK_team_account` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`),
  ADD CONSTRAINT `FK_team_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`),
  ADD CONSTRAINT `FK_team_user` FOREIGN KEY (`id_team_leader`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FK_team_user_2` FOREIGN KEY (`id_client`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `team_user`
--
ALTER TABLE `team_user`
  ADD CONSTRAINT `FK_team_user_team` FOREIGN KEY (`id_team`) REFERENCES `team` (`id_team`),
  ADD CONSTRAINT `FK_team_user_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `template_timeslot`
--
ALTER TABLE `template_timeslot`
  ADD CONSTRAINT `FK_template_timeslot_template` FOREIGN KEY (`template_id`) REFERENCES `template` (`template_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_template_timeslot_user` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `timeslot`
--
ALTER TABLE `timeslot`
  ADD CONSTRAINT `FK_timeslot_session` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`);

--
-- Constraints for table `training`
--
ALTER TABLE `training`
  ADD CONSTRAINT `FK_event_training` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`),
  ADD CONSTRAINT `FK_training_user` FOREIGN KEY (`id_educator`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `training_user`
--
ALTER TABLE `training_user`
  ADD CONSTRAINT `FK_training_user_training` FOREIGN KEY (`id_training`) REFERENCES `training` (`id_training`),
  ADD CONSTRAINT `FK_training_user_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_user_account` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
