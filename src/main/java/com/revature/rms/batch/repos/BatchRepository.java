package com.revature.rms.batch.repos;

import com.revature.rms.batch.documents.Batch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends ReactiveMongoRepository<Batch, String> {
}
