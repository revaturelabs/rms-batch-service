package com.revature.rms.batch.controllers;

import com.revature.rms.batch.documents.TrainingTrack;
import com.revature.rms.batch.services.TrainingTrackService;
import com.revature.rms.core.controllers.ResourceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracks")
public class TrainingTrackController extends ResourceController<TrainingTrack> {

    private TrainingTrackService trainingTrackService;

    public TrainingTrackController(TrainingTrackService service) {
        super(service);
        this.trainingTrackService = service;
    }

}
