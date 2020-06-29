package com.revature.rms.batch.services;

import com.revature.rms.batch.documents.Batch;
import com.revature.rms.batch.repos.BatchRepository;
import com.revature.rms.core.services.ResourceService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BatchService extends ResourceService<Batch> {

    private BatchRepository batchRepo;

    public BatchService(BatchRepository repo, ReactiveMongoTemplate template) {
        super(repo, template, Batch.class);
        this.batchRepo = repo;
    }

}
