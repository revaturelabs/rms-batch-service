package com.revature.rms.batch.services;

import com.revature.rms.batch.documents.TrainingTrack;
import com.revature.rms.batch.repos.TrainingTrackRepository;
import com.revature.rms.core.services.ResourceService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrainingTrackService extends ResourceService<TrainingTrack> {

    private TrainingTrackRepository trainingTrackRepo;

    public TrainingTrackService(TrainingTrackRepository repo, ReactiveMongoTemplate template) {
        super(repo, template, TrainingTrack.class);
        this.trainingTrackRepo = repo;
    }

}
