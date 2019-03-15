# Store various java.time types in PostgreSQL

## Prerequisite

* `time_tests` database on localhost


## Using
* Start application with DB credentials <br>
  passed as VM options `-Dspring.datasource.username=dbuser`, `-Dspring.datasource.password=dbpass`

      mvn -pl app spring-boot:run -Dspring.datasource.username=dbuser -Dspring.datasource.password=dbpass

* Open browser at http://localhost:8085/swagger-ui.html
