package com.revature.rms.batch.controllers;

import com.revature.rms.batch.documents.Batch;
import com.revature.rms.batch.services.BatchService;
import com.revature.rms.core.controllers.ResourceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batches")
public class BatchController extends ResourceController<Batch> {

    private BatchService batchService;

    public BatchController(BatchService service) {
        super(service);
        this.batchService = service;
    }

}
