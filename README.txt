/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
 
 
********Assumptions***********
-project is set up as a maven project
-maven and jdk6+ are pre-installed. I used maven 3.0.4 plugin with eclipse 3.8.2
-Datastore data is mocked. Although there is hypersonic in-memory DB (hsqldb) configured, it is NOT used as per the requirements.
-Hibernate entities are fully configured and associated. However, they are not functionally managed in a data store as the data is mocked.
-Requests and responses and actual statistical data is mocked
-Required APIs and JSON strings  are slightly modified from the given format but fulfill the requirements based on a correct entity model.
-The requirements suggested to persist the JSON as a raw string. This design rather persists the object representation so that the statistical information as JSON can be dynamically created.

******Technology Used*********
-maven 3.0.4 as build system and project structure standard
-Java 1.6 as a programming language
-Fully configured Hypersonic in-memory DB 2.3 (although not functionally used)
-Testng 6.1.1 Framework for testing
-Spring 3.0 for light-weight bean management
-Hibernate 3.6.9 as persistence ORM framework.
-apache CXF 2.2.12 for exposing JAX-RS services
-Apache Tomcat 7.0.42 as a web/servlet container


******Run and Test*********
-pull the project as "git clone https://github.com/bjasmeet/ebay-interview.git"
-to create the war run "mvn clean install -DskipTests=true" from the project directory
-deploy the "ebay-interview.war" from the target directory to "<TOMCAT_HOME>/webapps/" directory
-You can view the wadl service definition at "http://localhost:8080/ebay-interview/services/interview?_wadl&_type=xml"
-To run functional tests run "mvn test" from the project directory.
  

