# About
This repo is about me learning Spring Boot from [Amigoscode course](https://www.youtube.com/watch?v=9SGDpanrc8U).

## Technologies Used
1. Java 11
2. Spring Boot
    1. Spring Web
    2. Spring Data JPA
3. PostgreSQL

## Quick Start
1. Make sure you have **Java 11** and **[PostgreSQL](https://www.postgresql.org/download/)** installed
2. This project is using [Maven](https://maven.apache.org/) as it's project management tool.
3. Clone this repo
   ```shell
   git clone https://github.com/Alviannn/learning-spring-boot.git
   ```
4. Edit the database credentials at `src/main/resources/application.properties`,
   currently it's using my local database credentials.
5. Run maven goals
   ```shell
   mvn clean install
   ```
6. Start the server
   ```shell
   java -jar target/demo-0.0.1-SNAPSHOT.jar
   ```