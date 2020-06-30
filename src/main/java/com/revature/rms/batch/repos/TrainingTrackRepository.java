package com.revature.rms.batch.repos;

import com.revature.rms.batch.documents.TrainingTrack;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTrackRepository extends ReactiveMongoRepository<TrainingTrack, String> {
}
