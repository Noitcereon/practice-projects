# Movie Spring API

Movie Spring API is a small practice project, where I tried to recreate something similar to the Movie Spring API
from the Experis course, alone.

I did not write this README at the time I made this project, but now that I look back at at this project I see that it
requires one.

## Installation
This installation section will help you get the app up and running on your localhost.

Prerequisites:
- Docker
- Maven
- JDK 17 or above

1. Create a `.env` file based on the .env-example
2. Run `docker compose up` 
   - This starts the database and an application on localhost:8084 in Docker.
   - **Note:** The app running in docker cannot communicate with the Docker hosted database without some additional fiddling.
3. Run MovieApiSpringBootApplication.java (the easiest way is through an IDE).
   - This should start an application at `localhost:8083`
   - This is the application you want to use.

NOTE: There is a an sql script in `movie-api-spring-boot/src/test/java/com/noitcereon/database/testSeeding.sql` for seeding the database.

## Usage
As this is a practice project there is not much to do with it. I found a Swagger UI (OpenAPI UI) and based 
on the `movie-spring-api.html` file I tried to do some calls via JavaScript as well, just to try 'external' calls.

- The Swagger UI can be accessed at http://localhost:8083/swagger-ui/index.html

- Adminer can be accessed at http://localhost:8080 (login with credentials set in .env)
- The frontend (testApiHtml) I haven't figured out how to access properly (with the calls working).

## Maintainer
@Noitcereon
