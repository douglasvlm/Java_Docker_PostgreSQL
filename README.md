<hr/>
<div align="center">
    <h1>Desenvolvimento de aplicações com Java</h1>
    <h2><i>API Rest de consulta de cidades do Brasil com dados comparativos</i></h2>
    <a href="https://www.jetbrains.com/idea/" target="_blank"><img src="https://img.icons8.com/color/96/000000/intellij-idea.png" alt="intellij-idea" width="140" height="140"/></a>
    <a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="140" height="140"/> </a>
    <a href="https://www.docker.com/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="140" height="140"/> </a>  
    <a href="https://www.postgresql.org" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="140" height="140"/> </a> 
    <h3>Este repositório é meu projeto do Bootcamp Java - Digital Innovation One.</h3>
    <a href="https://digitalinnovation.one/sign-in"><img src="https://hermes.digitalinnovation.one/site/images/logo-footer.png" width="450" height="150"></a>
    <i>Desenvolvimento de aplicações com Java</i>
<hr/>
 Test My API 
  
https://murmuring-castle-80052.herokuapp.com/cities

https://murmuring-castle-80052.herokuapp.com/states

https://murmuring-castle-80052.herokuapp.com/countries

https://murmuring-castle-80052.herokuapp.com/distances/by-points?from=4929&to=5254

https://murmuring-castle-80052.herokuapp.com/distances/by-cube?from=4929&to=5254

</div>
<hr/>

## Requirements
* Linux
* Java 8
* Docker
* IntelliJ Community

### Spring Boot
* [https://start.spring.io/](https://start.spring.io/)
+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver


## DataBase
##### Tables
* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

### Postgres x Docker
```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres

cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

#Enter containner bash
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash
# show container SO> cat /etc/os-release
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql
docker exec -it cities-db /bin/bash
psql -U postgres_user_city cities

# /d tablename
# select * from table name;
psql -h localhost -U postgres_user_city cities

# Postman Get
# http://localhost:8080/countries?page=0&size=50&sort=id,asc
# http://localhost:8080/cities
# http://localhost:8080/states
# http://localhost:8080/distances/by-points?from=4929&to=5254
# http://localhost:8080/distances/by-cube?from=4929&to=5254
```


### Query Earth Distance
Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

#### Heroku
heroku addons:create heroku-postgresql
