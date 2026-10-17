package com.example.simple_crm_lite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.simple_crm_lite.model.Customer;
import com.example.simple_crm_lite.repository.CustomerRepository;

@SpringBootApplication
public class SimpleCrmLiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrmLiteApplication.class, args);
	}

	//Note: The if (customerRepository.count() == 0) check 
	// means the 3 sample customers are only added 
	// when the customer table is empty. 
	// You will use this in Part 5 to prove that your data persists.
	@Bean
    CommandLineRunner loadSampleData(CustomerRepository customerRepository) {
        return args -> {
            if (customerRepository.count() == 0) {
                customerRepository.save(new Customer("Bruce", "Wayne",
                        "bruce@wayneenterprises.com", "11122233", "CEO", 1975));
                customerRepository.save(new Customer("Diana", "Prince",
                        "diana@themyscira.gov", "22233344", "Ambassador", 1980));
                customerRepository.save(new Customer("Clark", "Kent",
                        "clark@dailyplanet.com", "33344455", "Reporter", 1978));
                System.out.println("✅ Sample data loaded: 3 customers added");
            }
        };
    }

}
