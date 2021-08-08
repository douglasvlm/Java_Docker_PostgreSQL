## Java_Docker_PostgreSQL

## Requirements

* Linux
* Java 8
* Docker
* IntelliJ Community

### Spring Boot
* * [https://start.spring.io/](https://start.spring.io/)
+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver


## DataBase

### Postgres
```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate
##### Tables
* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL
#Enter containner bash
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash
# show SO> cat /etc/os-release
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
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
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
#### Enter containner bash
```shell
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h heroku.database-url -U user_database name_database -f /tmp/pais.sql
psql -h heroku.database-url -U user_database name_database -f /tmp/estado.sql
psql -h heroku.database-url -U user_database name_database -f /tmp/cidade.sql
psql -h heroku.database-url -U user_database name_database -f
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```
https://murmuring-castle-80052.herokuapp.com/cities

https://murmuring-castle-80052.herokuapp.com/states

https://murmuring-castle-80052.herokuapp.com/countries

https://murmuring-castle-80052.herokuapp.com/distances/by-points?from=4929&to=5254

https://murmuring-castle-80052.herokuapp.com/distances/by-cube?from=4929&to=5254
