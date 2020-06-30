package com.revature.rms.batch.config;

import com.revature.rms.batch.documents.Batch;
import com.revature.rms.batch.documents.Curriculum;
import com.revature.rms.batch.repos.BatchRepository;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Profile("dev")
@Configuration
public class MockDataInitializer implements CommandLineRunner {

    private BatchRepository batchRepo;

    public MockDataInitializer(BatchRepository repo) {
        this.batchRepo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("INIT DATA SOURCE");

        // creator: admin, owner: wezley s
        ResourceMetadata batch1_metadata = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b67", false);
        List<String> batch1_associates = Arrays.asList("5e768d0ef21b4b41fbbd3c69", "5e768d0ef21b4b41fbbd3c6a",
                "5e768d0ef21b4b41fbbd3c6b", "5e768d0ef21b4b41fbbd3c6c", "5e768d0ef21b4b41fbbd3c6d",
                "5e768d0ef21b4b41fbbd3c6e", "5e768d0ef21b4b41fbbd3c6f", "5e768d0ef21b4b41fbbd3c70",
                "5e768d0ef21b4b41fbbd3c71", "5e768d0ef21b4b41fbbd3c72", "5e768d0ef21b4b41fbbd3c73",
                "5e768d0ef21b4b41fbbd3c74", "5e768d0ef21b4b41fbbd3c75");

        Batch batch1 = new Batch("5e768de2f21b4b41d22d3c00", "200406-java-react-usf", LocalDateTime.of(2020, Month.APRIL, 6, 9, 0),
                LocalDateTime.of(2020, Month.JUNE, 26, 17, 0), "5e768d0ef21b4b41fbbd3c5d", null, batch1_associates,
                Curriculum.JAVA_REACT, batch1_metadata);

        // creator: admin, owner: nick j
        ResourceMetadata batch2_metadata = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b68");
        List<String> batch2_associates = Arrays.asList("5e768d0ef21b4b41fbbd3c76", "5e768d0ef21b4b41fbbd3c77",
                "5e768d0ef21b4b41fbbd3c78", "5e768d0ef21b4b41fbbd3c79", "5e768d0ef21b4b41fbbd3c7a",
                "5e768d0ef21b4b41fbbd3c7b");

        Batch batch2 = new Batch("5e7h38dk2lk98ce32e0cf9c01", "200504-java-usf", LocalDateTime.of(2020, Month.MAY, 4, 9, 0),
                LocalDateTime.of(2020, Month.JULY, 10, 17, 0), "5e768d0ef21b4b41fbbd3c5b", null, batch2_associates,
                Curriculum.JAVA_MSA, batch2_metadata);

        // creator: admin, owner: wezley s
        ResourceMetadata batch3_metadata = new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b67", false);
        List<String> batch3_associates = Arrays.asList("5e768d0ef21b4b41fbbd3c7c", "5e768d0ef21b4b41fbbd3c7d",
                "5e768d0ef21b4b41fbbd3c7e", "5e768d0ef21b4b41fbbd3c7f", "5e768d0ef21b4b41fbbd3c80",
                "5e768d0ef21b4b41fbbd3c81", "5e768d0ef21b4b41fbbd3c82");

        Batch batch3 = new Batch("5e7h38dk2lk98ce32e0cf9c02", "200727-java-react-usf", LocalDateTime.of(2020, Month.JULY, 27, 9, 0),
                LocalDateTime.of(2020, Month.OCTOBER, 16, 17, 0), "5e768d0ef21b4b41fbbd3c5d", null, batch3_associates,
                Curriculum.JAVA_REACT, batch3_metadata);

        batchRepo.saveAll(Arrays.asList(batch1, batch2, batch3)).then().block();

        System.out.println("DATA SOURCE INIT COMPLETE");

    }

}