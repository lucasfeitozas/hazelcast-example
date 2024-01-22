# Hazelcast Example
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"><img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" alt=""><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt=""><img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="">
A spring-boot application using cache (provided by hazelcast), MySQL as database and Flyway for migrations.

## Table of Contents
1. [Requirements](#requirements)
2. [Usage](#usage)
3. [Api Endpoint](#api-endpoints)

## Requirements
* Install [MySQL](https://www.mysql.com/downloads/)
* Clone the project
<pre>
<code>
git clone https://github.com/lucasfeitozas/hazelcast-example.git
</code>
</pre>

## Usage
First, you need to install MySQL database and Java JDK (version 21). After this, clone this project and execute
```
cd hazelcast-example
mvn clean install
java -jar target/hazelcast-example-0.0.1-SNAPSHOT.jar
```

## API Endpoints

``` 
GET /places - Retrieve a list of places.

GET /places/{id} - Search Place by ID

POST /places - Login into the App

PUT /places/{id} - Update Places

DELETE /places - Remove a place by ID
```
