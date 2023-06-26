# Documentation

## Prerequisites

- Java 20

## Initial start

When starting this application for the first time the database schema should be created and database also must be seeded using SQL migration script (`data.sql`). Follow these steps:

1. Setup connection to the `MySql` database by opening `application.properties` and setting these values to your specific environment:

```
spring.datasource.url=jdbc:mysql://localhost:3306/zoodb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

2. To enable the migration edit the values below in `application.properties`:

```
spring.jpa.hibernate.ddl-auto=create
spring.sql.init.mode=always
```

3. Start the application.

4. Database should be created and seeded. Now change these values back if you don't want your database to be recreated on every startup:

```
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=never
```

## Example API call

The application is accessible calling this URL: `http://localhost:4200`.

The database is seeded with one `Zoo` where you can transfer animals to.

Make an HTTP `POST` request to the endpoint `http://localhost:4200/transfer/1`.
Request body:

```JSON
{
    "animals": [
        {
            "species": "Lion",
            "food": "Carnivore",
            "amount": 2
        },
        {
            "species": "Tiger",
            "food": "Carnivore",
            "amount": 3
        },
        {
            "species": "Elephant",
            "food": "Herbivore",
            "amount": 5
        },
        {
            "species": "Giraffe",
            "food": "Herbivore",
            "amount": 2
        },
        {
            "species": "Polar Bear",
            "food": "Carnivore",
            "amount": 2
        },
        {
            "species": "Zebra",
            "food": "Herbivore",
            "amount": 4
        },
        {
            "species": "Cheetah",
            "food": "Carnivore",
            "amount": 5
        },
        {
            "species": "Jaguar",
            "food": "Carnivore",
            "amount": 2
        },
        {
            "species": "Gorilla",
            "food": "Herbivore",
            "amount": 2
        },
        {
            "species": "Wolf",
            "food": "Carnivore",
            "amount": 4
        },
        {
            "species": "Hyena",
            "food": "Carnivore",
            "amount": 5
        }
    ]
}
```

### Add new animal to an existing zoo

`POST http://localhost:4200/animal`

```JSON
{
    "zooId": 1,
    "animal": {
        "species": "Elephant",
        "food": "Herbivore",
        "amount": 5
    }
}
```