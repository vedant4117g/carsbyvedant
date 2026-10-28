package com.vedant.cars.config;

import com.vedant.cars.model.Car;
import com.vedant.cars.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(Arrays.asList(
                    new Car("BMW", "M340i xDrive", "Sedan", "₹ 74.90 Lakh", "3.0L Turbo Inline-6", "382 hp", "4.4s", "250 km/h", "https://images.unsplash.com/photo-1555215695-3004980ad54e"),
                    new Car("BMW", "M5 Competition", "Super Sedan", "₹ 1.99 Crore", "4.4L Twin-Turbo V8", "617 hp", "3.3s", "305 km/h", "https://images.unsplash.com/photo-1580273916550-e323be2ae537"),
                    new Car("BMW", "M8 Competition Coupe", "Grand Tourer", "₹ 2.44 Crore", "4.4L Twin-Turbo V8", "617 hp", "3.2s", "305 km/h", "https://images.unsplash.com/photo-1617814076367-b759c7d7e738"),
                    new Car("BMW", "M4 Competition", "Coupe", "₹ 1.53 Crore", "3.0L Twin-Turbo Inline-6", "503 hp", "3.5s", "290 km/h", "https://images.unsplash.com/photo-1607604276583-eef5d076aa5f"),
                    new Car("Porsche", "911 GT3 RS", "Track Coupe", "₹ 3.51 Crore", "4.0L Naturally Aspirated Flat-6", "518 hp", "3.2s", "296 km/h", "https://images.unsplash.com/photo-1614162692292-7ac56d7f7f1e"),
                    new Car("Porsche", "Taycan Turbo S", "Electric Sport", "₹ 2.69 Crore", "Dual Permanent Magnet Motors", "750 hp", "2.8s", "260 km/h", "https://images.unsplash.com/photo-1503376780353-7e6692767b70"),
                    new Car("Audi", "RS7 Sportback", "Sportback", "₹ 2.24 Crore", "4.0L Twin-Turbo V8", "591 hp", "3.6s", "305 km/h", "https://images.unsplash.com/photo-1603584173870-7f23fdae1b7a"),
                    new Car("Audi", "RS e-tron GT", "Electric GT", "₹ 2.05 Crore", "Dual Electric Motors", "637 hp", "3.3s", "250 km/h", "https://images.unsplash.com/photo-1617788138017-80ad40651399"),
                    new Car("Mercedes-AMG", "GT 63 S E Performance", "4-Door Coupe", "₹ 3.30 Crore", "4.0L V8 Biturbo Hybrid", "831 hp", "2.9s", "316 km/h", "https://images.unsplash.com/photo-1618843479313-40f8afb4b4d8"),
                    new Car("Mercedes-AMG", "G 63", "Performance SUV", "₹ 3.60 Crore", "4.0L Twin-Turbo V8", "577 hp", "4.5s", "240 km/h", "https://images.unsplash.com/photo-1520031441872-265e4ff70366"),
                    new Car("Ferrari", "296 GTB", "Mid-Engine Hybrid", "₹ 5.40 Crore", "3.0L Twin-Turbo V6 Hybrid", "819 hp", "2.9s", "330 km/h", "https://images.unsplash.com/photo-1583121274602-3e2820c69888"),
                    new Car("Ferrari", "SF90 Stradale", "PHEV Supercar", "₹ 7.50 Crore", "4.0L Twin-Turbo V8 + 3 Motors", "986 hp", "2.5s", "340 km/h", "https://images.unsplash.com/photo-1592198084033-aade902d1aae"),
                    new Car("Lamborghini", "Huracán Tecnica", "Coupe", "₹ 4.04 Crore", "5.2L Naturally Aspirated V10", "631 hp", "3.2s", "325 km/h", "https://images.unsplash.com/photo-1511919884226-fd3cad34687c"),
                    new Car("Lamborghini", "Revuelto", "V12 Hybrid", "₹ 8.89 Crore", "6.5L V12 + 3 Electric Motors", "1001 hp", "2.5s", "350 km/h", "https://images.unsplash.com/photo-1544829099-b9a0c07fad1a"),
                    new Car("McLaren", "750S", "Supercar", "₹ 5.91 Crore", "4.0L Twin-Turbo V8", "740 hp", "2.8s", "332 km/h", "https://images.unsplash.com/photo-1621135802920-133df287f89c"),
                    new Car("Aston Martin", "DB12", "Super Tourer", "₹ 4.59 Crore", "4.0L Twin-Turbo V8", "671 hp", "3.6s", "325 km/h", "https://images.unsplash.com/photo-1605559424843-9e4c228bf1c2")
                ));
                System.out.println(">>> 16 Performance Cars loaded into MariaDB successfully! <<<");
            }
        };
    }
}
