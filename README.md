# Hardware_Store_API

This is a sample project for a hardware store application built using Spring Boot and MongoDB. The application allows users to manage components available in the hardware store.

```java
String componentId = "C0001";
Component component = new Component(
  componentId,
  "Light Sensor",
  "Light sensor module is used to detect the intensity of light. It has both analog output pin and digital output pin labeled as AO and DO respectively on the board. This sensor module is designed to detect and measure various physical properties, such as temperature, humidity, pressure, light intensity and more.",
  "Sensor",
  "https://raw.githubusercontent.com/RPSTD/component101/main/LightSensor/IMG/IMG.png",
  List.of("Connect the LDR to the analog input pin 0 on the Arduino board.", "Connect the VCC leg on the sensor to the 5V pin of the Arduino board.", "Connect the GRD leg on the sensor to the GND pin of the Arduino board.", "A connection diagram is provided to illustrate the connections."),
  List.of("When there is light, the resistance of LDR becomes low according to the intensity of light.","This means when the light level decreases, the resistance of the LDR increases.", "The resistance of LDR is inversely proportional to the intensity of light.","Light sensors are a type of photodetector (also called photosensor) that detect light.","Different types of light sensors can be used to measure illuminance, respond to changes in the amount of light received, or convert light to electricity."),
  List.of("The light sensor module has both analog and digital output pins.","It can be used to detect the intensity of light.","The sensitivity of the sensor can be adjusted using a potentiometer."),
  List.of("The working voltage of the light sensor module is between 3.3V and 5V DC.","The detection angle is about 60 degrees.","The sensor can detect light intensity ranging from 500 to 10,000 lux.")
);
```

Can Acess component based on 
```java
Optional<Component> findByComponentId(String componentId);
```

## Prerequisites
Before running the application, make sure you have the following prerequisites installed on your system:

- Java Development Kit (JDK) 8 or later
- MongoDB

## Getting Started

- Clone the repository :

```bash
git clone https://github.com/sasankaweera123/Hardware_Store_API.git
```
- Open the project in your favorite Java IDE.
- Update the MongoDB configuration in the `application.properties` file located in the `src/main/resources` directory :

```properties
spring.data.mongodb.authentication-database=admin
spring.data.mongodb.username=rootuser
spring.data.mongodb.password=rotpass
spring.data.mongodb.database=springboot
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
spring.data.mongodb.auto-index-creation=true
```
Make sure to replace the values with your actual MongoDB configuration.
- Build the project using Maven or your IDE's build functionality.
- Run the application. This can be done by executing the `main` method in the `Application` class or using your IDE's run configuration.
- Once the application is running, you can access the API endpoints using a REST client or a browser.

## API Endpoints

The following API endpoints are available:

- GET
   - `/api/v1/component/all` : Retrieves all components.
   - `/api/v1/component/{componentId}` : Retrieves a component by its ID.
- POST
  - `/api/v1/component` : Adds a new component.
- DELETE
  - `/api/v1/component/{componentId}`: Deletes a component by its ID.
- PUT
  - `/api/v1/component/{componentId}`: Updates a component by its ID.
 
#### Includes the following additional configurations:

- **CommandLineRunner** : This bean is used to insert sample data into the database when the application starts. It retrieves the `ComponentRepository` bean and saves a sample component if it doesn't already exist.
- **WebMvcConfigurer** : This bean is used to configure Cross-Origin Resource Sharing (CORS) to allow requests from different origins. It enables all methods, headers, and origins using the `addCorsMappings` method.

## Contributing

Contributions to this project are welcome. You can fork the repository, make changes, and submit a pull request. Please make sure to follow the existing code style and conventions.

## LICENSE

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Acknowledgements

This project was developed as part of a learning exercise and is not intended for production use.
