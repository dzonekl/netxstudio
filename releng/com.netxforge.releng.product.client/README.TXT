Releng Product Template
=======================

This is a template for building NetXStudio products. 
It includes: 

1. The Query (netxstudio.cquery) for the resolution process.
The query resolves from a previously generated p2 site, which includes our materialized dependencies, 
including ther 

2. a customized .cspex which defines several actions: 

2.1 create.product

Creates a product invoking the p2 director, through an ANT build file. 
The ANT build file is part of Action definitions to build various kinds 
of products. 

p2 director information: 

http://help.eclipse.org/galileo/index.jsp?topic=/org.eclipse.platform.doc.isv/guide/p2_director.html

CSPEX
=====

General Properties

1. profile => value is netxStudioClientProfile [TODO, not sure what this means???]
2. iu => The 'Installable Unit' which is our product to build. 

ACTION:=> Replace the installable unit with the id of the product to build! 

Creates a product with the following inputs for an ANT actor: 
(See: buckybook.pdf => Chapter 
 
Actor Properties.  

1. buildFile => a path to the ant build file to perform the build. 
2  targets => The ant target to call, which is "create.product" in our case. 

Products (The output produced by the Action)

1. destination => The base directory where the output is produced, in our case the default buckminster.output
2. path => The name of the directory of the result. 

Prerequisites: 

1. repository => The repository for the director to use. which points to the site.p2 Attibute (Actor). 

ANT TASK
========

The ant task uses the properties to build the product. 













