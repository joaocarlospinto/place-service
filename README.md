<h1 align="center">
  Place Service
</h1>

<h3> Author: João Carlos Pinto </h3>
API to manage Places.

## Tecnologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring Data + R2DBC](https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Slugify](https://github.com/slugify/slugify)

## Adopted Practices

- SOLID
- Automated Tests
- Dynamic Query filters using "Query By Example"
- API web reactive in Data layer
- Used DTOs for the API
- Dependencies Injection
- Swagger Automatic Creation with OpenAPI 3
- Slugs  automatic generation with Slugify
- Audit on Entity Creation and Update.

## How to Run

### Localy
- Clone Git Repository
- Build Project:
```
./mvnw clean package
```
- Run:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```

Access the API at: [localhost:8080](http://localhost:8080).
Swagger can be checked at: [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Using Docker

- Clone git repository 
- Build Project:
```
./mvnw clean package
```
- Build Image:
```
./mvnw spring-boot:build-image
```
- Run the container:
```
docker run --name place-service -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

The API can be accessed at: [localhost:8080](http://localhost:8080).
Swagger can be checked at: [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

To execute the requests POSTMAN software was used.

- POST /places
```
http POST :8080/places name="Place" city= "City" state="State"

HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Place",
    "slug": "place",
    "city": "City",
    "state": "State",
    "updatedAt": "2023-04-20T19:00:07.241632"
}
```

- GET /places/{id}
```
http :8080/places/1
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "Place",
    "slug": "place",
    "city": "City",
    "state": "State",
    "updatedAt": "2023-06-07T14:45:39.693689"
} 
```

- GET /places?name=?
```
http :8080/places name==PLACE
HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "createdAt": "2023-06-07T14:45:39.693689",
        "name": "Place",
        "slug": "place",
        "city": "City",
        "state": "State",
        "updatedAt": "2023-06-07T14:45:39.693689"
    }
]
```

- PATCH /places/{id}
```
http PATCH :8080/places/1 name='New Name' city='New City' state='New State'
HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "New Name",
    "slug": "new-name",
    "city:" "New City",
    "state": "New State",
    "updatedAt": "2023-06-07T14:53:21.671129345"
}
```
