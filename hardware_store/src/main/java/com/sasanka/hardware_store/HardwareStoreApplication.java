package com.sasanka.hardware_store;

import com.sasanka.hardware_store.Document.Component;
import com.sasanka.hardware_store.Repository.ComponentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HardwareStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HardwareStoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ComponentRepository repository){
		return args -> {
			// save demo data after start
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

			repository.findByComponentId(componentId).ifPresentOrElse(
					value -> System.out.println("Component already exists"),
					() -> repository.insert(component)
			);
		};
	}

}
