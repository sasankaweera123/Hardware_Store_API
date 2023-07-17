package com.sasanka.hardware_store.config;

import com.sasanka.hardware_store.Document.Admin;
import com.sasanka.hardware_store.Repository.AdminUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@AllArgsConstructor
public class AdminUserConfig {

    @Bean
    CommandLineRunner runnerAdminUser(AdminUserRepository adminUserRepository){
        return args -> {
            ArrayList<Admin> adminUsers = new ArrayList<>();
            ArrayList<String> adminUserIds = new ArrayList<>();

            for(int i = 1; i < 10; i++){
                adminUserIds.add("A" + String.format("%04d", i));
            }

            adminUsers.add(new Admin(adminUserIds.get(0),"admin", "admin"));
            adminUsers.add(new Admin(adminUserIds.get(1),"admin2", "admin2"));

            for (Admin adminUser : adminUsers) {
                String username = adminUser.getUsername();
                String existingUser = String.valueOf(adminUserRepository.findByUsername(username));

                switch (existingUser) {
                    case "admin":
                        System.out.println("Admin already exists");
                        break;
                    case "admin2":
                        System.out.println("Admin2 already exists");
                        break;
                    default:
                        adminUserRepository.insert(adminUser);
                        break;
                }
            }
        };
    }

}
