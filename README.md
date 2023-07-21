# Hardware_Store_API

The Hardware Store Application is a web-based system that helps manage hardware components, stores, customer reviews, and categories related to a hardware store. It provides functionalities to add, update, delete, and fetch information about components, stores, customer reviews, and categories.

## Features

- View all hardware components, stores, customer reviews, and categories.
- Fetch information about a specific component, store, customer review, or category by ID.
- Add new hardware components, stores, customer reviews, and categories.
- Update existing hardware components, stores, customer reviews, and categories.
- Delete hardware components, stores, customer reviews, and categories by ID.

## Technology Stack

The Hardware Store Application is built using the following technology stack:

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB (as the database)
- Lombok (for code simplification)
- JSON (for data exchange)

## Setup and Run

1. **Prerequisites**: Ensure you have Java JDK, Maven, and MongoDB installed on your system.

    ```xml
   <java.version>17</java.version>
    ```
   
2. **Clone the Repository**: Clone this repository to your local machine.

   ```git
   git clone https://github.com/sasankaweera123/Hardware_Store_API.git
   ```
   
3. **Database Configuration**: Ensure that your MongoDB is up and running. The application expects MongoDB to be available at `localhost:27017` by default. If your MongoDB instance is running on a different port or host, modify the `application.properties` file accordingly.

    ```properties
    spring.data.mongodb.authentication-database=${auth_db}
    spring.data.mongodb.username=${db_user}
    spring.data.mongodb.password=${db_pass}
    spring.data.mongodb.database=${db_name}
    spring.data.mongodb.port=27017
    spring.data.mongodb.host=${db_host}
    
    spring.data.mongodb.auto-index-creation=true
    ```

4. **Build and Run the Application**:
    - Navigate to the root folder of the cloned repository.
    - Run the following command to build the application: `mvn clean install`
    - After the build is successful, run the application using: `mvn spring-boot:run`

5. **Accessing the Application**: The application should now be up and running. You can access the API endpoints using tools like Postman or any web browser.


## API Endpoints

The Hardware Store Application exposes various API endpoints for managing components, stores, customer reviews, and categories. Below are some of the main endpoints:

- `GET /api/v1/component/all`: Fetch all hardware components.
- `GET /api/v1/component/{componentId}`: Fetch a specific component by ID.
- `POST /api/v1/component`: Add a new hardware component.
- `PUT /api/v1/component/{componentId}`: Update an existing hardware component.
- `DELETE /api/v1/component/{componentId}`: Delete a hardware component by ID.
- `GET /api/v1/store/all`: Fetch all stores.
- `GET /api/v1/store/{storeId}`: Fetch a specific store by ID.
- `GET /api/v1/customer_review/all`: Fetch all customer reviews.
- `GET /api/v1/customer_review/{customerReviewId}`: Fetch a specific customer review by ID.
- `POST /api/v1/customer_review`: Add a new customer review.
- `PUT /api/v1/customer_review/{customerReviewId}`: Update an existing customer review.
- `DELETE /api/v1/customer_review/{customerReviewId}`: Delete a customer review by ID.
- `GET /api/v1/category/all`: Fetch all categories.
- `GET /api/v1/category/{categoryId}`: Fetch a specific category by ID.

## Contributing

Contributions to this project are welcome. You can fork the repository, make changes, and submit a pull request. Please make sure to follow the existing code style and conventions.

## LICENSE

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Acknowledgements

This project was developed as part of a learning exercise and is not intended for production use.
