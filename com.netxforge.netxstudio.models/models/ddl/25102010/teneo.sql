CREATE DATABASE  IF NOT EXISTS `netxstudio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `netxstudio`;
-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: netxstudio
-- ------------------------------------------------------
-- Server version	5.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `function_tolerancerefs`
--

DROP TABLE IF EXISTS `function_tolerancerefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_tolerancerefs` (
  `function_e_id` bigint(20) NOT NULL,
  `tolerance_e_id` bigint(20) NOT NULL,
  `function_tolerancerefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_tolerancerefs_idx`),
  KEY `function_tolerancerefs` (`tolerance_e_id`),
  KEY `FK3681A7A6D08B1F34` (`function_e_id`),
  CONSTRAINT `FK3681A7A6D08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_tolerancerefs` FOREIGN KEY (`tolerance_e_id`) REFERENCES `tolerance` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function`
--

DROP TABLE IF EXISTS `function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `company_bodyref_e_id` bigint(20) default NULL,
  `functiondescription` longtext,
  `functionname` varchar(100) default NULL,
  `library_functions_e_id` bigint(20) default NULL,
  `library_functions_idx` int(11) default NULL,
  `function_functions_e_id` bigint(20) default NULL,
  `function_functions_idx` int(11) default NULL,
  `node_functions_e_id` bigint(20) default NULL,
  `node_functions_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `function_functions` (`function_functions_e_id`),
  KEY `library_functions` (`library_functions_e_id`),
  KEY `node_functions` (`node_functions_e_id`),
  KEY `function_bodyref` (`company_bodyref_e_id`),
  CONSTRAINT `function_bodyref` FOREIGN KEY (`company_bodyref_e_id`) REFERENCES `company` (`e_id`),
  CONSTRAINT `function_functions` FOREIGN KEY (`function_functions_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `library_functions` FOREIGN KEY (`library_functions_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `node_functions` FOREIGN KEY (`node_functions_e_id`) REFERENCES `node` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_protocolrefs`
--

DROP TABLE IF EXISTS `function_protocolrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_protocolrefs` (
  `function_e_id` bigint(20) NOT NULL,
  `protocol_e_id` bigint(20) NOT NULL,
  `function_protocolrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_protocolrefs_idx`),
  KEY `function_protocolrefs` (`protocol_e_id`),
  KEY `FKE70BD1DFD08B1F34` (`function_e_id`),
  CONSTRAINT `FKE70BD1DFD08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_protocolrefs` FOREIGN KEY (`protocol_e_id`) REFERENCES `protocol` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `expression_expressionlines`
--

DROP TABLE IF EXISTS `expression_expressionlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expression_expressionlines` (
  `expression_expressionlines_e_id` bigint(20) NOT NULL,
  `elt` varchar(255) default NULL,
  `expression_expressionlines_idx` int(11) NOT NULL,
  PRIMARY KEY  (`expression_expressionlines_e_id`,`expression_expressionlines_idx`),
  KEY `FK368853C0998D870C` (`expression_expressionlines_e_id`),
  CONSTRAINT `FK368853C0998D870C` FOREIGN KEY (`expression_expressionlines_e_id`) REFERENCES `expression` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_equipmentexpressionrefs`
--

DROP TABLE IF EXISTS `equipment_equipmentexpressionrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_equipmentexpressionrefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `expression_e_id` bigint(20) NOT NULL,
  `equipment_equipmentexpressionrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_equipmentexpressionrefs_idx`),
  KEY `FK4685963535537CB4` (`equipment_e_id`),
  KEY `equipment_equipmentexpressionrefs` (`expression_e_id`),
  CONSTRAINT `equipment_equipmentexpressionrefs` FOREIGN KEY (`expression_e_id`) REFERENCES `expression` (`e_id`),
  CONSTRAINT `FK4685963535537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `metric`
--

DROP TABLE IF EXISTS `metric`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `description` longtext,
  `measurementkind` varchar(255) default NULL,
  `measurementpoint` longtext,
  `metriccalculation` longtext,
  `metricSource` bigint(20) default NULL,
  `name` varchar(100) default NULL,
  `unit_unitref_e_id` bigint(20) default NULL,
  `library_metrics_e_id` bigint(20) default NULL,
  `library_metrics_idx` int(11) default NULL,
  `metric_metrics_e_id` bigint(20) default NULL,
  `metric_metrics_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_metrics` (`library_metrics_e_id`),
  KEY `metric_unitref` (`unit_unitref_e_id`),
  KEY `metric_metrics` (`metric_metrics_e_id`),
  KEY `metric_metricsource` (`metricSource`),
  CONSTRAINT `library_metrics` FOREIGN KEY (`library_metrics_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `metric_metrics` FOREIGN KEY (`metric_metrics_e_id`) REFERENCES `metric` (`e_id`),
  CONSTRAINT `metric_metricsource` FOREIGN KEY (`metricSource`) REFERENCES `metricsource` (`e_id`),
  CONSTRAINT `metric_unitref` FOREIGN KEY (`unit_unitref_e_id`) REFERENCES `unit` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=299 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `area` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `country_countryref_e_id` bigint(20) default NULL,
  `housenumber` varchar(255) default NULL,
  `latitude` varchar(255) default NULL,
  `longitude` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `postalcode` varchar(255) default NULL,
  `region` varchar(255) default NULL,
  `sreet` varchar(255) default NULL,
  `library_sites_e_id` bigint(20) default NULL,
  `library_sites_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `site_countryref` (`country_countryref_e_id`),
  KEY `library_sites` (`library_sites_e_id`),
  CONSTRAINT `library_sites` FOREIGN KEY (`library_sites_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `site_countryref` FOREIGN KEY (`country_countryref_e_id`) REFERENCES `country` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `description` longtext,
  `name` varchar(100) default NULL,
  `version` double default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `meta`
--

DROP TABLE IF EXISTS `meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meta` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `user_author_e_id` bigint(20) default NULL,
  `description` longtext,
  `version` varchar(255) default NULL,
  `library_versions_e_id` bigint(20) default NULL,
  `library_versions_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_versions` (`library_versions_e_id`),
  KEY `meta_author` (`user_author_e_id`),
  CONSTRAINT `library_versions` FOREIGN KEY (`library_versions_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `meta_author` FOREIGN KEY (`user_author_e_id`) REFERENCES `user` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `protocol_functionrefs`
--

DROP TABLE IF EXISTS `protocol_functionrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protocol_functionrefs` (
  `protocol_e_id` bigint(20) NOT NULL,
  `function_e_id` bigint(20) NOT NULL,
  `protocol_functionrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`protocol_e_id`,`protocol_functionrefs_idx`),
  KEY `FKD2D2745FF30DD734` (`protocol_e_id`),
  KEY `protocol_functionrefs` (`function_e_id`),
  CONSTRAINT `FKD2D2745FF30DD734` FOREIGN KEY (`protocol_e_id`) REFERENCES `protocol` (`e_id`),
  CONSTRAINT `protocol_functionrefs` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `expression_equipmentrefs`
--

DROP TABLE IF EXISTS `expression_equipmentrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expression_equipmentrefs` (
  `expression_e_id` bigint(20) NOT NULL,
  `equipment_e_id` bigint(20) NOT NULL,
  `expression_equipmentrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`expression_e_id`,`expression_equipmentrefs_idx`),
  KEY `expression_equipmentrefs` (`equipment_e_id`),
  KEY `FK879CC3678807CF34` (`expression_e_id`),
  CONSTRAINT `expression_equipmentrefs` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `FK879CC3678807CF34` FOREIGN KEY (`expression_e_id`) REFERENCES `expression` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_parameterrefs`
--

DROP TABLE IF EXISTS `function_parameterrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_parameterrefs` (
  `function_e_id` bigint(20) NOT NULL,
  `parameter_e_id` bigint(20) NOT NULL,
  `function_parameterrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_parameterrefs_idx`),
  KEY `function_parameterrefs` (`parameter_e_id`),
  KEY `FKB8A9BD42D08B1F34` (`function_e_id`),
  CONSTRAINT `FKB8A9BD42D08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_parameterrefs` FOREIGN KEY (`parameter_e_id`) REFERENCES `parameter` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `protocol`
--

DROP TABLE IF EXISTS `protocol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protocol` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `company_bodyref_e_id` bigint(20) default NULL,
  `description` longtext,
  `name` varchar(100) default NULL,
  `osi` int(11) default NULL,
  `specification` varchar(255) default NULL,
  `library_protocols_e_id` bigint(20) default NULL,
  `library_protocols_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `protocol_bodyref` (`company_bodyref_e_id`),
  KEY `library_protocols` (`library_protocols_e_id`),
  CONSTRAINT `library_protocols` FOREIGN KEY (`library_protocols_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `protocol_bodyref` FOREIGN KEY (`company_bodyref_e_id`) REFERENCES `company` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ciid`
--

DROP TABLE IF EXISTS `ciid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciid` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `commonciid` varchar(100) default NULL,
  `localciid` varchar(100) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `code` varchar(2) default NULL,
  `description` longtext,
  `name` varchar(100) default NULL,
  `library_units_e_id` bigint(20) default NULL,
  `library_units_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_units` (`library_units_e_id`),
  CONSTRAINT `library_units` FOREIGN KEY (`library_units_e_id`) REFERENCES `library` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicedescription`
--

DROP TABLE IF EXISTS `servicedescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicedescription` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `servicedescriptioncommon` longtext,
  `servicedescriptionnational` longtext,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicecontract`
--

DROP TABLE IF EXISTS `servicecontract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicecontract` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `ola` varchar(255) default NULL,
  `sla` varchar(255) default NULL,
  `uc` varchar(255) default NULL,
  `wla` varchar(255) default NULL,
  `service_servicecontracts_e_id` bigint(20) default NULL,
  `service_servicecontracts_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `service_servicecontracts` (`service_servicecontracts_e_id`),
  CONSTRAINT `service_servicecontracts` FOREIGN KEY (`service_servicecontracts_e_id`) REFERENCES `service` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `network`
--

DROP TABLE IF EXISTS `network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `user_createdbyref_e_id` bigint(20) default NULL,
  `createddate` datetime default NULL,
  `description` longtext,
  `enddate` datetime default NULL,
  `name` varchar(100) default NULL,
  `network_parentref_e_id` bigint(20) default NULL,
  `network_phasenetworkref_e_id` bigint(20) default NULL,
  `startdate` datetime default NULL,
  `template` bit(1) default NULL,
  `library_networks_e_id` bigint(20) default NULL,
  `library_networks_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_networks` (`library_networks_e_id`),
  KEY `network_phasenetworkref` (`network_phasenetworkref_e_id`),
  KEY `network_parentref` (`network_parentref_e_id`),
  KEY `network_createdbyref` (`user_createdbyref_e_id`),
  CONSTRAINT `library_networks` FOREIGN KEY (`library_networks_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `network_createdbyref` FOREIGN KEY (`user_createdbyref_e_id`) REFERENCES `user` (`e_id`),
  CONSTRAINT `network_parentref` FOREIGN KEY (`network_parentref_e_id`) REFERENCES `network` (`e_id`),
  CONSTRAINT `network_phasenetworkref` FOREIGN KEY (`network_phasenetworkref_e_id`) REFERENCES `network` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `servicename_servicename_e_id` bigint(20) default NULL,
  `servicedescription_servicedescription_e_id` bigint(20) default NULL,
  `servicesecuritymgt_servicesecuritymgt_e_id` bigint(20) default NULL,
  `serviceincidentmgt_serviceincidentmgt_e_id` bigint(20) default NULL,
  `ciid_ciid_e_id` bigint(20) default NULL,
  `serviceinterrest_serviceinterrest_e_id` bigint(20) default NULL,
  `servicesupport_servicesupport_e_id` bigint(20) default NULL,
  `serviceadditional_servicemisc_e_id` bigint(20) default NULL,
  `mosttopservice` bit(1) default NULL,
  `servicecategory` varchar(100) default NULL,
  `servicecharactercommon` bit(1) default NULL,
  `serviceclass` varchar(255) default NULL,
  `servicekind` varchar(255) default NULL,
  `servicesupport1` datetime default NULL,
  `ssdomain` varchar(100) default NULL,
  `provider` varchar(255) default NULL,
  `scenario` varchar(255) default NULL,
  `serviceprofile_serviceprofile_e_id` bigint(20) default NULL,
  `functionalcategory` varchar(255) default NULL,
  `location` varchar(255) default NULL,
  `library_services_e_id` bigint(20) default NULL,
  `library_services_idx` int(11) default NULL,
  `service_services_e_id` bigint(20) default NULL,
  `service_services_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_services` (`library_services_e_id`),
  KEY `service_servicemisc` (`serviceadditional_servicemisc_e_id`),
  KEY `service_servicesupport` (`servicesupport_servicesupport_e_id`),
  KEY `service_ciid` (`ciid_ciid_e_id`),
  KEY `rfsservice_serviceprofile` (`serviceprofile_serviceprofile_e_id`),
  KEY `service_servicedescription` (`servicedescription_servicedescription_e_id`),
  KEY `service_servicename` (`servicename_servicename_e_id`),
  KEY `service_services` (`service_services_e_id`),
  KEY `service_serviceincidentmgt` (`serviceincidentmgt_serviceincidentmgt_e_id`),
  KEY `service_servicesecuritymgt` (`servicesecuritymgt_servicesecuritymgt_e_id`),
  KEY `service_serviceinterrest` (`serviceinterrest_serviceinterrest_e_id`),
  CONSTRAINT `library_services` FOREIGN KEY (`library_services_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `rfsservice_serviceprofile` FOREIGN KEY (`serviceprofile_serviceprofile_e_id`) REFERENCES `serviceprofile` (`e_id`),
  CONSTRAINT `service_ciid` FOREIGN KEY (`ciid_ciid_e_id`) REFERENCES `ciid` (`e_id`),
  CONSTRAINT `service_servicedescription` FOREIGN KEY (`servicedescription_servicedescription_e_id`) REFERENCES `servicedescription` (`e_id`),
  CONSTRAINT `service_serviceincidentmgt` FOREIGN KEY (`serviceincidentmgt_serviceincidentmgt_e_id`) REFERENCES `serviceincidentmgt` (`e_id`),
  CONSTRAINT `service_serviceinterrest` FOREIGN KEY (`serviceinterrest_serviceinterrest_e_id`) REFERENCES `serviceinterrest` (`e_id`),
  CONSTRAINT `service_servicemisc` FOREIGN KEY (`serviceadditional_servicemisc_e_id`) REFERENCES `serviceadditional` (`e_id`),
  CONSTRAINT `service_servicename` FOREIGN KEY (`servicename_servicename_e_id`) REFERENCES `servicename` (`e_id`),
  CONSTRAINT `service_services` FOREIGN KEY (`service_services_e_id`) REFERENCES `service` (`e_id`),
  CONSTRAINT `service_servicesecuritymgt` FOREIGN KEY (`servicesecuritymgt_servicesecuritymgt_e_id`) REFERENCES `servicesecuritymgt` (`e_id`),
  CONSTRAINT `service_servicesupport` FOREIGN KEY (`servicesupport_servicesupport_e_id`) REFERENCES `servicesupport` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_tolerancerefs`
--

DROP TABLE IF EXISTS `equipment_tolerancerefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_tolerancerefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `tolerance_e_id` bigint(20) NOT NULL,
  `equipment_tolerancerefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_tolerancerefs_idx`),
  KEY `equipment_tolerancerefs` (`tolerance_e_id`),
  KEY `FKC63DE2DC35537CB4` (`equipment_e_id`),
  CONSTRAINT `equipment_tolerancerefs` FOREIGN KEY (`tolerance_e_id`) REFERENCES `tolerance` (`e_id`),
  CONSTRAINT `FKC63DE2DC35537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `description` longtext,
  `equipmentcode` varchar(100) default NULL,
  `equipmentname` varchar(100) default NULL,
  `company_manufacturerref_e_id` bigint(20) default NULL,
  `position` varchar(100) default NULL,
  `redundancy` varchar(255) default NULL,
  `library_equipments_e_id` bigint(20) default NULL,
  `library_equipments_idx` int(11) default NULL,
  `equipment_equipments_e_id` bigint(20) default NULL,
  `equipment_equipments_idx` int(11) default NULL,
  `node_equipments_e_id` bigint(20) default NULL,
  `node_equipments_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `node_equipments` (`node_equipments_e_id`),
  KEY `library_equipments` (`library_equipments_e_id`),
  KEY `equipment_equipments` (`equipment_equipments_e_id`),
  KEY `equipment_manufacturerref` (`company_manufacturerref_e_id`),
  CONSTRAINT `equipment_equipments` FOREIGN KEY (`equipment_equipments_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `equipment_manufacturerref` FOREIGN KEY (`company_manufacturerref_e_id`) REFERENCES `company` (`e_id`),
  CONSTRAINT `library_equipments` FOREIGN KEY (`library_equipments_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `node_equipments` FOREIGN KEY (`node_equipments_e_id`) REFERENCES `node` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2466 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `productinfo`
--

DROP TABLE IF EXISTS `productinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productinfo` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `availabledate` datetime default NULL,
  `endofsalesdate` datetime default NULL,
  `endofsupportdate` datetime default NULL,
  `productcode` varchar(100) default NULL,
  `salescode` varchar(100) default NULL,
  `underdevelopmentdate` datetime default NULL,
  `equipment_products_e_id` bigint(20) default NULL,
  `equipment_products_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `equipment_products` (`equipment_products_e_id`),
  CONSTRAINT `equipment_products` FOREIGN KEY (`equipment_products_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_protocolrefs`
--

DROP TABLE IF EXISTS `equipment_protocolrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_protocolrefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `protocol_e_id` bigint(20) NOT NULL,
  `equipment_protocolrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_protocolrefs_idx`),
  KEY `equipment_protocolrefs` (`protocol_e_id`),
  KEY `FKB1E057E935537CB4` (`equipment_e_id`),
  CONSTRAINT `equipment_protocolrefs` FOREIGN KEY (`protocol_e_id`) REFERENCES `protocol` (`e_id`),
  CONSTRAINT `FKB1E057E935537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_functionexpressionrefs`
--

DROP TABLE IF EXISTS `function_functionexpressionrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_functionexpressionrefs` (
  `function_e_id` bigint(20) NOT NULL,
  `expression_e_id` bigint(20) NOT NULL,
  `function_functionexpressionrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_functionexpressionrefs_idx`),
  KEY `FK111952F7D08B1F34` (`function_e_id`),
  KEY `function_functionexpressionrefs` (`expression_e_id`),
  CONSTRAINT `FK111952F7D08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_functionexpressionrefs` FOREIGN KEY (`expression_e_id`) REFERENCES `expression` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_equipmentmetricrefs`
--

DROP TABLE IF EXISTS `equipment_equipmentmetricrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_equipmentmetricrefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `metric_e_id` bigint(20) NOT NULL,
  `equipment_equipmentmetricrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_equipmentmetricrefs_idx`),
  KEY `equipment_equipmentmetricrefs` (`metric_e_id`),
  KEY `FKEDFBE3CD35537CB4` (`equipment_e_id`),
  CONSTRAINT `equipment_equipmentmetricrefs` FOREIGN KEY (`metric_e_id`) REFERENCES `metric` (`e_id`),
  CONSTRAINT `FKEDFBE3CD35537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicesecuritymgt`
--

DROP TABLE IF EXISTS `servicesecuritymgt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicesecuritymgt` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `drplancontact` varchar(255) default NULL,
  `drplanrepository` varchar(255) default NULL,
  `drrecoveryplan` bit(1) default NULL,
  `securityrating` varchar(255) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tolerance`
--

DROP TABLE IF EXISTS `tolerance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tolerance` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `erroraction` varchar(255) default NULL,
  `expression` longtext,
  `name` varchar(100) default NULL,
  `library_tolerances_e_id` bigint(20) default NULL,
  `library_tolerances_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_tolerances` (`library_tolerances_e_id`),
  CONSTRAINT `library_tolerances` FOREIGN KEY (`library_tolerances_e_id`) REFERENCES `library` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `rssurl` varchar(255) default NULL,
  `shortname` varchar(100) default NULL,
  `symbol` varchar(100) default NULL,
  `website` varchar(255) default NULL,
  `library_companies_e_id` bigint(20) default NULL,
  `library_companies_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_companies` (`library_companies_e_id`),
  CONSTRAINT `library_companies` FOREIGN KEY (`library_companies_e_id`) REFERENCES `library` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `constructiondate` datetime default NULL,
  `user_createdbyref_e_id` bigint(20) default NULL,
  `inservicedate` datetime default NULL,
  `nodeid` varchar(100) default NULL,
  `equipment_originalequipmentref_e_id` bigint(20) default NULL,
  `function_originalfunctionref_e_id` bigint(20) default NULL,
  `outofservicedate` datetime default NULL,
  `planneddate` datetime default NULL,
  `room_roomref_e_id` bigint(20) default NULL,
  `network_nodes_e_id` bigint(20) default NULL,
  `network_nodes_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `node_originalfunctionref` (`function_originalfunctionref_e_id`),
  KEY `node_originalequipmentref` (`equipment_originalequipmentref_e_id`),
  KEY `network_nodes` (`network_nodes_e_id`),
  KEY `node_roomref` (`room_roomref_e_id`),
  KEY `node_createdbyref` (`user_createdbyref_e_id`),
  CONSTRAINT `network_nodes` FOREIGN KEY (`network_nodes_e_id`) REFERENCES `network` (`e_id`),
  CONSTRAINT `node_createdbyref` FOREIGN KEY (`user_createdbyref_e_id`) REFERENCES `user` (`e_id`),
  CONSTRAINT `node_originalequipmentref` FOREIGN KEY (`equipment_originalequipmentref_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `node_originalfunctionref` FOREIGN KEY (`function_originalfunctionref_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `node_roomref` FOREIGN KEY (`room_roomref_e_id`) REFERENCES `room` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `metricsource`
--

DROP TABLE IF EXISTS `metricsource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metricsource` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `lastcontact` datetime default NULL,
  `lastpurge` datetime default NULL,
  `mappingfile` varchar(255) default NULL,
  `metrickind` varchar(255) default NULL,
  `metriclocation` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `library_metricsources_e_id` bigint(20) default NULL,
  `library_metricsources_idx` int(11) default NULL,
  `metriclibrary_metricsources_e_id` bigint(20) default NULL,
  `metriclibrary_metricsources_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `metriclibrary_metricsources` (`metriclibrary_metricsources_e_id`),
  KEY `library_metricsources` (`library_metricsources_e_id`),
  CONSTRAINT `library_metricsources` FOREIGN KEY (`library_metricsources_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `metriclibrary_metricsources` FOREIGN KEY (`metriclibrary_metricsources_e_id`) REFERENCES `metriclibrary` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `multiimage`
--

DROP TABLE IF EXISTS `multiimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multiimage` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `obj16` varchar(255) default NULL,
  `obj32` varchar(255) default NULL,
  `obj48` varchar(255) default NULL,
  `obj96` varchar(255) default NULL,
  `obj128` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relationship` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `abstract` bit(1) default NULL,
  `maxconnections` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `node_nodeid1ref_e_id` bigint(20) default NULL,
  `node_nodeid2ref_e_id` bigint(20) default NULL,
  `payload` varchar(255) default NULL,
  `protocol_protocolref_e_id` bigint(20) default NULL,
  `requireconnection` bit(1) default NULL,
  `equipment_equipment1ref_e_id` bigint(20) default NULL,
  `equipment_equipment2ref_e_id` bigint(20) default NULL,
  `function_function1ref_e_id` bigint(20) default NULL,
  `function_function2ref_e_id` bigint(20) default NULL,
  `network_functionrelationships_e_id` bigint(20) default NULL,
  `network_functionrelationships_idx` int(11) default NULL,
  `network_equipmentrelationships_e_id` bigint(20) default NULL,
  `network_equipmentrelationships_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `relationship_protocolref` (`protocol_protocolref_e_id`),
  KEY `relationship_nodeid2ref` (`node_nodeid2ref_e_id`),
  KEY `network_equipmentrelationships` (`network_equipmentrelationships_e_id`),
  KEY `relationship_nodeid1ref` (`node_nodeid1ref_e_id`),
  KEY `equipmentrelationship_equipment2ref` (`equipment_equipment2ref_e_id`),
  KEY `equipmentrelationship_equipment1ref` (`equipment_equipment1ref_e_id`),
  KEY `functionrelationship_function2ref` (`function_function2ref_e_id`),
  KEY `network_functionrelationships` (`network_functionrelationships_e_id`),
  KEY `functionrelationship_function1ref` (`function_function1ref_e_id`),
  CONSTRAINT `equipmentrelationship_equipment1ref` FOREIGN KEY (`equipment_equipment1ref_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `equipmentrelationship_equipment2ref` FOREIGN KEY (`equipment_equipment2ref_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `functionrelationship_function1ref` FOREIGN KEY (`function_function1ref_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `functionrelationship_function2ref` FOREIGN KEY (`function_function2ref_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `network_equipmentrelationships` FOREIGN KEY (`network_equipmentrelationships_e_id`) REFERENCES `network` (`e_id`),
  CONSTRAINT `network_functionrelationships` FOREIGN KEY (`network_functionrelationships_e_id`) REFERENCES `network` (`e_id`),
  CONSTRAINT `relationship_nodeid1ref` FOREIGN KEY (`node_nodeid1ref_e_id`) REFERENCES `node` (`e_id`),
  CONSTRAINT `relationship_nodeid2ref` FOREIGN KEY (`node_nodeid2ref_e_id`) REFERENCES `node` (`e_id`),
  CONSTRAINT `relationship_protocolref` FOREIGN KEY (`protocol_protocolref_e_id`) REFERENCES `protocol` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1953 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rfsservice_elements`
--

DROP TABLE IF EXISTS `rfsservice_elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rfsservice_elements` (
  `rfsservice_e_id` bigint(20) NOT NULL,
  `elements_type` varchar(255) default NULL,
  `elements_id` bigint(20) default NULL,
  `rfsservice_elements_idx` int(11) NOT NULL,
  PRIMARY KEY  (`rfsservice_e_id`,`rfsservice_elements_idx`),
  KEY `rfsservice_elements` (`rfsservice_e_id`),
  CONSTRAINT `rfsservice_elements` FOREIGN KEY (`rfsservice_e_id`) REFERENCES `service` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_parameterrefs`
--

DROP TABLE IF EXISTS `equipment_parameterrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_parameterrefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `parameter_e_id` bigint(20) NOT NULL,
  `equipment_parameterrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_parameterrefs_idx`),
  KEY `equipment_parameterrefs` (`parameter_e_id`),
  KEY `FK4865F87835537CB4` (`equipment_e_id`),
  CONSTRAINT `equipment_parameterrefs` FOREIGN KEY (`parameter_e_id`) REFERENCES `parameter` (`e_id`),
  CONSTRAINT `FK4865F87835537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serviceprofile`
--

DROP TABLE IF EXISTS `serviceprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceprofile` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `netxresource_values`
--

DROP TABLE IF EXISTS `netxresource_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netxresource_values` (
  `id` bigint(20) NOT NULL auto_increment,
  `e_version` int(11) NOT NULL,
  `fme_feature` varchar(255) default NULL,
  `values_value_metricvalues_e_id` bigint(20) default NULL,
  `values_value_capacityvalues_e_id` bigint(20) default NULL,
  `values_value_forecastvalues_e_id` bigint(20) default NULL,
  `netxresource_values_e_id` bigint(20) default NULL,
  `netxresource_values_idx` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `netxresource_metricvalues` (`values_value_metricvalues_e_id`),
  KEY `FK69129A98F3F6D425` (`netxresource_values_e_id`),
  KEY `netxresource_capacityvalues` (`values_value_capacityvalues_e_id`),
  KEY `netxresource_forecastvalues` (`values_value_forecastvalues_e_id`),
  CONSTRAINT `FK69129A98F3F6D425` FOREIGN KEY (`netxresource_values_e_id`) REFERENCES `netxresource` (`e_id`),
  CONSTRAINT `netxresource_capacityvalues` FOREIGN KEY (`values_value_capacityvalues_e_id`) REFERENCES `value` (`e_id`),
  CONSTRAINT `netxresource_forecastvalues` FOREIGN KEY (`values_value_forecastvalues_e_id`) REFERENCES `value` (`e_id`),
  CONSTRAINT `netxresource_metricvalues` FOREIGN KEY (`values_value_metricvalues_e_id`) REFERENCES `value` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_functionmetricrefs`
--

DROP TABLE IF EXISTS `function_functionmetricrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_functionmetricrefs` (
  `function_e_id` bigint(20) NOT NULL,
  `metric_e_id` bigint(20) NOT NULL,
  `function_functionmetricrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_functionmetricrefs_idx`),
  KEY `FK3FE0518FD08B1F34` (`function_e_id`),
  KEY `function_functionmetricrefs` (`metric_e_id`),
  CONSTRAINT `FK3FE0518FD08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_functionmetricrefs` FOREIGN KEY (`metric_e_id`) REFERENCES `metric` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `company_companyref_e_id` bigint(20) default NULL,
  `email` varchar(255) default NULL,
  `firstname` varchar(100) default NULL,
  `lastname` varchar(100) default NULL,
  `password` varchar(255) default NULL,
  `library_users_e_id` bigint(20) default NULL,
  `library_users_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `user_companyref` (`company_companyref_e_id`),
  KEY `library_users` (`library_users_e_id`),
  CONSTRAINT `library_users` FOREIGN KEY (`library_users_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `user_companyref` FOREIGN KEY (`company_companyref_e_id`) REFERENCES `company` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment_equipmentrelationshiprefs`
--

DROP TABLE IF EXISTS `equipment_equipmentrelationshiprefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_equipmentrelationshiprefs` (
  `equipment_e_id` bigint(20) NOT NULL,
  `equipmentrelationship_e_id` bigint(20) NOT NULL,
  `equipment_equipmentrelationshiprefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`equipment_e_id`,`equipment_equipmentrelationshiprefs_idx`),
  KEY `equipment_equipmentrelationshiprefs` (`equipmentrelationship_e_id`),
  KEY `FK307BC69535537CB4` (`equipment_e_id`),
  CONSTRAINT `equipment_equipmentrelationshiprefs` FOREIGN KEY (`equipmentrelationship_e_id`) REFERENCES `relationship` (`e_id`),
  CONSTRAINT `FK307BC69535537CB4` FOREIGN KEY (`equipment_e_id`) REFERENCES `equipment` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `datetimerange`
--

DROP TABLE IF EXISTS `datetimerange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datetimerange` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `begin` datetime default NULL,
  `end` datetime default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `netxresource`
--

DROP TABLE IF EXISTS `netxresource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netxresource` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `calcname` varchar(100) default NULL,
  `calculateddata` bit(1) default NULL,
  `detaildisplay` bit(1) default NULL,
  `longname` longtext,
  `shortname` varchar(100) default NULL,
  `summarydisplay` bit(1) default NULL,
  `unit_unitref_e_id` bigint(20) default NULL,
  `equipment_equipmentresources_e_id` bigint(20) default NULL,
  `equipment_equipmentresources_idx` int(11) default NULL,
  `function_functionresources_e_id` bigint(20) default NULL,
  `function_functionresources_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `equipment_equipmentresources` (`equipment_equipmentresources_e_id`),
  KEY `netxresource_unitref` (`unit_unitref_e_id`),
  KEY `function_functionresources` (`function_functionresources_e_id`),
  CONSTRAINT `equipment_equipmentresources` FOREIGN KEY (`equipment_equipmentresources_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `function_functionresources` FOREIGN KEY (`function_functionresources_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `netxresource_unitref` FOREIGN KEY (`unit_unitref_e_id`) REFERENCES `unit` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parameter_elementrefs`
--

DROP TABLE IF EXISTS `parameter_elementrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter_elementrefs` (
  `parameter_e_id` bigint(20) NOT NULL,
  `elementrefs_type` varchar(255) default NULL,
  `elementrefs_id` bigint(20) default NULL,
  `parameter_elementrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`parameter_e_id`,`parameter_elementrefs_idx`),
  KEY `parameter_elementrefs` (`parameter_e_id`),
  CONSTRAINT `parameter_elementrefs` FOREIGN KEY (`parameter_e_id`) REFERENCES `parameter` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicesupport`
--

DROP TABLE IF EXISTS `servicesupport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicesupport` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `supportdays` varchar(255) default NULL,
  `supporthours` varchar(255) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `shape` varchar(255) default NULL,
  `site_siteref_e_id` bigint(20) default NULL,
  `library_rooms_e_id` bigint(20) default NULL,
  `library_rooms_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_rooms` (`library_rooms_e_id`),
  KEY `room_siteref` (`site_siteref_e_id`),
  CONSTRAINT `library_rooms` FOREIGN KEY (`library_rooms_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `room_siteref` FOREIGN KEY (`site_siteref_e_id`) REFERENCES `site` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serviceadditional`
--

DROP TABLE IF EXISTS `serviceadditional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceadditional` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `costcenter` varchar(255) default NULL,
  `history` varchar(255) default NULL,
  `kpi` varchar(255) default NULL,
  `lifecyclestate` varchar(255) default NULL,
  `link` varchar(255) default NULL,
  `report` varchar(255) default NULL,
  `usagestate` varchar(255) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `metriclibrary`
--

DROP TABLE IF EXISTS `metriclibrary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metriclibrary` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `expression_functionrefs`
--

DROP TABLE IF EXISTS `expression_functionrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expression_functionrefs` (
  `expression_e_id` bigint(20) NOT NULL,
  `function_e_id` bigint(20) NOT NULL,
  `expression_functionrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`expression_e_id`,`expression_functionrefs_idx`),
  KEY `expression_functionrefs` (`function_e_id`),
  KEY `FKA9A7F05F8807CF34` (`expression_e_id`),
  CONSTRAINT `expression_functionrefs` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `FKA9A7F05F8807CF34` FOREIGN KEY (`expression_e_id`) REFERENCES `expression` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `description` longtext,
  `name` varchar(100) default NULL,
  `state` varchar(255) default NULL,
  `value` double default NULL,
  `library_parameters_e_id` bigint(20) default NULL,
  `library_parameters_idx` int(11) default NULL,
  `serviceprofile_serviceparameters_e_id` bigint(20) default NULL,
  `serviceprofile_serviceparameters_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `serviceprofile_serviceparameters` (`serviceprofile_serviceparameters_e_id`),
  KEY `library_parameters` (`library_parameters_e_id`),
  CONSTRAINT `library_parameters` FOREIGN KEY (`library_parameters_e_id`) REFERENCES `library` (`e_id`),
  CONSTRAINT `serviceprofile_serviceparameters` FOREIGN KEY (`serviceprofile_serviceparameters_e_id`) REFERENCES `serviceprofile` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `metricsource_metricrefs`
--

DROP TABLE IF EXISTS `metricsource_metricrefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metricsource_metricrefs` (
  `metricsource_e_id` bigint(20) NOT NULL,
  `metric_e_id` bigint(20) NOT NULL,
  `metricsource_metricrefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`metricsource_e_id`,`metricsource_metricrefs_idx`),
  KEY `FKF77076E421950E34` (`metric_e_id`),
  KEY `FKF77076E4D631BB34` (`metricsource_e_id`),
  CONSTRAINT `FKF77076E421950E34` FOREIGN KEY (`metric_e_id`) REFERENCES `metric` (`e_id`),
  CONSTRAINT `FKF77076E4D631BB34` FOREIGN KEY (`metricsource_e_id`) REFERENCES `metricsource` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagraminfo`
--

DROP TABLE IF EXISTS `diagraminfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagraminfo` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `diagramkind` varchar(255) default NULL,
  `location` varchar(255) default NULL,
  `equipment_diagrams_e_id` bigint(20) default NULL,
  `equipment_diagrams_idx` int(11) default NULL,
  `function_functiondiagrams_e_id` bigint(20) default NULL,
  `function_functiondiagrams_idx` int(11) default NULL,
  `network_diagrams_e_id` bigint(20) default NULL,
  `network_diagrams_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `function_functiondiagrams` (`function_functiondiagrams_e_id`),
  KEY `equipment_diagrams` (`equipment_diagrams_e_id`),
  KEY `network_diagrams` (`network_diagrams_e_id`),
  CONSTRAINT `equipment_diagrams` FOREIGN KEY (`equipment_diagrams_e_id`) REFERENCES `equipment` (`e_id`),
  CONSTRAINT `function_functiondiagrams` FOREIGN KEY (`function_functiondiagrams_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `network_diagrams` FOREIGN KEY (`network_diagrams_e_id`) REFERENCES `network` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsservice_elements`
--

DROP TABLE IF EXISTS `cfsservice_elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsservice_elements` (
  `cfsservice_e_id` bigint(20) NOT NULL,
  `elements_type` varchar(255) default NULL,
  `elements_id` bigint(20) default NULL,
  `cfsservice_elements_idx` int(11) NOT NULL,
  PRIMARY KEY  (`cfsservice_e_id`,`cfsservice_elements_idx`),
  KEY `cfsservice_elements` (`cfsservice_e_id`),
  CONSTRAINT `cfsservice_elements` FOREIGN KEY (`cfsservice_e_id`) REFERENCES `service` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `value`
--

DROP TABLE IF EXISTS `value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `value` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `timestamp` datetime default NULL,
  `value` double default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicename`
--

DROP TABLE IF EXISTS `servicename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicename` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `alias` varchar(100) default NULL,
  `identifier` varchar(100) default NULL,
  `index` int(11) default NULL,
  `name` varchar(100) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `countrycode` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `library_countries_e_id` bigint(20) default NULL,
  `library_countries_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_countries` (`library_countries_e_id`),
  CONSTRAINT `library_countries` FOREIGN KEY (`library_countries_e_id`) REFERENCES `library` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `function_functionrelationshiprefs`
--

DROP TABLE IF EXISTS `function_functionrelationshiprefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `function_functionrelationshiprefs` (
  `function_e_id` bigint(20) NOT NULL,
  `functionrelationship_e_id` bigint(20) NOT NULL,
  `function_functionrelationshiprefs_idx` int(11) NOT NULL,
  PRIMARY KEY  (`function_e_id`,`function_functionrelationshiprefs_idx`),
  KEY `function_functionrelationshiprefs` (`functionrelationship_e_id`),
  KEY `FKA5135AD7D08B1F34` (`function_e_id`),
  CONSTRAINT `FKA5135AD7D08B1F34` FOREIGN KEY (`function_e_id`) REFERENCES `function` (`e_id`),
  CONSTRAINT `function_functionrelationshiprefs` FOREIGN KEY (`functionrelationship_e_id`) REFERENCES `relationship` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serviceincidentmgt`
--

DROP TABLE IF EXISTS `serviceincidentmgt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceincidentmgt` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `businessimpact` varchar(255) default NULL,
  `maintenance` varchar(255) default NULL,
  `maintenancewindow` varchar(255) default NULL,
  `monitoring` varchar(255) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `expression`
--

DROP TABLE IF EXISTS `expression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expression` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `library_expressions_e_id` bigint(20) default NULL,
  `library_expressions_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `library_expressions` (`library_expressions_e_id`),
  CONSTRAINT `library_expressions` FOREIGN KEY (`library_expressions_e_id`) REFERENCES `library` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `procedure`
--

DROP TABLE IF EXISTS `procedure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedure` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(100) default NULL,
  `protocol_procedures_e_id` bigint(20) default NULL,
  `protocol_procedures_idx` int(11) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`),
  KEY `protocol_procedures` (`protocol_procedures_e_id`),
  CONSTRAINT `protocol_procedures` FOREIGN KEY (`protocol_procedures_e_id`) REFERENCES `protocol` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serviceinterrest`
--

DROP TABLE IF EXISTS `serviceinterrest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceinterrest` (
  `e_id` bigint(20) NOT NULL auto_increment,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `contactunit` varchar(255) default NULL,
  `interrestkind` varchar(255) default NULL,
  `econtainer_class` varchar(255) default NULL,
  `e_container` varchar(255) default NULL,
  `e_container_feature_name` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-01-24 12:50:03
