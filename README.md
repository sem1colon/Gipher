# Gipher

Get all the trending gifs and search for your desired gifs. Gipher is a gifs managing application, where you can bookmark and save your favourite gifs.

## Description

This application is made using **Angular** as front-end, **Spring-Boot** as back-end and **MySQL** as database.

## How to run the application?
*  Start your MySQL Server and create a database
`create database gipherdb;`
*  Configure your MySQL details in *env-variable.sh* files
*  From the project root directory, start the Spring-Boot application from each micro-service
`source build.sh`
`mvn spring-boot:run`
*  Change directory to Angular project, and start the angular application
`cd GipherUI`
`npm install`
`ng serve --open`
*  The application will start running in your default browser

## How to run tests?

*  Run `mvn test -B`, for running Spring-Boot unit and end-to-end tests 

*  Run `ng test` to execute the Angular unit tests via [Karma](https://karma-runner.github.io)

*  Run `ng e2e` to execute the Angular end-to-end tests via [Protractor](http://www.protractortest.org)

## How to deploy the application through docker?

*  Run the *build.sh* in the application root directory for building the Spring-Boot application **jars**
`source build.sh`
*  Change Directory to Angular project for building the Angular **dist** folder
`cd GipherUI`
`ng build --prod`
*  Now, start the docker by starting **docker-compose.yml** file
`docker-compose build` or `docker-compose up`
