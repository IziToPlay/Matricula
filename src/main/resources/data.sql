INSERT INTO articles (article_id, created_at, updated_at, author, category, content, description, title) VALUES
  ( 1000, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'Java', 'Central to the Spring Framework is its inversion of control (IoC) container, which provides a consistent means of configuring and managing Java objects using reflection. The container is responsible for managing object lifecycles of specific objects: creating these objects, calling their initialization methods, and configuring these objects by wiring them together.
Objects created by the container are also called managed objects or beans. The container can be configured by loading XML (Extensible Markup Language) files or detecting specific Java annotations on configuration classes. These data sources contain the bean definitions that provide the information required to create the beans.
Objects can be obtained by means of either dependency lookup or dependency injection.[12] Dependency lookup is a pattern where a caller asks the container object for an object with a specific name or of a specific type. Dependency injection is a pattern where the container passes objects by name to other objects, via either constructors, properties, or factory methods.
In many cases one need not use the container when using other parts of the Spring Framework, although using it will likely make an application easier to configure and customize. The Spring container provides a consistent mechanism to configure applications and integrates with almost all Java environments, from small-scale applications to large enterprise applications.
The container can be turned into a partially compliant EJB (Enterprise JavaBeans) 3.0 container by means of the Pitchfork project. Some[who?] criticize the Spring Framework for not complying with standards.[13] However, SpringSource doesn''t see EJB 3 compliance as a major goal, and claims that the Spring Framework and the container allow for more powerful programming models.[14] The programmer does not directly create an object, but describe how they should be created, by defining it in the Spring configuration file. Similarly services and components are not called directly; instead a Spring configuration file defines which services and components must be called. This IoC is intended to increase the ease of maintenance and testing.', 'The Spring Framework is an application framework and inversion of control container for the Java platform. The framework''s core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE (Enterprise Edition) platform. ','Spring Framework'),
  ( 1001, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'Java', 'While template processors are typically a separate piece of software, used as part of a system or framework, simple templating languages are commonly included in the string processing features of general-purpose programming languages, and in text processing programs, notably text editors or word processors. The templating languages are generally simple substitution-only languages, in contrast to the more sophisticated facilities in full-blown template processors, but may contain some logic.
Simple examples include print format strings, found in many programming languages, and snippets, found in a number of text editors and source code editors. In word processors, templates are a common feature, while automatic filling in of the templates is often referred to as mail merge.', 'A template processor (also known as a template engine or template parser) is software designed to combine templates with a data model to produce result documents.[1][2][3] The language that the templates are written in is known as a template language or templating language. ','Template processor'),
  ( 1002, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'Java', 'Tomcat started off as a servlet reference implementation by James Duncan Davidson, a software architect at Sun Microsystems. He later helped make the project open source and played a key role in its donation by Sun Microsystems to the Apache Software Foundation.[10] The Apache Ant software build automation tool was developed as a side-effect of the creation of Tomcat as an open source project.
Davidson had initially hoped that the project would become open sourced and, since many open source projects had O''Reilly books associated with them featuring an animal on the cover, he wanted to name the project after an animal. He came up with Tomcat since he reasoned the animal represented something that could fend for itself. Although the tomcat was already in use for another O''Reilly title,[11] his wish to see an animal cover eventually came true when O''Reilly published their Tomcat book with a snow leopard on the cover in 2003.[12]', 'Apache Tomcat, often referred to as Tomcat Server, is an open-source Java Servlet Container developed by the Apache Software Foundation (ASF). Tomcat implements several Java EE specifications including Java Servlet, JavaServer Pages (JSP), Java EL, and WebSocket, and provides a "pure Java" HTTP web server environment in which Java code can run.','Apache Tomcat'),
  ( 1003, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'Java', 'The Spring Web Flow project started as a simple extension to the Spring Web MVC framework providing web flow functionality, developed by Erwin Vervaet in 2004. In 2005 the project was introduced into the Spring portfolio by Keith Donald and grew into the official Spring sub-project it is now. The first production ready 1.0 release was made on 2006-10-26. Version 2.0, first released on 2008-04-29, saw a major internal reorganization of the framework to allow better integration with JavaServer Faces.', 'Spring Web Flow (SWF) is the sub-project of the Spring Framework that focuses on providing the infrastructure for building and running rich web applications. ','Spring Web Flow'),
  ( 1004, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'Java', ' It is a server-based system that runs in servlet containers such as Apache Tomcat. It supports version control tools, including AccuRev, CVS, Subversion, Git, Mercurial, Perforce, TD/OMS, ClearCase and RTC, and can execute Apache Ant, Apache Maven and sbt based projects as well as arbitrary shell scripts and Windows batch commands. The creator of Jenkins is Kohsuke Kawaguchi.[4] Released under the MIT License, Jenkins is free software.[5]
Builds can be triggered by various means, for example by commit in a version control system, by scheduling via a cron-like mechanism and by requesting a specific build URL. It can also be triggered after the other builds in the queue have completed. Jenkins functionality can be extended with plugins.
The Jenkins project was originally named Hudson, and was renamed after a dispute with Oracle, which had forked the project and claimed rights to the project name. The Oracle fork, Hudson, continued to be developed for a time before being donated to the Eclipse Foundation. Oracle''s Hudson is no longer maintained[6][7] and was announced as obsolete in February 2017.[8]', 'Jenkins is an open source automation server written in Java. Jenkins helps to automate the non-human part of the software development process, with continuous integration and facilitating technical aspects of continuous delivery. ','Jenkins (software)'),
  ( 1005, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'TypeScript', 'Angular 2.0 was announced at the ng-Europe conference 22-23. October 2014.[9][10] The drastic changes in the 2.0 version created considerable controversy among developers.[11] On April 30, 2015, the Angular developers announced that Angular 2 moved from Alpha to Developer Preview.[12] Angular 2 moved to Beta in December 2015,[13] and the first release candidate was published in May 2016.[14] The final version was released on September 14, 2016.Angular 6 was released on May 4, 2018.[20]. This is a major release focused less on the underlying framework, and more on the toolchain and on making it easier to move quickly with Angular in the future, like: ng update, ng add, Angular Elements, Angular Material + CDK Components, Angular Material Starter Components, CLI Workspaces, Library Support, Tree Shakable Providers, Animations Performance Improvements, and RxJS v6.', 'Angular (commonly referred to as "Angular 2+" or "Angular v2 and above")[4][5] is a TypeScript-based open-source web application framework led by the Angular Team at Google and by a community of individuals and corporations. Angular is a complete rewrite from the same team that built AngularJS.','Angular (web framework)'),
  ( 1006, '2018-12-28 00:27:24', '2019-12-28 00:27:24', 'Wikipedia', 'JavaScript', 'React can be used as a base in the development of single-page or mobile applications, as it''s optimal only for its intended use of being the quickest method to fetch rapidly changing data that needs to be recorded. However, fetching data is only the beginning of what happens on a web page, which is why complex React applications usually require the use of additional libraries for state management, routing, and interaction with an API. React was created by Jordan Walke, a software engineer at Facebook. He was influenced by XHP, an HTML component framework for PHP.[9] It was first deployed on Facebook''s newsfeed in 2011 and later on Instagram.com in 2012.[10] It was open-sourced at JSConf US in May 2013.
React Native, which enables native Android, iOS, and UWP development with React, was announced at Facebook''s React.js Conf in February 2015 and open-sourced in March 2015.
On April 18, 2017, Facebook announced React Fiber, a new core algorithm of React framework library for building user interfaces.[11] React Fiber was to become the foundation of any future improvements and feature development of the React framework.[12][needs update]
On April 19, 2017, React 360 V1.0.0 was released to the public.[13] This allowed developers with experience using react to jump into VR development.', 'React (also known as React.js or ReactJS) is a JavaScript library[3] for building user interfaces. It is maintained by Facebook and a community of individual developers and companies.','React (JavaScript library)');

INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$sr2ZuTYlZ.LsliI6sv.HqeH39WsA.gz9Fdr.S0CyCBByyPQ8TObvS','admin');
INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$ZoqMrCUHNN8lE2g1zssyuucNhExlYwN06kM/Jo6vEBhyTQduQ7iCy','jefe');

INSERT INTO authorities(authority,user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',2);
