package com.revature.rms.batch.documents;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document
@JsonPropertyOrder({
    "id",
    "trackName",
    "abbrName",
    "type",
    "detailedCurriculumURL",
    "highLevelCurriculumURL",
    "metadata"
})
public class TrainingTrack extends Resource {

    @NotEmpty
    private String trackName;

    @NotEmpty
    private String abbrName;

    @NotNull
    private TrainingTrackType type;

    @NotEmpty
    private String detailedCurriculumURL;

    @NotEmpty
    private String highLevelCurriculumURL;

    public TrainingTrack() {
        super();
    }

    public TrainingTrack(@NotEmpty String trackName, @NotEmpty String abbrName, @NotNull TrainingTrackType type,
                         @NotEmpty String detailedCurriculumURL, @NotEmpty String highLevelCurriculumURL,
                         @NotNull ResourceMetadata metadata) {
        this.trackName = trackName;
        this.abbrName = abbrName;
        this.type = type;
        this.detailedCurriculumURL = detailedCurriculumURL;
        this.highLevelCurriculumURL = highLevelCurriculumURL;
        this.metadata = metadata;
    }

    public TrainingTrack(String id, @NotEmpty String trackName, @NotEmpty String abbrName, @NotNull TrainingTrackType type,
                         @NotEmpty String detailedCurriculumURL, @NotEmpty String highLevelCurriculumURL,
                         @NotNull ResourceMetadata metadata) {
        this(trackName, abbrName, type, detailedCurriculumURL, highLevelCurriculumURL, metadata);
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public TrainingTrack setTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public TrainingTrack setAbbrName(String abbrName) {
        this.abbrName = abbrName;
        return this;
    }

    public TrainingTrackType getType() {
        return type;
    }

    public TrainingTrack setType(TrainingTrackType type) {
        this.type = type;
        return this;
    }

    public String getDetailedCurriculumURL() {
        return detailedCurriculumURL;
    }

    public TrainingTrack setDetailedCurriculumURL(String detailedCurriculumURL) {
        this.detailedCurriculumURL = detailedCurriculumURL;
        return this;
    }

    public String getHighLevelCurriculumURL() {
        return highLevelCurriculumURL;
    }

    public TrainingTrack setHighLevelCurriculumURL(String highLevelCurriculumURL) {
        this.highLevelCurriculumURL = highLevelCurriculumURL;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingTrack that = (TrainingTrack) o;
        return Objects.equals(trackName, that.trackName) &&
                Objects.equals(abbrName, that.abbrName) &&
                type == that.type &&
                Objects.equals(detailedCurriculumURL, that.detailedCurriculumURL) &&
                Objects.equals(highLevelCurriculumURL, that.highLevelCurriculumURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackName, abbrName, type, detailedCurriculumURL, highLevelCurriculumURL);
    }

    @Override
    public String toString() {
        return "TrainingTrack{" +
                "trackName='" + trackName + '\'' +
                ", abbrName='" + abbrName + '\'' +
                ", type=" + type +
                ", detailedCurriculumURL='" + detailedCurriculumURL + '\'' +
                ", highLevelCurriculumURL='" + highLevelCurriculumURL + '\'' +
                '}';
    }

}
