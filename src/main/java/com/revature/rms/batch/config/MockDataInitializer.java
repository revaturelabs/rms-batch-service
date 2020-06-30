package com.revature.rms.batch.config;

import com.revature.rms.batch.documents.Batch;
import com.revature.rms.batch.documents.TrainingTrack;
import com.revature.rms.batch.documents.TrainingTrackType;
import com.revature.rms.batch.repos.BatchRepository;
import com.revature.rms.batch.repos.TrainingTrackRepository;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("dev")
@Configuration
public class MockDataInitializer implements CommandLineRunner {

    protected BatchRepository batchRepo;
    protected TrainingTrackRepository trainingTrackRepo;

    public MockDataInitializer(BatchRepository batchRepo, TrainingTrackRepository trackRepo) {
        this.batchRepo = batchRepo;
        this.trainingTrackRepo = trackRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("INIT DATA SOURCE");

        Map<String, ResourceMetadata> metadataMap = generateMockResourceMetadata();
        Map<String, List<String>> batchAssociatesMap = generateMockBatchAssociateIds();

        TrainingTrack javaMsa = new TrainingTrack("5ef52de2f21f22f1d2333c13", "Full Stack Java with Microservices", "Java",
                TrainingTrackType.STANDARD, "https://app.revature.com/admin-v2/curriculum/shared/detail/a23cb78e31bf81e61671c5f750aba25a",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/e4ed6cceffc8b4894e9215b355e06e89", metadataMap.get("admin"));

        TrainingTrack jwa = new TrainingTrack("5ef52de2f21f22f1d2333c14", "Java with Automation", "JWA", TrainingTrackType.STANDARD,
                "https://app.revature.com/admin-v2/curriculum/shared/detail/b1b07dc26abba9e809f5d615abdeb0f0",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/d13cc56baf1f5d63ed1ddf2e19d891db",
                metadataMap.get("admin"));

        TrainingTrack dotNet = new TrainingTrack("5ef52de2f21f22f1d2333c15", "Microsoft .NET", ".NET", TrainingTrackType.STANDARD,
                "https://app.revature.com/admin-v2/curriculum/shared/detail/0ce8fd40b53a8a54091a2dbb22389955",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/208b656d9ce8d10a56df950baff40b87",
                metadataMap.get("admin"));

        TrainingTrack pega = new TrainingTrack("5ef52de2f21f22f1d2333c16", "Pega", "Pega", TrainingTrackType.STANDARD,
                "https://app.revature.com/admin-v2/curriculum/shared/detail/af65dd95367e43a79d650260d1a66ab5",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/cc9465c5481ceb383e570da00f1aa033",
                metadataMap.get("admin"));

        TrainingTrack salesforce = new TrainingTrack("5ef52de2f21f22f1d2333c17", "Salesforce CRM", "Salesforce",
                TrainingTrackType.STANDARD, "https://app.revature.com/admin-v2/curriculum/shared/detail/3c12d7cff0be3db66c727f566a830c67",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/afeb5289a0df169e00e1f15b714c6890",
                metadataMap.get("admin"));

        TrainingTrack ba = new TrainingTrack("5ef52de2f21f22f1d2333c18", "Business Analysis", "BA", TrainingTrackType.STANDARD,
                "https://app.revature.com/admin-v2/curriculum/shared/detail/c8a999823ea89f962e00f3d8c35e0bf5",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/27908d631d4836836c2289988383dc48",
                metadataMap.get("admin"));

        TrainingTrack javaReact = new TrainingTrack("5ef52de2f21f22f1d2333c19", "Java/Microservices with React", "Java React",
                TrainingTrackType.STANDARD, "https://app.revature.com/admin-v2/curriculum/shared/detail/82cefcbdfd722663f948d090c01e476e",
                "https://app.revature.com/admin-v2/curriculum/shared/summary/8c479d790e6c04c95d44a1b353f94f1d",
                metadataMap.get("admin"));

        trainingTrackRepo.saveAll(Arrays.asList(javaMsa, jwa, dotNet, pega, salesforce, ba, javaReact)).then().block();

        Batch batch1 = new Batch("5e768de2f21b4b41d22d3c00", "200406-java-react-usf", LocalDateTime.of(2020, Month.APRIL, 6, 9, 0),
                LocalDateTime.of(2020, Month.JUNE, 26, 17, 0), "5e768d0ef21b4b41fbbd3c5d", null, batchAssociatesMap.get("batch1"),
                javaReact.getId(), metadataMap.get("batch1"));

        Batch batch2 = new Batch("5e768de2f21b4b41d22d3c01", "200504-java-usf", LocalDateTime.of(2020, Month.MAY, 4, 9, 0),
                LocalDateTime.of(2020, Month.JULY, 10, 17, 0), "5e768d0ef21b4b41fbbd3c5b", null, batchAssociatesMap.get("batch2"),
                javaMsa.getId(), metadataMap.get("batch2"));

        Batch batch3 = new Batch("5e768de2f21b4b41d22d3c02", "200727-java-react-usf", LocalDateTime.of(2020, Month.JULY, 27, 9, 0),
                LocalDateTime.of(2020, Month.OCTOBER, 16, 17, 0), "5e768d0ef21b4b41fbbd3c5d", null, batchAssociatesMap.get("batch3"),
                javaReact.getId(), metadataMap.get("batch3"));

        batchRepo.saveAll(Arrays.asList(batch1, batch2, batch3)).then().block();

        System.out.println("DATA SOURCE INIT COMPLETE");

    }

    /**
     * This logic is here to improve the readability of mock data generation. The IDs referenced here should
     * correspond to actual AppUser IDs from the rms-auth-service.
     *
     * @return a map containing string keys that reference pre-made ResourceMetadata objects
     */
    protected Map<String, ResourceMetadata> generateMockResourceMetadata() {

        Map<String, ResourceMetadata> mockMetadata = new HashMap<>();

        // creator: admin, owner: admin, isActive: true
        mockMetadata.put("admin", new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b64"));

        // creator: admin, owner: Wezley S., isActive: false
        mockMetadata.put("batch1", new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b67", false));

        // creator: admin, owner: Nick J., isActive: true
        mockMetadata.put("batch2", new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b68"));

        // creator: admin, owner: Wezley S., isActive: false
        mockMetadata.put("batch3", new ResourceMetadata("5e70e8e8d798ce32e0ce9b64", "5e70e8e8d798ce32e0ce9b67", false));

        return mockMetadata;

    }

    /**
     * This logic is here to improve the readability of mock data generation. The IDs referenced here should
     * correspond to actual Employee IDs from the rms-employee-service.
     *
     * @return a map containing string keys that reference pre-made Lists of Employee ID strings
     */
    protected Map<String, List<String>> generateMockBatchAssociateIds() {

        Map<String, List<String>> mockAssociates = new HashMap<>();

        mockAssociates.put("batch1", Arrays.asList("5e768d0ef21b4b41fbbd3c69", "5e768d0ef21b4b41fbbd3c6a",
                "5e768d0ef21b4b41fbbd3c6b", "5e768d0ef21b4b41fbbd3c6c", "5e768d0ef21b4b41fbbd3c6d",
                "5e768d0ef21b4b41fbbd3c6e", "5e768d0ef21b4b41fbbd3c6f", "5e768d0ef21b4b41fbbd3c70",
                "5e768d0ef21b4b41fbbd3c71", "5e768d0ef21b4b41fbbd3c72", "5e768d0ef21b4b41fbbd3c73",
                "5e768d0ef21b4b41fbbd3c74", "5e768d0ef21b4b41fbbd3c75"));

        mockAssociates.put("batch2", Arrays.asList("5e768d0ef21b4b41fbbd3c76", "5e768d0ef21b4b41fbbd3c77",
                "5e768d0ef21b4b41fbbd3c78", "5e768d0ef21b4b41fbbd3c79", "5e768d0ef21b4b41fbbd3c7a",
                "5e768d0ef21b4b41fbbd3c7b"));

        mockAssociates.put("batch3", Arrays.asList("5e768d0ef21b4b41fbbd3c7c", "5e768d0ef21b4b41fbbd3c7d",
                "5e768d0ef21b4b41fbbd3c7e", "5e768d0ef21b4b41fbbd3c7f", "5e768d0ef21b4b41fbbd3c80",
                "5e768d0ef21b4b41fbbd3c81", "5e768d0ef21b4b41fbbd3c82"));


        return mockAssociates;

    }

}