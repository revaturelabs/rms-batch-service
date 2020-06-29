package com.revature.rms.batch.config;

import com.revature.rms.batch.repos.BatchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class MockDataInitializer implements CommandLineRunner {

    private BatchRepository batchRepo;

    public MockDataInitializer(BatchRepository repo) {
        this.batchRepo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

    }

}