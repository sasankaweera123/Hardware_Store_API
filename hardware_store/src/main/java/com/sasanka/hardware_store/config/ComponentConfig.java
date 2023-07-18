package com.sasanka.hardware_store.config;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Repository.ComponentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ComponentConfig {

    @Bean
    CommandLineRunner runner(ComponentRepository repository){
        return args -> {
            // save demo data after start

            ArrayList<String> componentId = new ArrayList<>();
            ArrayList<Component> component = new ArrayList<>();

            for (int i = 1; i <= 100; i++) {
                componentId.add("C" + String.format("%04d", i));
            }

            component.add(new Component(
                    componentId.get(0),
                    "Light Sensor",
                    "Light sensor module is used to detect the intensity of light. It has both analog output pin and digital output pin labeled as AO and DO respectively on the board. This sensor module is designed to detect and measure various physical properties, such as temperature, humidity, pressure, light intensity and more.",
                    "https://raw.githubusercontent.com/RPSTD/component101/main/LightSensor/IMG/IMG.png",
                    List.of("K0001","K0002" ),
                    List.of("Connect the LDR to the analog input pin 0 on the Arduino board.", "Connect the VCC leg on the sensor to the 5V pin of the Arduino board.", "Connect the GRD leg on the sensor to the GND pin of the Arduino board.", "A connection diagram is provided to illustrate the connections."),
                    List.of("When there is light, the resistance of LDR becomes low according to the intensity of light.","This means when the light level decreases, the resistance of the LDR increases.", "The resistance of LDR is inversely proportional to the intensity of light.","Light sensors are a type of photodetector (also called photosensor) that detect light.","Different types of light sensors can be used to measure illuminance, respond to changes in the amount of light received, or convert light to electricity."),
                    List.of("The light sensor module has both analog and digital output pins.","It can be used to detect the intensity of light.","The sensitivity of the sensor can be adjusted using a potentiometer."),
                    List.of("The working voltage of the light sensor module is between 3.3V and 5V DC.","The detection angle is about 60 degrees.","The sensor can detect light intensity ranging from 500 to 10,000 lux."),
                    List.of("S0001","S0002","S0003","S0004","S0005"))
            );

            component.add(new Component(
                    componentId.get(1),
                    "Temperature Sensor",
                    "Temperature sensor module is used to detect the temperature. It has both analog output pin and digital output pin labeled as AO and DO respectively on the board. This sensor module is designed to detect and measure various physical properties, such as temperature, humidity, pressure, light intensity and more.",
                    "https://raw.githubusercontent.com/RPSTD/component101/main/TemperatureSensor/IMG/IMG.png",
                    List.of("K0001","K0002" ),
                    List.of("Connect the temperature sensor to the analog input pin 0 on the Arduino board.", "Connect the VCC leg on the sensor to the 5V pin of the Arduino board.", "Connect the GRD leg on the sensor to the GND pin of the Arduino board.", "A connection diagram is provided to illustrate the connections."),
                    List.of("The temperature sensor module consists of a thermistor whose resistance changes according to the temperature.","The resistance of the thermistor decreases as the temperature increases.","The resistance of the thermistor increases as the temperature decreases.","The resistance of the thermistor is inversely proportional to the temperature."),
                    List.of("The temperature sensor module has both analog and digital output pins.","It can be used to detect the temperature.","The sensitivity of the sensor can be adjusted using a potentiometer."),
                    List.of("The working voltage of the temperature sensor module is between 3.3V and 5V DC.","The detection angle is about 60 degrees.","The sensor can detect temperature ranging from -55 to 125 degrees Celsius."),
                    List.of("S0001","S0002","S0003","S0004","S0005"))
            );

            for (int i = 0; i < component.size(); i++) {
                int finalI = i;
                repository.findByComponentId(componentId.get(i)).ifPresentOrElse(
                        value -> System.out.println("Component already exists "+ componentId.get(finalI)),
                        () -> repository.insert(component.get(finalI))
                );
            }
        };
    }
}
