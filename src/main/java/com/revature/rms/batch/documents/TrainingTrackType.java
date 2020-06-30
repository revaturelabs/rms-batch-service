package com.revature.rms.batch.documents;

import com.revature.rms.core.exceptions.EnumMappingException;

import java.util.Arrays;

public enum TrainingTrackType {

    STANDARD("Standard"),
    CLIENT_SPECIFIC("Client Specific"),
    SPECIALIZED("Specialized");

    private String typeName;

    TrainingTrackType(String name) {
        this.typeName = name;
    }

    public static TrainingTrackType findTrainingTrackTypeByName(String name) {
        return Arrays.stream(TrainingTrackType.values())
                    .filter(type -> type.typeName.equals(name))
                    .findFirst()
                    .orElseThrow(EnumMappingException::new);
    }
}
