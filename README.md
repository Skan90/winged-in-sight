# winged-in-sight
Project for DBServer onboarding process with PUC-RS

# Swagger 2 (3.0.0) documentation for Controller
###LOCAL
http://localhost:8080/swagger-ui/
###API
https://wingedinsight.herokuapp.com/swagger-ui/

# For Local Running

Comment inside 'src/main/resources/application.properties' the lines under 'Database configuration for HEROKU' and uncomment the lines under 'Database configuration for local testing'

ALSO COMMENT in the first run lines under 'DataSource initialization to be able to build upon the schema creation performed by Hibernate', from the second run, uncomment for population of database.

# Grade Project

For running inside the folder:

gradlew bootRun

Acess the API Swagger for more datails on GET/POST/PUT/DELETE methods.

# Front end for the app with deployed API is found here

https://github.com/Skan90/wingedinsightfront

